<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Login</title>
<style>
.error {
	color: red;
}
.form-signin {
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
</style>
</head>
<body>
	<div class="container">
	<sf:form action="processLogin" method="post" modelAttribute="user"  class="form-signin">
	<h1>Login</h1>
	<h2 class="error">${errorMsg}</h2>
		<sf:errors path="username" cssClass="error" element="div"></sf:errors>
		<sf:label path="username">Username</sf:label>
		<sf:input path="username" />
		<br />
		<sf:errors path="password" cssClass="error" element="div"></sf:errors>
		<sf:label path="password">Password</sf:label>
		<sf:input path="password" />
		<br />
		<input type="submit" value="Login" class="btn btn-lg btn-primary btn-block"/>
	</sf:form>
	</div>
	

</body>
</html>