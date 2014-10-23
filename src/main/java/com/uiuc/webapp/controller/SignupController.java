package com.uiuc.webapp.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.appfuse.Constants;
import org.appfuse.dao.UserDao;
import org.appfuse.model.Role;
import org.appfuse.model.User;
import org.appfuse.service.RoleManager;
import org.appfuse.service.UserExistsException;
import org.appfuse.service.impl.PropertyLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uiuc.webapp.util.RequestUtil;

/**
 * Controller to signup new users.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping("/signup*")
public class SignupController extends BaseFormController {
	private RoleManager roleManager;

	@Autowired
	private PropertyLoaderService loaderService;

	@Autowired
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	@Autowired
	private UserDao dao;

	public SignupController() {
		setCancelView("redirect:login");
		setSuccessView("redirect:login");
	}

	@ModelAttribute("recaptcha_private_key")
	public String getPrivate() {
		String key = (String) loaderService.properties
				.get("recaptcha_private_key");
		return key;
	}

	@ModelAttribute("recaptcha_public_key")
	public String getPublic() {
		String key = (String) loaderService.properties
				.get("recaptcha_public_key");
		return key;
	}

	@ModelAttribute
	@RequestMapping(method = RequestMethod.GET)
	public User showForm() {
		return new User();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(User user, BindingResult errors,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey((String) loaderService.properties
				.get("recaptcha_private_key"));

		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr,
				challenge, uresponse);

		if (!reCaptchaResponse.isValid()) {
			errors.rejectValue(null, null, "CAPTCHA VALIDATION FAILED!!");
			return "signup";
		}
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

		if (log.isDebugEnabled()) {
			log.debug("entering 'onSubmit' method...");
		}
		Locale locale = request.getLocale();

		user.setEnabled(false);

		// Set the default user role on this new user
		user.addRole(roleManager.getRole(Constants.USER_ROLE));

		try {
			this.getUserManager().saveUser(user);
		} catch (AccessDeniedException ade) {
			// thrown by UserSecurityAdvice configured in aop:advisor
			// userManagerSecurity
			log.warn(ade.getMessage());
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		} catch (UserExistsException e) {
			errors.rejectValue("username", "errors.existing.user",
					new Object[] { user.getUsername(), user.getEmail() },
					"duplicate user");

			// redisplay the unencrypted passwords
			user.setPassword(user.getConfirmPassword());
			return "signup";
		}

		saveMessage(request,
				getText("user.registered", user.getUsername(), locale));
		request.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);

		// log user in automatically
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getConfirmPassword(),
				user.getAuthorities());
		auth.setDetails(user);
		SecurityContextHolder.getContext().setAuthentication(auth);

		// Send user an e-mail
		if (log.isDebugEnabled()) {
			log.debug("Sending user '" + user.getUsername()
					+ "' an account information e-mail");
		}

		// Send an account information e-mail
		message.setSubject(getText("signup.email.subject", locale));

		try {
			sendUserMessage(user, getText("signup.email.message", locale),
					RequestUtil.getAppURL(request));
		} catch (MailException me) {
			saveError(request, me.getMostSpecificCause().getMessage());
		}
		List<User> users = dao.getAllDistinct();
		for (User user2 : users) {
			if (user2.getRoles().contains(
					roleManager.getRole(Constants.ADMIN_ROLE))) {
				try {
					sendUserMessage(
							user2,
							"User with user id "
									+ user.getUsername()
									+ " was created. Please go online to approve this request",
							RequestUtil.getAppURL(request));
				} catch (MailException me) {
					saveError(request, me.getMostSpecificCause().getMessage());
				}

			}
		}
		return getSuccessView();
	}
}
