<%@ include file = "files.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%-- <c:if test="${sessionScope.email != null }"> --%>
<%-- <c:redirect url="index.jsp"></c:redirect> --%>
<%-- </c:if> --%>
<script src="js/login.js"></script>
<!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p>SALE UP TO 70% OFF. USE CODE "SALE70%" . <a href="products.jsp">SHOP NOW</a></p>
			</div>
			<div class="agile-login pull-right">
				<ul>
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
<!-- //breadcrumbs -->
<!-- register -->

	<div class="register">
		<div class="container">
			<h2>Register Here</h2>
			<div class="login-form-grids">
				<h5>profile information</h5>
					<input type="text" placeholder="First Name..." required id="fname">
					<input type="text" placeholder="Last Name..." required id="lname" >
				<h6>Other Details</h6>
				<input type="text" placeholder="Contact..." required id="contact" style="margin-bottom:15px;">
				<textarea class="form-control" rows="3" cols="49" id="address" required placeholder="Address..."></textarea>
				<h6>Login information</h6>
					<input type="email" placeholder="Email Address" required id="email">
					<input type="password" placeholder="Password" required id="password">
				<h6>Security Question</h6>
					<div class="form-group">
					<select class="form-control" id="question">
						<option value="1">Where was your mother born ?</option>
						<option value="2">Who is your best friend ?</option>
						<option value="3">Who is your crush ?</option>
						<option value="4">What is your pet name ?</option>
					</select>
    				</div>
					<input type="text" placeholder="Password Recovery Question" required id="answer">
					<div class="register-check-box">
						<div class="check">
							<label class="checkbox" id="termsAndConditions"><input type="checkbox" name="checkbox" id="terms"><i> </i>I accept the terms and conditions</label>
						</div>
					</div>
					<input type="submit" value="Register" id="register">
			</div>
		</div>
	</div>
<!-- //register -->
<!-- //footer -->
<%@ include file = "footer.jsp" %>