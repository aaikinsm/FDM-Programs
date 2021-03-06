<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#sbm").click(function(event){
			console.log("click")
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : "addMessage",
				data : JSON.stringify({
					userId : 1,
					chatId : 1,
					message : document.getElementById("inputID").value
					}),
				dataType : 'json',
				timeout : 100000,
				headers: {
		            "Accept": "application/json",
		            "Content-Type": "application/json"
		        },
		        beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        },
				success : function(data) {
					console.log("SUCCESS: ", data);
					$("#createUserError").html("");
					$("#createUserSuccess").html("");
					if (data !== 'undefined'){
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
					$("#createUserError").html("<h1>Cannot get the user.</h1>");
					$("#createUserSuccess").html("");
				},
				done : function(e) {
					console.log("DONE");
				}
			});
		});
		console.log("initializing")
		

	});
	var encodeURL = encodeURIComponent("getMessages?userIdStr=1&chatId=1");
	if(typeof(EventSource) !== "undefined") {	
	    var source = new EventSource("getMessages?userIdStr=85&chatIdStr=92");
	    
	    source.onmessage = function(event) {
	    	console.log("run")
	    	var data = $.parseJSON(event.data);
	    	console.log(data);
	    };
	} else {
		$("#sseDiv").html("Your browser does not support server-sent events.");
	}
	</script>
	
	
</head>
<body>
<%
com.fdmgroup.model.User user = new com.fdmgroup.model.User();
user.setUsername("dddd");
session.setAttribute("user", user);

%>
	<sf:form method="post">
		<input id = "inputID" type = text name = "message">
		<input id = "sbm" type="submit" value="storeMessage" />
	</sf:form>
	
	<div id="sent"></div>
</body>
</html>