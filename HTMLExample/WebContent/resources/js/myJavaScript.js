flag = true;

function printEvenNumbers(min,max){
	var text = "";
	for (i = min; i < max; i++) {
		if(i%2 == 0){
			text += i+", ";
		}
	}
	document.write(text);
	console.log("finished");
}


function checkQuery(){
	var queryElement = document.getElementById("query");
	if (queryElement.value == "Java"){
		document.getElementById("form1").submit();
	}
	else{
		var para1 = document.getElementById("para1");
		para1.innerHTML = "Error submitting the query"
	}
}

function showHide(){
	if (flag == true){
		var div1 = document.getElementById("div1")
		var showHideButton = document.getElementById("showHideBtn")
		div1.style.visibility = "hidden";
		showHideButton.value = "Show"
		flag = false;
	}
	else{
		var div1 = document.getElementById("div1")
		var showHideButton = document.getElementById("showHideBtn")
		div1.style.visibility = "visible";
		showHideButton.value = "Hide"
		flag = true;
	}
}