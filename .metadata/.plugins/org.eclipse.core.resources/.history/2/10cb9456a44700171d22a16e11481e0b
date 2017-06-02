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
	function deleteExam(id) {
		$('<form action="delete" method="POST">'
			+ '<input type="hidden" name="examId" value="' + id + '">'
			+ '</form>').appendTo($(document.body)).submit();
		}

	$(document).ready(function() {
		$(".examInitiator").click(function() {
			window.open("start_exam?examId=" + this.id);
		})

		$("#resultTable").hide()
		$(".examResultBtn").click(function() {
			$("#resultTable").show()
			$(".resultRow").hide()
			$(".result_" + this.id).show();
		})

		$(".examDelete").click(function() {
			if (confirm("Do you want to delete " + this.name + "?") == true) {
				deleteExam(this.id);
			}
		})

	})
</script>
</head>
<body>

	<div id="navbar" style="background-color: #22A"
		class="navbar navbar-fixed-top navbar-inverse">
		<span id="headerText">Welcome ${user.firstName} ${user.lastName }</span>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#">Teacher Profile</a></li>
			<li><a href="logout">Logout</a></li>
		</ul>
	</div>

	<div style="width: 80%; margin-left: auto; margin-right: auto">


		<c:if test="${not empty examList}">
			<div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Exams you have created</h3>
            </div>
            <div class="panel-body">
              <table class="table" id="examTable">
				<tbody>
					<c:forEach items="${examList}" var="exam">
					<c:if test="${exam.isDeleted() == 0}">
						<tr id="${exam.id}">
							<td><strong>${ exam.title }</strong></td>
							<td><button class="examResultBtn btn btn-default"
									id="${exam.id}">View Results</button></td>
							<td><button class="examInitiator btn btn-default"
									id="${exam.id}">Test Run</button></td>
							<td><button class="examDelete btn btn-default"
									id="${exam.id}" name="${exam.title}">Delete</button></td>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
            </div>
          </div>
		</c:if>

		<center>
			<a href="createExam.jsp" class="btn btn-primary btn-lg" id="createExamBtn"
				style="margin: 25px" target="_blank">Create A New Exam</a>
		</center>

		<c:if test="${not empty examList}">
			<div id="resultTable" class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Submitted Results</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th>Title</th>
								<th>Student</th>
								<th>Correct</th>
								<th>Mark</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${examList}" var="exam">
								<c:forEach items="${exam.results}" var="result">
									<tr class="resultRow result_${exam.id}">
										<td><strong>${ result.exam.title }</strong></td>
										<td>${ result.user.firstName } ${ result.user.lastName }</td>
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
								</c:forEach>
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