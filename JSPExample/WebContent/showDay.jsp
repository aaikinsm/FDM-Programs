<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Day</title>
</head>
<body>
	<%-- <%
		int dayOfWeek = (Integer) request.getAttribute("dayOfWeek");
	%>
	<p>Today is the <%= dayOfWeek %>
	<%
		if (dayOfWeek == 1 )
			out.write("st");
		else if (dayOfWeek == 2 )
			out.write("nd");
		else if (dayOfWeek == 3 )
			out.write("rd");
		else 
			out.write("th");
		%> day of the week.
	</p> --%>
	
	<p>Today is the ${ dayOfWeek }
	<c:choose>
		<c:when test="${ dayOfWeek == 1 }">st</c:when>
		<c:when test="${ dayOfWeek == 2 }">nd</c:when>
		<c:when test="${ dayOfWeek == 3 }">rd</c:when>
		<c:otherwise>th</c:otherwise>
	</c:choose>
	day of the week
	</p>
	<br/>
	<ul>
	<c:forEach items="${countries}" var="country">
		<li>${ country }</li>
	</c:forEach>
	<br/>
	<c:forEach begin="1" end="10" step="2" var="i">
		<c:out value="${i}"></c:out>
	</c:forEach>
	<br/>
	<c:forTokens items="El, Ma, Fan, Be, Ho" delims="," var="name">
		<li>${name}</li>
	</c:forTokens>
	</ul>
	
	<c:if test="${ 'Test' eq 'tesgr' }">They are equal</c:if>
	
</body>
</html>