<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Form</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  		<script src="<c:url value="/resources/js/user.js" />"></script>
		<link href="<c:url value="/resources/js/core/main.css" />" rel="stylesheet">
		<style type="text/css">
			.error {
				color: red;
			}
			.success {
				color: green;
			}
			.modal-header, h4, .close {
   				background-color: #5cb85c;
      			color:white !important;
      			text-align: center;
      			font-size: 30px;
  			}
  			.modal-footer {
      			background-color: #f9f9f9;
  			}
		</style>
	</head>
	<body>
		<div id="createUserError" class="error"></div>
		<div id="createUserSuccess" class="success"></div>
		<sf:form id="createUserForm" method="post" action="createUser" modelAttribute="u">
			<sf:errors path="firstname" element="div" cssClass="error" />
			<sf:label path="firstname">Firstname: </sf:label>
			<sf:input path="firstname" />
			<br/>
			<sf:errors path="lastname" element="div" cssClass="error" />
			<sf:label path="lastname">Lastname: </sf:label>
			<sf:input path="lastname" />
			<br/>
			<sf:errors path="username" element="div" cssClass="error" />
			<sf:label path="username">Username: </sf:label>
			<sf:input path="username" />
			<br/>
			<sf:errors path="password" element="div" cssClass="error" />
			<sf:label path="password">Password: </sf:label>
			<sf:password path="password" />
			<br/>
			<input id="subBtn" type="button" value="Create User">
		</sf:form>
		<hr/>
		<button id="refreshBtn" class="btn btn-default btn-lg">Refresh</button>
		<br/><br/>
		<div id="userData">
			<table id="userTable" class="table table-striped">
    			<tr>
        			<th>ID</th>
        			<th>Firstname</th>
        			<th>Lastname</th>
        			<th>Username</th>
        			<th>Password</th>
        			<th><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></th>
        			<th><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></th>
    			</tr>
			</table>
		</div>
		
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header" style="padding:35px 50px;">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4><span class="glyphicon glyphicon-user"></span> Edit User</h4>
		        </div>
		        <div class="modal-body" style="padding:40px 50px;">
		          <form role="form" method="post" action="updateUser">
		          	<input type="hidden" id="userId">
		            <div class="form-group">
		              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
		              <input type="text" class="form-control" id="modalUsername" placeholder="Enter username">
		            </div>
		            <div class="form-group">
		              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
		              <input type="password" class="form-control" id="modalPassword" placeholder="Enter password">
		            </div>
		            <div class="form-group">
		              <label for="firstname"><span class="glyphicon glyphicon-user"></span> Firstname</label>
		              <input type="text" class="form-control" id="modalFirstname" placeholder="Enter Firstname">
		            </div>
		            <div class="form-group">
		              <label for="lastname"><span class="glyphicon glyphicon-user"></span> Lastname</label>
		              <input type="text" class="form-control" id="modalLastname" placeholder="Enter lastname">
		            </div>
		          </form>
	              <button id="modalSubmitBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Update</button>
		        </div>
		        <div class="modal-footer">
		          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
		        </div>
		      </div>
		    </div>
		  </div>
	</body>
</html>