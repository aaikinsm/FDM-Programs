<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Uploaded Image File</title>
</head>
<body>
    <br>
    <br>
    <div align="center">
        <h1>Following image is uploaded successfully:</h1>
        <h2>
			${imageFile}
        </h2>
        <br />
        <br />
        <h2>Original Image:</h2>
        <img src="${pageContext.request.contextPath}/Uploaded Files/landscape.jpg" />
        <br/>
        <br/>
        <h2>Thumbnail Image:</h2>
        <img src="${pageContext.request.contextPath}/Thumbnails/landscape.jpg" />
    </div>
</body>
</html>