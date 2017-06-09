function refresh(){
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getAllUsers",
		data : JSON.stringify(),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			display(data);
		},
		error : function(e) {
			console.log("ERROR: ", e);
			display(e);
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function removeUser(id){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "removeUser",
		data : JSON.stringify({
			uId : id
			}),
		dataType : 'json',
		timeout : 100000,
		headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#createUserError").html("");
			$("#createUserSuccess").html("<h1>User removed.</h1>");
			
			refresh();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$("#createUserError").html("<h1>Cannot remove the user.</h1>");
			$("#createUserSuccess").html("");
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function editUser(){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "updateUser",
		data : JSON.stringify({
			uId : $('#userId').val(),
			firstname : $('#modalFirstname').val(),
			lastname : $('#modalLastname').val(),
			username : $('#modalUsername').val(),
			password : $('#modalPassword').val()
			}),
		dataType : 'json',
		timeout : 100000,
		headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#createUserError").html("");
			$("#createUserSuccess").html("<h1>User data updated.</h1>");
			
			$('#myModal').modal('toggle');
			refresh();
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$("#createUserError").html("<h1>Cannot update user data.</h1>");
			$("#createUserSuccess").html("");
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function getUser(id){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "getUser",
		data : JSON.stringify({
			uId : id
			}),
		dataType : 'json',
		timeout : 100000,
		headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
		success : function(data) {
			console.log("SUCCESS: ", data);
			$("#createUserError").html("");
			$("#createUserSuccess").html("");
			if (data !== 'undefined'){
				$('#userId').val(data.id);
				$('#modalUsername').val(data.username);
				$('#modalPassword').val(data.password);
				$('#modalFirstname').val(data.firstname);
				$('#modalLastname').val(data.lastname);

				$("#myModal").modal();
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$("#createUserError").html("<h1>Cannot get the user.</h1>");
			$("#createUserSuccess").html("");
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

function display(data) {
	/*var json = "<h4>Ajax Response</h4><pre>"
			+ JSON.stringify(data, null, 4) + "</pre>";
	$('#userData').html(json);*/
	
	if(data){
        var len = data.length;
        var txt = "";
        if(len > 0){
        	$("#userTable").html("<table id=\"userTable\" class=\"table table-striped\">" +
    			"<tr>" +
    			"<th>ID</th>" +
    			"<th>Firstname</th>" +
    			"<th>Lastname</th>" +
    			"<th>Username</th>" +
    			"<th>Password</th>" +
    			"<th><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></th>" +
    			"<th><span class=\"glyphicon glyphicon-remove-sign\" aria-hidden=\"true\"></span></th>" +
    			"</tr>" +
    			"</table>");
            for(var i = 0; i < len; i++){
                txt += "<tr><td>" + data[i].id + "</td><td>" + data[i].firstname + "</td><td>" + data[i].lastname + "</td><td>" + data[i].username + "</td><td>" + data[i].password + "</td><td><a href=\"#\"><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\" onclick=\"getUser(" + data[i].id + ");\"></span></a></td><td><a href=\"#\"><span class=\"glyphicon glyphicon-remove-sign\" aria-hidden=\"true\" onclick=\"removeUser(" + data[i].id + ");\"></span></a></td></tr>";
            }
            if(txt != ""){
                $("#userTable").append(txt);
                //$("#userTable").append(txt).removeClass("hidden");
            }
        }
	}
}

$(document).ready(function(){
	
	$("#refreshBtn").click(function(){
		refresh();
	});
	
	$("#subBtn").click(function(event){
		
		/*var firstname = $('#firstname').val();
	    var lastname = $('#lastname').val();
	    var username = $('#username').val();
	    var password = $('#password').val();
	    var jsonString = {"firstname" : firstname, "lastname" : lastname, "username": username, "password": password};
	    console.log(JSON.stringify(jsonString));*/
		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "createUser",
			data : JSON.stringify({
				firstname : $('#firstname').val(),
				lastname : $('#lastname').val(),
				username : $('#username').val(),
				password : $('#password').val()
				}),
			dataType : 'json',
			timeout : 100000,
			headers: {
	            "Accept": "application/json",
	            "Content-Type": "application/json"
	        },
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
			success : function(data) {
				console.log("SUCCESS: ", data);
				$('#firstname').val("");
				$('#lastname').val("");
				$('#username').val("");
				$('#password').val("");
				$("#createUserError").html("");
				$("#createUserSuccess").html("<h1>New user added.</h1>");
				
				refresh();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				$("#createUserError").html("<h1>Cannot create a new user.</h1>");
				$("#createUserSuccess").html("");
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	});
	
	$("#modalSubmitBtn").click(function(){
        editUser();
    });
	
	//In case of handling click event on span elements, we need to use $(document).on(event, selector, function) instead of $(selector).click(function)
	/*$(document).on('click', '.glyphicon.glyphicon-remove-sign', function(id){
		console.log("removing user with id: " + id);
	});*/
	
});