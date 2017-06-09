<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Timer</title>
<script src="${pageContext.request.contextPath}/resources/js/core/jquery.1.10.2.min.js"></script>
<script type="text/javascript">
var intId;
function startTimer(duration, display) {
    var start = Date.now(),
        minutes,
        diff,
        seconds;
    function timer() {
        // get the number of seconds that have elapsed since startTimer() was called
        diff = duration - (((Date.now() - start) / 1000) | 0);

        // does the same job as parseInt truncates the float
        minutes = (diff / 60) | 0;
        seconds = (diff % 60) | 0;

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.text(minutes + ":" + seconds); 

        if (diff <= 0) {
            // add one second so that the count down starts at the full duration
            // example 05:00 not 04:59
            clearInterval(intId);
            $('#div1').html("done...");
            //start = Date.now() + 1000;
        }
    };
    // we don't want to wait a full second before the timer starts
    timer();
    intId = setInterval(timer, 1000);
}

$(document).ready(function(){
	var totalTime = 60 * Number('${maxTime}');
	//var totalTime = 5;
    display = $('#time');
    startTimer(totalTime, display);
});
</script>
</head>
<body>
	<div id="div1">Registration closes in <span id="time"></span> minutes!</div>
</body>
</html>