<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style type="text/css">
td {
	padding: 10px;
}

table {
	border: 1px solid gray;
	background-color: #EEE;
}

body {
	width: 80%;
	margin-left: auto;
	margin-right: auto;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	function goToNext(ans) {
		$('<form action="next" method="POST">'
				+ '<input type="hidden" name="ans" value="' + ans + '">'
				+ '<input type="hidden" name="time" value="' + $("#timer").text() + '">'
				+ '</form>').appendTo($(document.body)).submit();
	}
	

	$(document).ready(function() {
		$(".alert").hide()

		$(".btn").click(function() {
			if (this.name.toLowerCase() == this.value) {
				$(".alert-success").fadeIn();
				
				setTimeout(function(){
					goToNext(true)
				}, 1000);
			} else {
				$(".alert-danger").fadeIn();
				setTimeout(function(){
					goToNext(false)
				}, 2000);
			}

		})

	})
	
	setInterval(function(){ 
		$("#timer").text(parseInt($("#timer").text())-1)
		if ($("#timer").text() <= 0){
			goToNext(false);
		}
}, 1000);
	
	
</script>
<title>${ exam.title }</title>
</head>
<body>
	<h2>${ exam.title }</h2>
	<h4 id="timer" style="text-align:right">${time}</h4>
	<pre>${ question.getQuestion() }</pre>
	<center>

		<table>
			<tr>
				<td><button class="btn btn-info"
						name="${question.getCorrectAnswer()}" value="a">A</button></td>
				<td><button class="btn btn-info"
						name="${question.getCorrectAnswer()}" value="b">B</button></td>
				<td><button class="btn btn-info"
						name="${question.getCorrectAnswer()}" value="c">C</button></td>
				<td><button class="btn btn-info"
						name="${question.getCorrectAnswer()}" value="d">D</button></td>
			</tr>
		</table>

	</center>
	<br />
	<div class="alert alert-success" role="alert">
		<strong>Correct!</strong>
	</div>
	<div class="alert alert-danger" role="alert">
		<strong>Wrong!</strong> the answer is ${question.getCorrectAnswer()}
	</div>
	<br />
	<div class="progress">
		<div class="progress-bar" role="progressbar"
			aria-valuenow="${questionCount}" aria-valuemin="0"
			aria-valuemax="${exam.getNumOfQuestions()}" style="width: ${100 * questionCount / exam.getNumOfQuestions()}%;">
		</div>
	</div>

</body>
</html>