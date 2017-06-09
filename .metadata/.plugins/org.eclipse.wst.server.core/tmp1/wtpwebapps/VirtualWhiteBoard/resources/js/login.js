$(document).ready(function() {

	var correctNameInput = false;
	var validate1 = false, validate2 = false, validate3 = false;
	var validate4 = false, validate5 = false, validate6 = false;
	
	$('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
	$('#register-submit').prop('disabled', true);

	$('#newUsername, #firstname, #lastname').keyup(function() {
		var username = $('#newUsername').val();
		var firstname = $('#firstname').val();
		var lastname = $('#lastname').val();
		
		
		if (username.match(/\s/g) || username.match(/[^a-zA-Z0-9\-\/]/)) {
			$('#foundSpace1').show();
			correctNameInput = false;
		} else if (firstname.match(/\s/g) || firstname.match(/[^a-zA-Z0-9\-\/]/)) {
			$('#foundSpace2').show();
			correctNameInput = false;
		} else if (lastname.match(/\s/g) || lastname.match(/[^a-zA-Z0-9\-\/]/)) {
			$('#foundSpace3').show();
			correctNameInput = false;
		} else {
			$('#foundSpace1').hide();
			$('#foundSpace2').hide();
			$('#foundSpace3').hide();
			correctNameInput = true;
		}
		
		//Check that all validations are successful
		if(correctNameInput && validate1 && validate2 && validate3 && validate4 && validate5 && validate6){
			$('#register-submit').prop('disabled', false);
		}else{
			$('#register-submit').prop('disabled', true);
		}
	});
	
	$('input[type=password]').keyup(function() {
		var pswd = $(this).val();

		//validate the length
		if (pswd.length < 8) {
			validate1 = false;
			$('#length').removeClass('valid').addClass('invalid');
		} else {
			validate1 = true;
			$('#length').removeClass('invalid').addClass('valid');
		}

		//validate letter
		if (pswd.match(/[A-z]/)) {
			validate2 = true;
			$('#letter').removeClass('invalid').addClass('valid');
		} else {
			validate2 = false;
			$('#letter').removeClass('valid').addClass('invalid');
		}

		//validate capital letter
		if (pswd.match(/[A-Z]/)) {
			validate3 = true;
			$('#capital').removeClass('invalid').addClass('valid');
		} else {
			validate3 = false;
			$('#capital').removeClass('valid').addClass('invalid');
		}

		//validate number
		if (pswd.match(/\d/)) {
			validate4 = true;
			$('#number').removeClass('invalid').addClass('valid');
		} else {
			validate4 = false;
			$('#number').removeClass('valid').addClass('invalid');
		}
		
		//validate spaces
		if (pswd.match(/\s/g)) {
			validate5 = false;
			$('#space').removeClass('valid').addClass('invalid');
		} else {
			validate5 = true;
			$('#space').removeClass('invalid').addClass('valid');
		}
		
		//validate both passwords
		var newPassword = $("#newPassword").val();
		var confirmPassword = $("#confirmPassword").val();
		
		if (newPassword == confirmPassword) {
			validate6 = true;
			$('#match').removeClass('invalid').addClass('valid');
		}
		else {
			validate6 = false;
			$('#match').removeClass('valid').addClass('invalid');
		}

		//Check that all validations are successful
		if(correctNameInput && validate1 && validate2 && validate3 && validate4 && validate5 && validate6){
			$('#register-submit').prop('disabled', false);
		}else{
			$('#register-submit').prop('disabled', true);
		}
		
		
	}).focus(function() {
		$('#pswd_info').show();
	}).blur(function() {
		$('#pswd_info').hide();
	});

});