<%@ include file="/common/taglibs.jsp"%>

<c:if test="${pageContext.request.locale.language ne 'en'}">
	<div id="switchLocale">
		<a href="<c:url value='/?locale=en'/>"><fmt:message
				key="webapp.name" /> in English</a>
	</div>
</c:if>
<table style="width: 100%">
	<tr>


		<td colspan="1" width="33%" align="left"><img
			src="<c:url value="/images/ilogo_vert_bold.gif"/>" height="60" width="170"></td>
		<td colspan="1" width="33%" align="center"><img
			src="<c:url value="/images/download.jpg"/>" height="60" width="170">
		</td>
		<td colspan="1" width="33%" align="right"><img
			src="<c:url value="/images/ict_logo_nobg.gif"/>" height="60"
			width="170"></td>

	</tr>



</table>
<h2 align="center">
	<b><fmt:message key="webapp.name" /></b>
</h2>
<hr />

<%-- Put constants into request scope --%>
<appfuse:constants scope="request" />