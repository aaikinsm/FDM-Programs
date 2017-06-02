<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome ${user.firstname} ${user.lastname} to the world of MVC</h1>
	<h2>Calculate</h2>
	<form action="calculate" method="get">
	<input type="text" name="num1"><br/>
	<input type="text" name="num2"><br/>
	<input type="submit"><br/>
	</form>
	<br/>
	<a href="logout">Logout</a>
</body>
</html>