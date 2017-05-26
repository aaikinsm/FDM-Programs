<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	.error {
		color:red;
	}
</style>
<title>Error</title>
</head>
<body>
	<h1>Error occurred</h1>
	<pre class="error">
		<%
			exception.printStackTrace(new PrintWriter(out));
		%>
	</pre>
</body>
</html>