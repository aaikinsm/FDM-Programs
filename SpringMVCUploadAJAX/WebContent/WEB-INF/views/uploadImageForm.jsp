<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>Upload Image</title>
	<script src="<c:url value="/resources/js/core/jquery.1.10.2.min.js" />"></script>
</head>
<body>
    <br>
    <br>
    <div align="center">
        <h1>Create Thumbnail</h1>
 
        <sf:form method="post" action="saveImage"
            modelAttribute="uploadForm" enctype="multipart/form-data">
 
            <p>Select an image file to upload.</p>
 
            <table id="fileTable">
                <tr>
                    <td><input name="files[0]" type="file" /></td>
                </tr>
            </table>
            <br />
            <input type="submit" value="Upload" />
        </sf:form>
 
        <br />
    </div>
</body>
</html>