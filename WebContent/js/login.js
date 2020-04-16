$(document).ready(function(){
	
	$(".forgot").css({'display':'none'});
	
	$(document).ajaxStart(function(){
        $("#loading").css("display", "block");
        $("body").css("opacity","1%");
	   });
	
	 $(document).ajaxComplete(function(){
	    $("#loading").css("display", "none");
	 });
		
	//For Login//
	
	$("#login").click(function(){
		if(loginValidate() == true){
			$.ajax({method:"POST",
				url:"LoginServlet",
				data:{email:$("#email").val(),password:$("#password").val()},
				success:function(a){
					if(a == "success"){
						window.location = "index.jsp";
					}
					else{
						
						$("#password").notify("Wrong email or password",{position:"bottom right"});
						$(".forgot").css({'display':'block'});
					}
				}
			});
		}
	});
	
	//For Registration//
	
	$("#register").click(function(){
		
		if($("#terms").prop('checked') == true && formValidation() == true){
			
			$.ajax({method:"POST",
				url:"RegisterationServlet",
				data:{
					fname:$("#fname").val(),
					lname:$("#lname").val(),
					email:$("#email").val(),
					password:$("#password").val(),
					question:$("#question").find('option:selected').val(),
					answer:$("#answer").val(),
					contact:$("#contact").val(),
					address:$("#address").val()
					},
				success:function(a){
					if(a == "success"){
						window.location = "login.jsp";
					}
					else if(a == "email is not valid"){
						$("#email").notify("Email is already registered",{position:"right"});
						$("#email").css({'border-color':'red'});
					}
				}
			});
		}
		else{
			$("#termsAndConditions").css({'color':'red'});
		}
	});
	
});

function formValidation(){
	
	if($("#fname").val() == ""){
		$("#fname").notify("You can't leave this empty",{position:"right"});
		$("#fname").css({'border-color':'red'});
		return false;
	}
	else if($("#lname").val() == ""){
		$("#lname").notify("You can't leave this empty",{position:"right"});
		$("#lname").css({'border-color':'red'});
		return false;
	}
	else if($("#contact").val() == ""){
		$("#contact").notify("You can't leave this empty",{position:"right"});
		$("#contact").css({'border-color':'red'});
		return false;
	}
	else if($("#address").val() == ""){
		$("#address").notify("You can't leave this empty",{position:"right"});
		$("#address").css({'border-color':'red'});
		return false;
	}
	else if($("#email").val() == ""){
		$("#email").notify("You can't leave this empty",{position:"right"});
		$("#email").css({'border-color':'red'});
		return false;
	}
	else if($("#password").val() == ""){
		$("#password").notify("You can't leave this empty",{position:"right"});
		$("#password").css({'border-color':'red'});
		return false;
	}
	else if($("#answer").val() == ""){
		$("#answer").notify("You can't leave this empty",{position:"right"});
		$("#answer").css({'border-color':'red'});
		return false;
	}	
	return true;
}

function loginValidate(){
	if($("#email").val() == ""){
		$("#email").notify("Enter a email",{position:"right"});
		$("#email").css({'border-color':'red'});
		return false;
	}
	else if($("#password").val() == ""){
		$("#password").notify("Enter a password",{position:"right"});
		$("#password").css({'border-color':'red'});
		return false;
	}
	
	return true;
	
}

