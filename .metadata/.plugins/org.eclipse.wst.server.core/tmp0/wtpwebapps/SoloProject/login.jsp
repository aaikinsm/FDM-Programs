<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#registerContainer").hide()
		$("#b1").click(function() {
			$("#eMsg").text("")
			$("#loginContainer").fadeOut()
			$("#registerContainer").fadeIn()
		})
	})
</script>
</head>
<body id="loginRegisterContainer">
		<h1>Online Exam System</h1><br/>
		<div class="container" id="loginContainer">

			<form class="form-signin well" action="login" method="post">
				<h2 class="form-signin-heading">Please sign in</h2>
				<h4 class="error">${errorMsg}</h4>
				<input type="text" id="username" name="username"
					class="form-control" placeholder="Username" required="required" />
				<input type="password" id="inputPassword" name="password"
					class="form-control" placeholder="Password" required="required" />
				<br />
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				<br />
				<center>
					<button id="b1" class="btn btn-primary btn-link">or Register</button>
				</center>
			</form>

		</div>

		<div class="container" id="registerContainer">

			<form class="form-signin well" action="register" method="post">
				<h2 class="form-signin-heading">Enter Your Information Below</h2>
				<h4 class="error" id="eMsg">${errorMsg}</h4>
				<input type="text" id="username" name="username"
					class="form-control" placeholder="Username" required="required" />
				<input type="password" id="inputPassword" name="password"
					class="form-control" placeholder="Password" required="required" />
				<input type="text" id="firstname" name="firstname"
					class="form-control" placeholder="First name" required="required" />
				<input type="text" id="lastname" name="lastname"
					class="form-control" placeholder="Last name" required="required" />
				<br />
				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
			</form>

		</div>

</body>
</html>