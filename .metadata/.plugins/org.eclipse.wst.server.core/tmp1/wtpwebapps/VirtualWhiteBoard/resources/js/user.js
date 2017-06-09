function refresh(){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "getOwnedRooms",
		data : JSON.stringify({
			uId : $('#currentUserId').val(),	
		}),
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

function updateUser(){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "updateUser",
		data : JSON.stringify({
			uId : $('#currentUserId').val(),
			email : $('#updateEmail').val(),
			firstname : $('#updateFirstname').val(),
			lastname : $('#updateLastname').val()
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
			
			refresh();
			
			$('#updateUserModal').modal('toggle');
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


function createRoom(){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "createRoom",
		data : JSON.stringify({
			uId : $('#currentUserId').val(),
			roomName : $('#roomName').val(),
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
			$("#createRoomError").html("");
			$("#createRoomSuccess").html("<h1>Room Created!.</h1>");
			
			refresh();
			$('#createRoomModal').modal('toggle');
		},
		error : function(e) {
			console.log("ERROR: ", e);
			$("#createRoomError").html("<h1>Cannot Create Room.</h1>");
			$("#createRoomSuccess").html("");
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
        	
        	$("#ownedRoomTable").html(
        		"<table id=\"ownedRoomTable\" class=\"table table-striped\">" +
    			"<tr>" +
    			"<th>Room Name</th>" +
    			"<th>Status</th>" +
    			"<th># of Users</th>" +
    			"<th>Date Created</th>" +
    			"<th><span class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></span></th>" +
    			"</tr>" +
    			"</table>");
            for(var i = 0; i < len; i++){
                txt += "<tr><td>" + data[i].name + "</td><td>" + data[i].status + "</td><td>" +  data[i].invitedUsers + "</td><td>" + new Date(data[i].timeCreated).toString() + "</td><td><a href=\"#\"><span class=\"glyphicon glyphicon-remove-sign\" aria-hidden=\"true\" onclick=\"removeUser(" + data[i].id + ");\"></span></a></td></tr>";
            }                                                                               
            if(txt != ""){
                $("#ownedRoomTable").append(txt);
                //$("#userTable").append(txt).removeClass("hidden");
            }
            
            
        }
        $('#ownedRoomTable').DataTable();
        /*else{
        	$("#result").html("inside else");
        }*/
	}
}




$(document).ready(function() {
	
	refresh();
	
	$('#ownedRoomTable').DataTable();
	
	$('#invitedRoomTable').DataTable();
	
	$("#refreshBtn").click(function(){
		refresh();
	});
	
	
	$("#viewUsername").click(function(){
		$("#viewUsername").setCustomValidity("Message");
	});
	
	
	$("#updateUserModalSubmitBtn").click(function(){
        updateUser();
    });
	
	$("#createRoomModalSubmitBtn").click(function(){
		createRoom();
	});
	
	
	

});