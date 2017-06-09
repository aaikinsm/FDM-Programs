<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Form</title>
		<style type="text/css">
		    *:lang(fa) { direction:rtl }
		    *:lang(en) { direction:ltr }
		</style>
	</head>
	<body>
	
		<s:message code="general.changeLanguage" />: <a href="?language=en">English</a>|<a href="?language=fa">Persian</a>
		 
		<br/>
		<br/>
		<sf:form method="get" action="calc" modelAttribute="calculator">
			<s:message code="calculate.number" /> 1: <sf:input path="num1" /><br/>
			<s:message code="calculate.number" /> 2: <sf:input path="num2" /><br/>
			<s:message code="calculate.calc" var="calc" />
			<input type="submit" value="${calc}">
		</sf:form>
		<br/>
		<s:message code="general.selectedLanguage" />: ${pageContext.response.locale}
	</body>
</html>