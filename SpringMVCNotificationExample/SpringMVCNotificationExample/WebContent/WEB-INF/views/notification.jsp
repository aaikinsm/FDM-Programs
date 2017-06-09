<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Notification (SSE)</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="<c:url value="/resources/js/notification.js" />"></script>
	</head>
	<body>
		<nav class="navbar navbar-right">
		  <div class="container-fluid">
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li class="dropdown">
		          <button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-envelope" aria-hidden="true"><span class="badge" id="messageBadge">0</span></span></button>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		<p>Testing Notifications.....</p>
		<div id="sseDiv"></div>
	</body>
</html>