<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="resources/js/fabric.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/room.css">
		<link rel="stylesheet" type="text/css" href="resources/css/autocomplete.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="resources/js/jquery.autocomplete.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="resources/js/jscolor.js"></script>
		<script src="resources/js/canvas.js"></script>
		<title>Canvas</title>
	</head>
		<body>
			<div id="wrapper">
				<div id="chat">
				</div>


				<div id="wrapperCanvas">
					<canvas id="c" width="1600" height="720" style="border:none;"></canvas>

				</div>
			</div>
			<div id="toolbar">
				<div class="btn btn-notBtn" style="height: 50px; width: 50px;">
					<p id="penWidthVal" style="position: relative; top: 50%; margin-top: -10px; color: white;">1</p>
				</div>
				<div id="sliderDiv">
					<input type="range" id="penWidth" value="1" style="height: 20px; width: 100px; position: relative; top: 50%; margin-top: -10px;" onchange="updateWidth(this.value)">
				</div>
				<button type="button" class="btn btn-default btnTool" id="pen" onclick="setPen()">Pen</button>
				<button type="button" class="btn btn-default btnTool" id="line">Line</button>
				<button type="button" class="btn btn-default btnTool" id="rectangle">Rect</button>
				<button type="button" class="btn btn-default btnTool" id="circle">Circ</button>
				<button type="button" class="btn btn-default btnTool" id="triangle">Tri</button>
				<input class="jscolor" type="hidden" id="color_value" onchange="updateColour(this.value)" value="000000">
				<button type="button" class="btn btn-default btnTool jscolor {valueElement : 'color_value'}" id="colour">Col</button>
				<button type="button" class="btn btn-default btnTool" id="eraser" onclick="setErase()">Erase</button>
				<button type="button" class="btn btn-default btnTool" id="undo">Undo</button>
				<button type="button" class="btn btn-default btnTool" id="clear">Clear</button>
				<button type="button" class="btn btn-default btnTool" id="exit">Exit</button>
				<button type="button" class="btn btn-default btnTool" id="invite" data-toggle="modal" data-target="#inviteUsers">Invite</button>

			</div>
			

			
			<div id="inviteUsers" class="modal fade" role="dialog">
				<div class="modal-dialog">
					 <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Invite others to join this room.</h4>
		      </div>
		      		<div class="modal-body">
		        		<label for="usr">Search for users by name:</label>
		        		<form id="inviteUserForm" method="post" action="inviteUser">
  							<input type="text" class="form-control" id="w-input-search">
  							<input type="hidden" id="userId" name="userId"/>
  							<input type="hidden" id="roomUrl" name="roomUrl" value="testroom"/>
<!-- 		      			<div class="modal-footer"> --><hr>
		       				<input type="submit" class="btn btn-success btn-block" data-dismiss="modal" value="Invite"/>
<!-- 		       			<input type="submit" class="btn btn-success btn-block" value="Invite"/> -->
<!-- 		      		 	</div> -->
						</form>
		      		</div>
   					</div>
				</div>
			</div>
			<script>
			  $(document).ready(function() {
				  
					$('#w-input-search').autocomplete({
						serviceUrl: 'search',
						paramName: "query",
						delimiter: ",",
						minChars: "2",
						width: 500,
						onSearchStart: function (query) {
							$('#w-input-search').css("background", "white");
						},
						onSearchComplete: function (query, suggestions) {
							$('#w-input-search').css("background", "white");
						},
					    transformResult: function(response) {
						return {      	
						    //must convert json to javascript object before process
						    suggestions: $.map($.parseJSON(response), function(item) { 
						    $('#userId').val(item.id);
						    return { value: item.firstname + ", " + item.lastname, data: item };
						   })
				   		 };
				       },
					   onSelect: function (suggestion) {
						   $('#userId').val(suggestion.data.id);
						   $('#w-input-search').val(suggestion.data.firstname + " " + suggestion.data.lastname);
					   }
					 });
				  });
			</script>
		</body>
</html>