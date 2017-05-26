<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
	</head>
	<body>
		<%!
			String s = "Hello World";
		%>
		<h1> The random number is: 
			<%
				Random r = new Random();
				int rVal = r.nextInt(100);
			%>
			<%= rVal %>
		</h1>
		<p>All the even numbers between 0 and 100:</p>
		<%
			for(int i = 0 ; i <=100; i++){
				if (i % 2 == 0 )
					out.write(i+", ");
			}
		%>
		<br/>
		<h1>String reverse</h1>
		<p>Original text: <%= s %></p>
		<p>Reverse:
		<%
			StringBuilder sb = new StringBuilder(s);
			out.write(sb.reverse().toString());
			
		%>
		
		<br/>
		<a href="home">Login</a>
		<a href="day">Show Day</a>
	</body>
</html>