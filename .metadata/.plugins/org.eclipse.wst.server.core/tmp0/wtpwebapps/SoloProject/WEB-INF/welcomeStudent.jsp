<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".examInitiator").click(function() {
			window.open("start_exam?examId="+this.id);
		})
	})
</script>
</head>
<body>

	<div id="navbar" class="navbar navbar-fixed-top navbar-inverse">
		<span id="headerText">Welcome ${user.firstName} ${user.lastName }</span>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Student Profile</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</div>
	
	<div style="width: 80%; margin-left:auto; margin-right:auto">
	

		<c:if test="${not empty examList}">
			<div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Available Exams</h3>
            </div>
            <div class="panel-body">
              <table id="examTable" class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Author</th>
						<th>Time to Complete</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${examList}" var="exam">
					<c:if test="${exam.isDeleted() == 0}">
						<tr id="${exam.id}">
							<td><strong>${ exam.title }</strong></td>
							<td>${ exam.creator.firstName }</td>
							<td>${ exam.timer/60 }mins</td>
							<td><button class="examInitiator btn btn-default" id="${exam.id}">Start
									Exam</button></td>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
            </div>
          </div>
		</c:if>

		<br/><br/>
		
		<c:if test="${not empty resultList}">
		<div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Your exam results</h3>
            </div>
            <div class="panel-body">
              <table id="resultTable" class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Correct</th>
						<th>Mark</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resultList}" var="result">
					<c:if test="${result.exam.isDeleted() == 0}">
						<tr>
							<td><strong>${ result.exam.title }</strong></td>
							<td>${ result.getCorrect() } out of ${ result.getTotal() }</td>
							<td>${ result.calculateResult() }%</td>
							<c:choose>
								<c:when test="${ result.passed() == true }">
									<td style="color: green">Pass</td>
								</c:when>
								<c:otherwise>
									<td style="color: red">Fail</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
            </div>
          </div>
		</c:if>
		
		<br />
	</div>
</body>
</html>