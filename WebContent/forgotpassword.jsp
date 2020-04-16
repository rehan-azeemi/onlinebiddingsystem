<%@ include file = "files.jsp" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script src="js/forgotpassword.js"></script>
<!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p>SALE UP TO 70% OFF. USE CODE "SALE70%" . <a href="products.jsp">SHOP NOW</a></p>
			</div>
			<div class="agile-login pull-right">
				<ul>
					<li><a href="registered.jsp">Create Account</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="contact.jsp">Help</a></li>		
				</ul>
			</div>
		</div>
	</div>
	<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>Order online or call us : (+0123) 234 567</li>
					
				</ul>
			</div>
			<div class="w3ls_logo_products_left">
				<h1><a href="index.jsp">super Market</a></h1>
			</div>

			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Forgot Password</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- login -->
	<div class="login" id="youarebanned">
		<div class="container" id="forgotpasswordbanned">
			<h2>Recover Your Account</h2>
		
			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
					<input type="email" placeholder="Email Address" required id="email" style="margin-bottom:15px;">
					<div class="form-group">
					<select class="form-control" id="question">
						<option value="1">Where was your mother born ?</option>
						<option value="2">Who is your best friend ?</option>
						<option value="3">Who is your crush ?</option>
						<option value="4">What is your pet name ?</option>
					</select>
    				</div>
					<input type="text" placeholder="Password Recovery Question" required id="answer">
					<label id="loginFailed" class="pull-left" style="color: red;"></label>
					<input type="submit" value="Recover" id="forgotpassword">
			</div>
			<h4>For New People</h4>
			<p><a href="registered.jsp">Register Here</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></p>
		</div>
	</div>
<!-- //login -->
<!-- //footer -->
<%@ include file = "footer.jsp" %>