<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process</title>
</head>
<body>
	Number 1 is: <c:out value="${param.num1}"></c:out>
	Number 2 is: <c:out value="${param.num2}"></c:out>
	
	<jsp:useBean id="cal" class="com.fdmgroup.model.Calculator">
		<jsp:setProperty property="a" name="cal" value="${param.num1}"/>
		<jsp:setProperty property="b" name="cal" value="${param.num2}"/>
	</jsp:useBean>
	
	<p>This add result is ${cal.add()}</p>
	<p>This sub result is ${cal.sub()}</p>
	<p>This mul result is ${cal.mul()}</p>
	<p>This div result is ${cal.divide()}</p>
</body>
</html>