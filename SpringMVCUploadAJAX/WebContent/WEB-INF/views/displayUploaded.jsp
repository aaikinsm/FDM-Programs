<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Upload Multiple Files</title>
</head>
<body>
    <br>
    <br>
    <div align="center">
        <h1>Following files are uploaded successfully.</h1>
        <ol>
           	<c:forEach items="${files}" var="file">
	        	<li>
           			${file}
           		</li>
           	</c:forEach>
        </ol>
        <br />
        <br />
    </div>
</body>
</html>