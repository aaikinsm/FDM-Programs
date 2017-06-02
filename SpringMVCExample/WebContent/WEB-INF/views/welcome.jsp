<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	.error{
		color:red;
	}
</style>
<title>Welcome</title>
</head>
<body>
	<h1>Welcome ${user.firstname} ${user.lastname} to the world of MVC</h1>
	<h2>Calculate</h2>
	<sf:form action="calculate" method="get" modelAttribute="calc">
	<sf:errors path="num1" cssClass="error" element="div"></sf:errors>
	<sf:label path="num1">Number 1</sf:label>
	<sf:input path="num1"/><br/>
	<sf:errors path="num2" cssClass="error" element="div"></sf:errors>
	<sf:label path="num2">Number 2</sf:label>
	<sf:input path="num2"/><br/>
	<input type="submit" value="Calculate"><br/>
	</sf:form>
	<br/>
	<a href="logout">Logout</a>
</body>
</html>