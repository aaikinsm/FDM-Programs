<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.error {
	color: red;
}
</style>
</head>
<c:choose>
	<c:when test="${not empty cookie.bgColor.value}">
		<body bgColor="${cookie.bgColor.value }">
	</c:when>
	<c:otherwise>
		<body bgColor="white">
	</c:otherwise>
</c:choose>
<body>
	<h1>Login</h1>
	<h2 class="error">${errorMsg}</h2>
	<form action="login" method="post">
		username: <input type="text" name="username"><br /> password:
		<input type="password" name="password"><br /> <input
			type="submit" name="login">

	</form>
	<br />
	<c:choose>
		<c:when test="${empty userCounter}">
			<h3>Currently we have 0 user(s) online</h3>
		</c:when>
		<c:otherwise>
			<h3>Currently we have ${userCounter} user(s) online</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>