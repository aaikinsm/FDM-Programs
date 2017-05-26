<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
th {
	background-color: #DDF;
}

h1 {
	text-align: center;
}

th, td {
	padding: 15px;
}

tr:hover {
	background-color: #f5f5f5
}

table {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>Welcome ${user.firstName} ${user.lastName }</h1>
	<c:if test="${not empty examList}">
		<h4>Available Exams</h4>
		<table id="examTable">
			<thead>
				<th>Title</th>
				<th>Author</th>
				<th>Time to Complete</th>
				<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${examList}" var="exam">
					<tr id="${exam.id}">
						<td><strong>${ exam.title }<strong></td>
						<td>${ exam.creator.firstName }</td>
						<td>${ exam.timer/60 }mins</td>
						<td><button>Start Exam</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<br />
	<c:if test="${not empty resultList}">
		<h4>Your exam results</h4>
		<table id="resultTable">
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
					<tr>
						<td><strong>${ result.exam.title }<strong></td>
						<td>${ result.getCorrect() }outof ${ result.getTotal() }</td>
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
			</tbody>
		</table>
	</c:if>
	<br />
	<a href="logout">logout</a>
</body>
</html>