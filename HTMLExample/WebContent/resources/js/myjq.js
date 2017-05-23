$(document).ready(function(){
	var flag = true;
	var prgflag = true;
	$("#b1").click(function(){
		if (flag){
			$("#div1").fadeOut();
			$("#b1").text("Show")
			flag = false;
		}
		else {
			$("#div1").fadeIn().css("background-color", "pink");;
			$("#b1").text("Hide");
			flag = true;
		}
	})
	
	$("#query").keyup(function(){
		$("#para1").html($("#query").val());
	})
	
	$("#validatEmailButton").click(function(){
		var email = $("#emailTf").val();
		var query = $("#query").val();
		
		if(email != "" && query != ""){
			var regEx = "/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/";
			
			if (RegExp(regEx).test(email)){
				$("#form1").submit();
				alert("correct email");
			}else{
				$("#para1").html("please input valid email")
			}
			
		}else{
			$("#para1").html("please input valid email/query")
		}
	})
	
	$("#progressButton").click(function(){
		if(prgflag){
			for (i=0; i<50; i++){
				$("#prg1").animate({value: "+=1"},100);
			}
			prgflag = false;
		}
		else{
			for (i=0; i<50; i++){
				$("#prg1").animate({value: "-=1"},1);
			}
			prgflag = true;
		}
	})
	
	$("#changeButton").click(function(){
		$("#div1").css("background-color", "yellow")
	})
})