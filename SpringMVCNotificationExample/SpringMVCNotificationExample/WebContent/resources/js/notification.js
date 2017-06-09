if(typeof(EventSource) !== "undefined") {
    var source = new EventSource("getMessages");
    source.onmessage = function(event) {
    	var data = $.parseJSON(event.data);
    	$("#messageBadge").html(data.numOfMsg);
    	$("#sseDiv").html($("#sseDiv").html() + data.number + " - ");
    };
} else {
	$("#sseDiv").html("Your browser does not support server-sent events.");
}
