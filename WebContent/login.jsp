<%@ include file = "files.jsp" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script src="js/login.js"></script>
<%-- <c:if test="${sessionScope.email != null }"> --%>
<%-- <c:redirect url="index.jsp"></c:redirect> --%>
<%-- </c:if> --%>
<!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p>SALE UP TO 70% OFF. USE CODE "SALE70%" . <a href="products.jsp">SHOP NOW</a></p>
			</div>
			<div class="agile-login pull-right">
				<ul>
					<li><a href="registered.jsp">Create Account</a></li>
					<li><a href="forgotpassword.jsp">Forgot Password</a></li>
					<li><a href="contact.jsp">Help</a></li>		
				</ul>
			</div>
		</div>
	</div>
	<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i></li>
					
				</ul>
			</div>
			<div class="w3ls_logo_products_left">
				<h1><a href="index.jsp">Auction Market</a></h1>
			</div>

			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Login Page</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- login -->

	<div class="login">
		<div class="container">
		<img src="images/loading.gif" style="display:none; position:absolute; top:350px; left:600px;" id="loading">
			<h2>Login Form</h2>
			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
					<input type="email" placeholder="Email Address" required id="email">
					<input type="password" placeholder="Password" required id="password">
					<label id="loginFailed" class="pull-left" style="color: red;"></label>
					<div class="forgot">
						<a href="forgotpassword.jsp">Forgot Password?</a>
					</div>
					<input type="submit" value="Login" id="login">
			</div>
			<h4>For New People</h4>
			<p><a href="registered.jsp">Register Here</a><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></p>
		</div>
	</div>
<!-- //login -->
<!-- //footer -->
<%@ include file = "footer.jsp" %>