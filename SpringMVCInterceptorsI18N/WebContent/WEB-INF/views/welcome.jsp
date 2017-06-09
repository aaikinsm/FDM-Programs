<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><s:message code="general.welcome" /></title>
		<style type="text/css">
		    *:lang(fa) { direction:rtl }
		    *:lang(en) { direction:ltr }
		</style>
	</head>
	<body>
		<s:message code="general.changeLanguage" />: <a href="?language=en">English</a>|<a href="?language=fa">Persian</a>
		<br/>
		<h1><s:message code="general.welcome" /> <c:out value="${user.firstname} ${user.lastname}"/>!!</h1>
		<a href="home">Home</a><br/>	
		<a href="showCalc">Calculator</a><br/>
		<a href="logout">Logout</a><br/>
		<br/>
		<s:message code="general.selectedLanguage" /> : ${pageContext.response.locale}
	</body>
</html>