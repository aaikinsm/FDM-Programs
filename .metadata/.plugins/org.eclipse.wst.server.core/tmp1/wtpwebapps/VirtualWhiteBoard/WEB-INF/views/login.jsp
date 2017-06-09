<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><s:message code="login.login"/></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>	
		<script src="resources/js/login.js"></script>
	</head>
	<body>
		<s:message code="login.username" var="uname"/><s:message code="login.password" var="pword"/>
		<s:message code="login.firstname" var="fname"/><s:message code="login.lastname" var="lname"/>
		<s:message code="login.email" var="email"/><s:message code="login.confirm" var="confirm"/>
		<s:message code="login.login" var="login"/><s:message code="login.register" var="register"/>
		<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link"><s:message code="login.login"/></a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link"><s:message code="login.register"/></a>
							</div>
						</div>
						<hr>
					</div>
					
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<sf:form id="login-form" action="processLogin" method="post" modelAttribute="user" role="form" style="display: block;">
									<h4 class="error" align="center">${errorMsg1}</h4>
									<div class="form-group">
										<sf:errors path="username" cssClass="error" element="div" />
										<sf:input path="username" type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="${uname}" required="required" />
									</div>
									<div class="form-group">
										<sf:errors path="password" cssClass="error" element="div" />
										<sf:input path="password" type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="${pword}" required="required"/>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="${login}">
											</div>
										</div>
									</div>
								</sf:form>
								<sf:form id="register-form" action="processRegister" method="post" modelAttribute="user" role="form" style="display: none;">
									<h4 class="error" align="center">${errorMsg2}</h4>
									<div class="form-group">
										<p class="error" id="foundSpace1" hidden="true"><s:message code="login.noSpecialChars"/></p>
										<sf:errors path="username" cssClass="error" element="div" />
										<sf:input path="username" type="text" name="username" id="newUsername" tabindex="1" class="form-control"  placeholder="${uname}" required="required" />
									</div>
									<div class="form-group">
										<p class="error" id="foundSpace2" hidden="true"><s:message code="login.noSpecialChars"/></p>
										<sf:errors path="firstname" cssClass="error" element="div" />
										<sf:input path="firstname" type="text" name="firstname" id="firstname" tabindex="2" class="form-control" placeholder="${fname}" required="required" />
									</div>
									<div class="form-group">
										<p class="error" id="foundSpace3" hidden="true"><s:message code="login.noSpecialChars"/></p>
										<sf:errors path="lastname" cssClass="error" element="div" />
										<sf:input path="lastname" type="text" name="lastname" id="lastname" tabindex="3" class="form-control" placeholder="${lname}" required="required" />
									</div>
									<div class="form-group">
										<sf:errors path="email" cssClass="error" element="div" />
										<sf:input path="email" type="email" name="email" id="email" tabindex="4" class="form-control" placeholder="${email}" required="required" />
									</div>
									<div class="form-group">
										<sf:errors path="password" cssClass="error" element="div" />
										<sf:input path="password" type="password" name="newPassword" id="newPassword" tabindex="5" class="form-control" placeholder="${pword}" required="required" />
									</div>
									<div class="form-group">
										<input type="password" name="confirmPassword" id="confirmPassword" tabindex="6" class="form-control" placeholder="${confirm} ${pword}" required="required" >
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="7" class="form-control btn btn-register" value="${register}">
											</div>
										</div>
									</div>
									<div class="col-md-4">
									<div class="aro-pswd_info">
										<div id="pswd_info">
											<h4><s:message code="login.passwordRequirements"/></h4>
											<ul>
												<li id="letter" class="invalid"><s:message code="login.minimum"/> <strong><s:message code="login.oneLetter"/></strong></li>
												<li id="capital" class="invalid"><s:message code="login.minimum"/> <strong><s:message code="login.oneCapital"/></strong></li>
												<li id="number" class="invalid"><s:message code="login.minimum"/> <strong><s:message code="login.oneNumber"/></strong></li>
												<li id="length" class="invalid"><s:message code="login.minimum"/> <strong><s:message code="login.eightCharacters"/></strong></li>
												<li id="space" class="invalid"><s:message code="login.fields"/> <strong><s:message code="login.noSpaces"/></strong></li>
												<li id="match" class="invalid"><s:message code="login.passwords"/> <strong><s:message code="login.mustMatch"/></strong></li>
												<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
											</ul>
										</div>
									</div>
								</div>
								</sf:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	</body>
</html>