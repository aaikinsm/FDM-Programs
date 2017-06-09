<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Window</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="resources/js/chat.js"></script>
<link rel="stylesheet" href="resources/css/chat.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>

<!-- <div class="container"> -->
<div class="chatmaster">
    <div class="row">
        <div class="col-md-offset-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment"></span> Chat
                </div>
                <div class="panel-body">
                    <ul class="chat" id="chatMsg">
<%--                     <c:forEach items="${messages}" var="message"> --%>
                        <%-- <li class="left clearfix"><span class="chat-img pull-left">
                            <img src="https://image.flaticon.com/icons/png/128/149/149452.png" width="40px" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">jdoe${ message.user.username }</strong> 
                                    	<small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span>2017:6:7:15:33:20${ message.timestamp }
                                        </small>
                                </div>
                                    The first message
                                    ${ message.content }
                                
                            </div>
                        </li> --%>

<%--                     </c:forEach> --%>
                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                    <form  action="addMessage" method="post" id="chatForm">
                    	<span class="input-group-btn">
	                        <input id="message-content" type="text" class="form-control input-sm" name="messageSent" placeholder="Type your message here...">
	                        <input id="message-author" type="hidden" class="form-control input-sm" name="userId" value="6">
	                        <input id="chat" type="hidden" class="form-control input-sm" name="chatId" value="12">
	                        <button class="btn btn-warning btn-sm" id="btn-chat" type="submit">Send</button>
                        </span>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>