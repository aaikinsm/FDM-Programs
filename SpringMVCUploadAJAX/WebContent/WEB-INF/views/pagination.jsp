<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagination</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.min.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"> --%>
<script src="${pageContext.request.contextPath}/resources/js/core/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/datatable/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        /* "processing": true,
        "serverSide": true,
        "ajax": "pagination",
        "type": "POST" */
    } );
} );

</script>
</head>
<body>

<!-- class="table table-striped table-bordered" -->
<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Company</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${users}" var="user">
	    	<tr>
	    		<td>${user.firstname}</td>
	    		<td>${user.lastname}</td>
	    		<td>${user.company.name}</td>
	    	</tr>
    	</c:forEach>
    </tbody>
</table>
</body>
</html>