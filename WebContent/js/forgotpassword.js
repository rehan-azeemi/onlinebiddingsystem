$(document).ready(function(){
	
	///Check user is banned or not///
	$.ajax({method:"GET",
		url:"ForgotPasswordServlet",
		success:function(a){
			if(a == "banned"){
				$("#forgotpasswordbanned").css({'display':'none'});
				$("#youarebanned").html("<h2>You are banned</h2>");
			}
		}
	});
	
	////For Forgot Password/////
	
	$("#forgotpassword").click(function(){
		if(forgotPasswordValidate() == true){
			$.ajax({method:"POST",
				url:"ForgotPasswordServlet",
				data:{type:"forgotpassword",
					  email:$("#email").val(),
					  answer:$("#answer").val(),
					  question:$("#question").find('option:selected').val()},
				success:function(a){
					if(a == "success"){
						window.location = "changepassword.jsp";
					}
					else if(a == "failed"){
						$("#answer").notify("Wrong email or answer",{position:"bottom right"});
					}
					else{
						$("#forgotpasswordbanned").css({'display':'none'});
						$("#youarebanned").html("<h2>You are banned</h2>");
					}
				}
			});
		}
	});
	
	
	////New Password Request////
	
	$("#newpasswordrequest").click(function(){
		if(newPasswordRequestValidate() == true){
			$.ajax({method:"POST",
				url:"ForgotPasswordServlet",
				data:{type:"newpasswordrequest",
					  newpassword:$("#newpassword").val(),
					  confirmpassword:$("#confirmpassword").val()},
				success:function(a){
					if(a == "success"){
						window.location = "message.jsp?drowssapwen=eurt";
					}
					else{
						window.location = "changepassword.jsp";
					}
				}
			});
		}
	});
	
	
	$("#changepassword").click(function(){
		if(changePasswordRequestValidate() == true){
			$.ajax({method:"POST",
				url:"ForgotPasswordServlet",
				data:{type:"changepassword",
					  newpassword:$("#changenewpassword").val(),
					  oldpassword:$("#changeoldpassword").val()},
				success:function(a){
					if(a == "success"){
						window.location = "login.jsp";
					}
					else if(a == "wrongoldpassword"){
						$("#changeoldpassword").notify("You entered wrong old password",{position:"right"});
						$("#changeoldpassword").css({'border-color':'red'});
					}
					else{
						
					}
				}
			});
		}
	});
	
});

function forgotPasswordValidate(){
	if($("#email").val() == ""){
		$("#email").notify("Enter a email",{position:"right"});
		$("#email").css({'border-color':'red'});
		return false;
	}
	else if($("#answer").val() == ""){
		$("#answer").notify("Enter a answer",{position:"right"});
		$("#answer").css({'border-color':'red'});
		return false;
	}
	
	return true;
	
}

function newPasswordRequestValidate(){
	if($("#newpassword").val() == ""){
		$("#newpassword").notify("Enter a new password",{position:"right"});
		$("#newpassword").css({'border-color':'red'});
		return false;
	}
	else if($("#confirmpassword").val() == ""){
		$("#confirmpassword").notify("Enter a confrim password",{position:"right"});
		$("#confirmpassword").css({'border-color':'red'});
		return false;
	}
	else if($("#confirmpassword").val() != $("#newpassword").val()){
		$("#confirmpassword").notify("passwords field are not matched",{position:"right"});
		$("#confirmpassword").css({'border-color':'red'});
		return false;
	}
	
	return true;
	
}

function changePasswordRequestValidate(){
	if($("#changeoldpassword").val() == ""){
		$("#changeoldpassword").notify("Enter a old password",{position:"right"});
		$("#changeoldpassword").css({'border-color':'red'});
		return false;
	}
	else if($("#changenewpassword").val() == ""){
		$("#changenewpassword").notify("Enter a new password",{position:"right"});
		$("#changenewpassword").css({'border-color':'red'});
		return false;
	}
	
	return true;
	
}

