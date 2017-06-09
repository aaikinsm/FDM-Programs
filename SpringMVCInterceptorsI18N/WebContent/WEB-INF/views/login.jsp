<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>    
    
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Form</title>
	<style type="text/css">
	    *:lang(fa) { direction:rtl }
	    *:lang(en) { direction:ltr }
	    
	    .error { color: red; }
	</style>
	</head>
	<body>
	
		<s:message code="general.changeLanguage" />: <a href="?language=en">English</a>|<a href="?language=fa">Persian</a>
		 
		<br/>
		<br/>
		<h1><s:message code="login.hello" />!!</h1>
		<br/>
	
		<h2 style="color: red">${errorMsg}</h2>
	
		<s:message code="login.username" var="uname"/>
		<h1><s:message code="login.size" arguments="${uname}, 3, 20" argumentSeparator="," /></h1>
	
		<sf:form method="post" action="processLogin" modelAttribute="user">
			<sf:errors path="username" element="div" cssClass="error"/>
			<s:message code="login.username" var="un" />
			<s:message code="login.username" />: <sf:input path="username" placeholder="${un}" /><br/>
			<sf:errors path="password" element="div" cssClass="error"/>
			<s:message code="login.password" />: <sf:password path="password" /><br/>
			<s:message code="login.login" var="login" />
			<input type="submit" value="${login}">
		</sf:form>
		<br/>
		<s:message code="general.selectedLanguage" /> : ${pageContext.response.locale}
	</body>
</html>