<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Remarkable - User Home</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="resources/js/usernavbar.js"></script>
	
	<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

	<link rel="stylesheet" href="resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="resources/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
	
	<script src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
	
	
	<link rel="stylesheet" type="text/css" href="resources/css/user.css" />
	<script src="<c:url value="/resources/js/user.js" />"></script>

	<style type="text/css">
		body{
				background: url(http://my-smashing.smashingapps.netdna-cdn.com/wp-content/uploads/2013/04/blurbackgrounds9.jpg) no-repeat center fixed;
    			background-size: cover;
				-webkit-background-size: cover;
				-moz-background-size: cover;
  				-o-background-size: cover;
    			background-size: 100%;
			}
	</style>
	

	
</head>

<body>

	<input type="hidden" id="currentUserId" value="${user.id}">
	
	<div id="navbar" class="navbar navbar-inverse navbar-fixed-top    ">
			<div class="navbar-container " id="navbar-container">

				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<!-- <i class="fa fa-leaf"></i>                   LOGO--> 
							Remarkable Virtual White Board
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue dropdown-modal">
							<a id="profilePicArea" data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="resources/img/${user.profilePicture}" alt="Profile Photo" />
								<span class="user-info">
									<em>Welcome</em><br/>
									<strong class ="dark" >${user.firstname}</strong>
								</span>
								<i class="caret "></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#" data-toggle="modal" data-target="#viewUser" >
										<i class="glyphicon glyphicon-user"></i>
										Account Detail
									</a>
								</li>
								<li>
									<a href="#" data-toggle="modal" data-target="#updateUserModal" >
										<i class="glyphicon glyphicon-edit"></i>
										Edit Account
									</a>
								</li>
								<li>
									<a href="#" data-toggle="modal" data-target="#changePassword" >
										<i class="glyphicon glyphicon-edit"></i>
										Change Password
									</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="logout">
										<i class="glyphicon glyphicon-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>
	

	<div class="container">
		<br /> <br /> <br /> <br />
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#createRoomModal">Create Room</button>
		<button id="refreshBtn"   class="btn btn-info btn-lg pull-right" >
			<span class="glyphicon glyphicon-refresh"></span> Refresh
		</button>
	</div>
	<br />
	
	<div id="result">
	
	</div>
	
	
	<div class="container">
		<div class="input-group">
		   <input type="text" class="form-control" placeholder="Search for Rooms or Users">
		   <span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
		   </span>
		</div>
	</div>
	
	<br />

	<div class="container">

		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading panel-title">
					<h3>
						<a data-toggle="collapse" href="#ownedRoomData">Recent Rooms</a>
					</h3>
				</div>
			
				<div id="ownedRoomData" class="panel-collapse collapse in list-group panel-body">

					<table id="ownedRoomTable"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class ="text">Room Name</th>
								<th>Status</th>
								<th># of Users</th>
								<th>Date Created</th>
								<th><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></th>
    							<th><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></th>
							</tr>
						</thead>
						
						<tbody id="ownedRoomTableBody">
							<%-- <c:forEach items="${user.ownedRooms}" var="room">
								<tr>
									<td>${room.name}</td>
									<td>${room.status}</td>
									<td>${room.invitedUsers.size()}</td>
									<td>${room.timeCreated.getTime()}</td>
									<td>
										<button class ="btn btn-info btn-sm">
										<span class="glyphicon glyphicon-share"></span>
											Join Room
										</button>
									
									</td>
								</tr>
							</c:forEach> --%>
						</tbody> 
						
					</table>


			





			
				</div>
				
				
			</div>
		</div>
	</div>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading panel-title">
					<h3>
						<a data-toggle="collapse" href="#collapse2">Room Invites</a>
					</h3>
				</div>
				<div id="collapse2" class="panel-collapse collapse in list-group panel-body">
					
					
					<table id="invitedRoomTable"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th class ="text">Room Name</th>
								<th>Status</th>
								<th># of Users</th>
								<th>Date Created</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${user.invitedRooms}" var="invitedRoom">
								<tr>
									<td>${invitedRoom.name}</td>
									<td>${invitedRoom.status}</td>
									<td>${invitedRoom.owner.getFirstname()}</td>
									<td>${invitedRoom.timeCreated.getTime()}</td>
									<td>
										<button class ="btn btn-info btn-sm">
										<span class="glyphicon glyphicon-share"></span>
											Join Room
										</button>
									
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					
	
				
				
				
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
				<div class="panel-heading panel-title">
					<h3>
						<a data-toggle="collapse" href="#collapse3">Public Rooms</a>
					</h3>
				</div>
				<div id="collapse3" class="panel-collapse collapse in list-group panel-body">
				
				<div class="row list-group-item">
					<div class="col-md-3">Room Name</div><div class="col-md-3">Room URL</div><div class="col-md-3">Room Owner</div><div class="col-md-3">Date Created</div>
				</div>
					<a href="#" class="list-group-item">First item</a> 
					<a href="#" class="list-group-item">Second item</a> 
					<a href="#" class="list-group-item">Third item</a> 
					<a href="#" class="list-group-item">Fourth item</a> 
					<a href="#" class="list-group-item">Fifth item</a> 

				</div>
			</div>
		</div>
	</div>

		<div class="modal fade" id="viewUser" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-user"></span> Account Details</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
						<input type="hidden" id="userId">
						<div class="form-group">
							<label for="profilepic"><span class="glyphicon glyphicon-user"></span> Profile Picture</label>
       					</div><br />
						<div class="form-group">
							<label for="email"><span class="glyphicon glyphicon-user"></span> Username</label> <input type="text" class="form-control" id="viewUsername" placeholder="${user.username}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="firstname"><span class="glyphicon glyphicon-user"></span> Firstname</label> <input type="text" class="form-control" id=viewFirstname placeholder="${user.firstname}" readonly="readonly">
						
							<label for="lastname"><span class="glyphicon glyphicon-user"></span> Lastname</label> <input type="text" class="form-control" id="viewLastname" placeholder="${user.lastname}" readonly="readonly">
						
							<label for="lastname"><span class="glyphicon glyphicon-user"></span> Email</label> <input type="text" class="form-control" id="viewEmail" placeholder="${user.email}" readonly="readonly">
						
							<label for="lastname"><span class="glyphicon glyphicon-user"></span> Role</label> <input type="text" class="form-control" id="viewRole" placeholder="${user.role.role}" readonly="readonly">
						</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Exit Account Details</button>
				</div>
			</div>
		</div>
	</div>
<!-- 	--------------------------Update User Modal--------------------------- -->	
	<div class="modal fade" id="updateUserModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-user"></span> Edit User</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					
					<div id="createUserError" class="error"></div>
					<div id="createUserSuccess" class="success"></div>
					
							<label for="profilepic"><span class="glyphicon glyphicon-user"></span> Profile Picture</label>
							<sf:form method="post" action="saveImage" modelAttribute="uploadForm" enctype="multipart/form-data">
	            			<p>Select an image file to upload.</p>
	            			<table id="fileTable">
	                		<tr><td><input name="files[0]" type="file" accept="image/*"/></td></tr>
	           				</table>
	           				<br />
	            			<input type="submit" value="Upload" class="btn btn-info"/>
	       					</sf:form>
	       					
					<form id = "updateUserForm" role="form" method="post" action="updateUser" >
						<div class="form-group">
       					</div><br />
						<div class="form-group">
							<input type="hidden" id="currentUserId" value="${user.id}">
							<label for="updateEmail"><span class="glyphicon glyphicon-user"></span> Email</label>
							 <input type="text" class="form-control" id="updateEmail" placeholder="${user.email }">
					
							<label for="updateFirstname"><span class="glyphicon glyphicon-user"></span> Firstname</label>
							 <input type="text" class="form-control" id="updateFirstname"placeholder="${user.firstname }">
						
							<label for="updateLastname"><span class="glyphicon glyphicon-user"></span> Lastname</label>
							 <input type="text" class="form-control" id="updateLastname"placeholder="${user.lastname }">
						</div>
					</form>
					<button type="submit" id="updateUserModalSubmitBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Update</button>
					
					
					
					<br/>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				</div>
			</div>
		</div>
	</div>
	
<!-- 	--------------------------Change Password Modal--------------------------- -->	
	<div class="modal fade" id="changePassword" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-user"></span> Change Password</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" method="post" action="changePassword">
						<input type="hidden" id="userId">
						<div class="form-group">
							<label for="email"><span class="glyphicon glyphicon-user"></span> Current Password</label> <input type="password" class="form-control" id="modalEmail" placeholder="Enter your existing password">
						</div>
						<div class="form-group">
							<label for="firstname"><span class="glyphicon glyphicon-eye-close"></span> New Password</label> <input type="password" class="form-control" id="modalFirstname" placeholder="Enter new Password">
						</div>
						<div class="form-group">
							<label for="lastname"><span class="glyphicon glyphicon-eye-close"></span> New Password (Confirm)</label> <input type="password" class="form-control" id="modalLastname" placeholder="Confirm new Password">
						</div>
					</form>
					<br />
					<button id="modalSubmitBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Update Password</button>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
<!-- 	--------------------------Create Room Modal--------------------------- -->	
	
	<div class="modal fade" id="createRoomModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4><span class="glyphicon glyphicon-facetime-video"></span> Create Room</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<div id="createRoomError" class="error"></div>
					<div id="createRoomSuccess" class="success"></div>
					
					<form role="form" method="post" action="createRoom">
						<input type="hidden" id="currentUserId" value="${user.id}">
						<div class="form-group">
							<label for="roomName"><span class="glyphicon glyphicon-text-background"></span> Room Name</label> <input type="text" class="form-control" id="roomName" placeholder="Enter Room Name">
						</div>
					
					</form>
					<br />
					<button id="createRoomModalSubmitBtn" class="btn btn-success btn-block"><span class="glyphicon glyphicon-camera"></span>  Create Room!!</button>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	

		
	<script src="resources/assets/js/ace-elements.min.js"></script>
	<script src="resources/assets/js/ace.min.js"></script>
		
	
		
</body>
</html>