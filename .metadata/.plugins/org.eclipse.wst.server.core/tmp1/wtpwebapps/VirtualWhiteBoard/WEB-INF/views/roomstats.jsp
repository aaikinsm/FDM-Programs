<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Two menu - Ace Admin</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/usernavbar.js"></script>
<script type="text/javascript" src="resources/js/user.js"></script>
<script type="text/javascript" src="resources/js/roomstats.js"></script>
<script src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="resources/assets/js/ace-extra.min.js"></script>
<script src="resources/assets/js/html5shiv.min.js"></script>
<script src="resources/assets/js/respond.min.js"></script>
<link rel="stylesheet" href="resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="resources/css/user.css" />
<link rel="stylesheet" href="resources/assets/css/fonts.googleapis.com.css" />
<link rel="stylesheet" href="resources/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="resources/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="resources/assets/css/ace-ie.min.css" />
<script src="resources/assets/js/jquery-ui.custom.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="/resources/js/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default navbar-collapse ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="index.html" class="navbar-brand"> <small> <i class="fa fa-leaf"></i>Remarkable Virtual WhiteBoard - Admin - Room Statistics
				</small>
				</a>
			</div>

			<div
				class="navbar-buttons navbar-header pull-right collapse navbar-collapse"
				role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue dropdown-modal"><a id="profilePicArea"
						data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
							class="nav-user-photo" src="resources/img/default.png"
							alt="Profile Photo" /> <span class="user-info"> <em>Welcome</em><br />
								<strong class="dark">${user.firstname}</strong>
						</span> <i class="caret "></i>
					</a>
						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#" data-toggle="modal" data-target="#viewUser">
									<i class="ace-icon fa fa-cog"></i> View Profile
							</a></li>
							<li class="divider"></li>
							<li><a href="logout"> <i
									class="ace-icon fa fa-power-off"></i>Logout
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
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
				<li class=""><a href="adminhome" type="submit"> <i
						class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
							Dashboard </span>
				</a> <b class="arrow"></b></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-desktop"></i> <span class="menu-text">Notifications</span>
						<b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li class=""><a href="#" data-toggle="modal"
							data-target="#createNotification"> <i
								class="menu-icon fa fa-caret-right"></i> Create Notification
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Delete Notification
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Search Notifications
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-list"></i> <span class="menu-text">
							User Management </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Create New User
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Search Users
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class="active open"><a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text"> Statistics </span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li class=""><a href="userstats"> <i
								class="menu-icon fa fa-caret-right"></i> User Statistics
						</a> <b class="arrow"></b></li>
						<li class="active open"><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Room Statistics
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Monthly Statistics
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Weekly Statistics
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> Daily Statistics
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="menu-icon fa fa-pencil-square-o"></i> <span
						class="menu-text"> Logs </span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>
					<ul class="submenu">
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> System Logs
						</a> <b class="arrow"></b></li>
						<li class=""><a href="#"> <i
								class="menu-icon fa fa-caret-right"></i> User Logs
						</a> <b class="arrow"></b></li>
					</ul></li>
			</ul>
		</div>

		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="page-header">
						<h1>Room Statistics</h1>
					</div>
					<div class="row">
							<h3 class="header smaller lighter blue">Total Number of Rooms Created:</h3>
							<c:forEach var="room" items="${rooms}">
								<c:choose>
									<c:when test="${room.status == 'active'}">
									<c:set var="activeCount" value="${activeCount + 1}" scope="request" />
									</c:when>
									<c:otherwise>
									<c:set var="inactiveCount" value="${inactiveCount + 1}" scope="request" />
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<script type="text/javascript">
						      google.charts.load("current", {packages:["imagepiechart"]});
						      google.charts.setOnLoadCallback(drawChart);
						
						      function drawChart() {
						    	 	var active = parseInt('${activeCount}');
						    	 	var inactive = parseInt('${inactiveCount}');
						        	var data = google.visualization.arrayToDataTable([
						          ['Status', 'Number of Rooms'],
						          ['Active ('+active+')', active],
						          ['Inactive ('+inactive+')', inactive],
						        ]);
						        var chart = new google.visualization.ImagePieChart(document.getElementById('activeRooms'));
						        chart.draw(data, {width: 430, height: 240, title: 'Number of Active and Inactive Rooms'});
						      }
						    </script>
							<div id="activeRooms" style="display:block; margin:0 auto"></div>
					</div>
					<div class="row">
							<h3 class="header smaller lighter blue">Rooms Created per Day:</h3>
							
							<c:forEach var="room" items="${rooms}">
							<c:set var="time" value="${room.timeCreated.getTime()}"></c:set>
							<fmt:formatDate type="date" value="${time}" dateStyle="short" var="byDate"/>
								<c:forEach var="roomByDate" items="byDate">
								<c:out value="${byDate}"></c:out>: <c:out value="${room.name}"></c:out>
								<c:set var="roomCount" value="${roomCount + 1}" scope="request" />
								</c:forEach>
								<p>Total rooms created per day (<c:out value="${byDate}"></c:out>): <c:out value="${roomCount}"></c:out></p>
							</c:forEach>
							<c:set var="dataStuff" value="['${byDate}', ${roomCount}]" ></c:set>
							DATA STUFFFF --- <c:out value="${dataStuff}"></c:out>
							<div id="days" style="height: 400px"></div>
							
						    <script type="text/javascript">
						      google.charts.load("current", {packages:["corechart"]});
						      google.charts.setOnLoadCallback(drawChart);
						      
						      function drawChart() {
						    	var hello = '${byDate}';
						    	var hi = parseInt('${roomCount}');
						        var data = google.visualization.arrayToDataTable([
						          ['Date', 'Number of Rooms Created: '],
						          [hello, hi]]);
						        var options = {
						          title: 'Number of Rooms Created per Day',
						          legend: { position: 'none' },
						        };
						
						        var chart = new google.visualization.Histogram(document.getElementById('roomsPerDay'));
						        chart.draw(data, options);
						      }
						    </script>
						<div id="roomsPerDay" style="width: 900px; height: 500px;"></div>
						
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-xs-12">
							<h3 class="header smaller lighter blue">Average Users per Room</h3>
							<c:forEach var="room" items="${rooms}">
								<c:set var="time" value="${room.timeCreated.getTime()}"></c:set>
							</c:forEach>

							<div id="chart_div" style="height: 400px" class="pull-left"></div>
							<div id="usersPerRoom" style="height: 400px" class="pull-right"></div>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-xs-12">
							<h3 class="header smaller lighter blue">Rooms Table:</h3>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
	<script src="resources/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="resources/assets/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/ace-elements.min.js"></script>
	<script src="resources/assets/js/ace.min.js"></script>
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
	
</body>
</html>
