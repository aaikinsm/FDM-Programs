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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	function checkQInput(){
		var val = $("#question").val()
		if(val == ""){
			$("#finalSubmit").show()
		}else{
			$("#finalSubmit").hide()
		}
	}
	
	$(document).ready(function() {
		checkQInput()
	})
</script>
<title>Create Exam</title>
</head>
<body>
	<div class="container well" >

			<h3>Enter the exam information below</h3>
				<h4 class="error" id="eMsg" style="color:red">${errorMsg}</h4>
			<form action="create" method="post" class="well">
				<input type="text" id="question" name="question" class="form-control" placeholder="Question" 
					onchange="checkQInput()" onkeyup="checkQInput()" onpaste="checkQInput()" oninput="checkQInput()" required />
				<br/>
				<input type="text" name="ansA" class="form-control" placeholder="Answer (a)" required/>
				<input type="text" name="ansB" class="form-control" placeholder="Answer (b)" required/> 
				<input type="text" name="ansC" class="form-control" placeholder="Answer (c)" /> 
				<input type="text" name="ansD" class="form-control" placeholder="Answer (d)" /> 
				The Correct Answer is: 
				<input type="radio" name="correct" value="a" checked> <strong>A</strong> &nbsp &nbsp
				<input type="radio" name="correct" value="b"> <strong>B</strong> &nbsp &nbsp
				<input type="radio" name="correct" value="c"> <strong>C</strong> &nbsp &nbsp
				<input type="radio" name="correct" value="d"> <strong>D</strong>  
				<br/><br>				
				<center><button class="btn btn-primary" type="submit">Add Question</button></center>
			</form>
			<br/><br/>
			<form action="create" method="post" id="finalSubmit">	
				<input type="text" name="title" class="form-control" placeholder="Exam Title" required/> 
				<input type="number" min="1" max="1000" name="duration" placeholder="Duration in minutes" required/>
				<input type="checkbox" name="randomize" value="true"> Randomize Questions	
				<br/> <br/>				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Done</button>
			</form>
		</div>
</body>
</html>