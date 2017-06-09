<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Admin Home</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/usernavbar.js"></script>
	<script type = "text/javascript" src="resources/js/user.js"></script>
	<script src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script src="resources/assets/js/ace-extra.min.js"></script>
	<script src="resources/assets/js/html5shiv.min.js"></script>
	<script src="resources/assets/js/respond.min.js"></script>
	<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="resources/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/user.css" />
	<link rel="stylesheet" href="resources/assets/css/fonts.googleapis.com.css" />
	<link rel="stylesheet" href="resources/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
	<link rel="stylesheet" href="resources/assets/css/ace-skins.min.css" />
	<link rel="stylesheet" href="resources/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="resources/assets/css/ace-ie.min.css" />
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default navbar-collapse ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">

			<div class="navbar-header pull-left">
				<a href="index.html" class="navbar-brand">
					<small>
						<i class="fa fa-leaf"></i>Remarkable Virtual WhiteBoard - Admin Home
					</small>
				</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right collapse navbar-collapse" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue dropdown-modal">
					<a id="profilePicArea" data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="resources/img/default.png" alt="Profile Photo" />
						<span class="user-info">
							<em>Welcome</em><br/>
							<strong class ="dark" >${user.firstname}</strong>
						</span>
						<i class="caret "></i>
					</a>
						<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li>
								<a href="#" data-toggle="modal" data-target="#viewUser" >
									<i class="ace-icon fa fa-cog"></i>
									View Profile
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="logout">
									<i class="ace-icon fa fa-power-off"></i>Logout
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div><!-- /.navbar-container -->
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try{ace.settings.loadState('main-container')}catch(e){}
		</script>
		<div id="sidebar" class="sidebar responsive ace-save-state">
			<script type="text/javascript">
				try{ace.settings.loadState('sidebar')}catch(e){}
			</script>
			<ul class="nav nav-list">
				<li class="active open">
					<a href="#">
						<i class="menu-icon fa fa-tachometer"></i>
						<span class="menu-text"> Dashboard </span>
					</a>
					<b class="arrow"></b>
				</li>

				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-desktop"></i>
						<span class="menu-text">Notifications</span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="">
							<a href="#" data-toggle="modal" data-target="#createNotification">
								<i class="menu-icon fa fa-caret-right"></i>
								Create Notification
							</a>
							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								Delete Notification
							</a>
							<b class="arrow"></b>
						</li>
						<li class="#">
							<a href="jqgrid.html">
								<i class="menu-icon fa fa-caret-right"></i>
								Search Notifications
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-list"></i>
						<span class="menu-text"> User Management </span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="#">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								Create New User
							</a>
							<b class="arrow"></b>
						</li>
						<li class="#">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								Search Users
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-pencil-square-o"></i>
						<span class="menu-text"> Statistics </span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="">
							<a href="user-statistics">
								<i class="menu-icon fa fa-caret-right"></i>
								User Statistics
							</a>
							<b class="arrow"></b>
						</li>
						<li class="roomstats">
							<a href="roomstats">
								<i class="menu-icon fa fa-caret-right"></i>
								Room Statistics
							</a>
							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								Monthly Statistics
							</a>
							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								Weekly Statistics
							</a>
							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								Daily Statistics
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-pencil-square-o"></i>
						<span class="menu-text"> Logs </span>
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								System Logs
							</a>
							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="#">
								<i class="menu-icon fa fa-caret-right"></i>
								User Logs
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>
			</ul><!-- /.nav-list -->
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="page-header">
						<h1> Dashboard </h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="hidden-md hidden-lg">
								<div class="well well-sm">
									You can place multiple toggle buttons for multiple menus anywhere inside navbar!
								</div>
							</div><!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div>
		</div><!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120">
						<span class="blue bolder">Ace</span>
						Application &copy; 2013-2014
					</span>
				</div>
			</div>
		</div>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div><!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="resources/assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="resources/assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!-- ace scripts -->
	<script src="resources/assets/js/ace-elements.min.js"></script>
	<script src="resources/assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
		   $('#sidebar2').insertBefore('.page-content');
		   
		   $('.navbar-toggle[data-target="#sidebar2"]').insertAfter('#menu-toggler');
		   
		   
		   $(document).on('settings.ace.two_menu', function(e, event_name, event_val) {
			 if(event_name == 'sidebar_fixed') {
				 if( $('#sidebar').hasClass('sidebar-fixed') ) {
					$('#sidebar2').addClass('sidebar-fixed');
					$('#navbar').addClass('h-navbar');
				 }
				 else {
					$('#sidebar2').removeClass('sidebar-fixed')
					$('#navbar').removeClass('h-navbar');
				 }
			 }
		   }).triggerHandler('settings.ace.two_menu', ['sidebar_fixed' ,$('#sidebar').hasClass('sidebar-fixed')]);
		})
	</script>
	
<div class="modal fade" id="createNotification" role="dialog">
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
						</div>
						<div class="form-group">
							<label for="lastname"><span class="glyphicon glyphicon-user"></span> Lastname</label> <input type="text" class="form-control" id="viewLastname" placeholder="${user.lastname}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="lastname"><span class="glyphicon glyphicon-user"></span> Email</label> <input type="text" class="form-control" id="viewEmail" placeholder="${user.email}" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="lastname"><span class="glyphicon glyphicon-user"></span> Role</label> <input type="text" class="form-control" id="viewRole" placeholder="${user.role.role}" readonly="readonly">
						</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Exit Account Details</button>
				</div>
			</div>
		</div>
	</div>
	

	
	
	
	
	
	
	
	
	
</body>
</html>
