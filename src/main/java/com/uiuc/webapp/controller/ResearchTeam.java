package com.uiuc.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/researchTeam")
public class ResearchTeam {

	@RequestMapping(method = RequestMethod.GET)
	public void displayCharts() {

	}

}
