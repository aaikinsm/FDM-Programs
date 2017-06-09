/*if (window.EventSource) {
   console.log("Event source available");
   var source = new EventSource('systemalert?id=1');

   source.addEventListener('message', function(e) {
        console.log(e.data);
   });

   source.addEventListener('open', function(e) {
        console.log("Connection was opened.");
   }, false);

   source.addEventListener('error', function(e) {
        if (e.readyState == EventSource.CLOSED) {
            console.log("Connection was closed.");
        } else {
            console.log(e.readyState);
        }
   }, false);
} else {
        console.log("No SSE available");
}*/

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
