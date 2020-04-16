<%@ include file = "files.jsp" %>
<script src="js/login.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<script src="js/forgotpassword.js"></script>
<!-- header -->
	<c:choose>
	<c:when test="${sessionScope.email == null }">
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
	</c:when>
	<c:otherwise>
		<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p><i class="glyphicon glyphicon-user" style="color: #FE9126;"></i><c:if test="${sessionScope.name != null }">
<c:out value="${sessionScope.name }"></c:out>
</c:if></p>
			</div>
			<div class="agile-login pull-right">
				<ul>
					<li><a href="contact.jsp"><i class="glyphicon glyphicon-new-window" style="color: #FE9126;"></i> Help</a></li>	
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-cog" style="color: #FE9126;"></i> Settings <i class="caret" style="color: #FE9126;"></i></a>
								<ul class="dropdown-menu multi-column columns-3">
									<div class="row">
										<div class="multi-gd-img">
											<ul class="multi-column-dropdown">
											<h6>Personalize</h6>
												<li><a href="index.jsp?tougol=eurt"><i class="glyphicon glyphicon-log-out" style="color: #FE9126;"></i> Logout</a></li>
												<li><a href="#"><i class="glyphicon glyphicon-pencil" style="color: #FE9126;"></i> Update Info</a></li>
												<li><a href="changepassword.jsp"><i class="glyphicon glyphicon-lock" style="color: #FE9126;"></i> Alter Password</a></li>
												<li><a href="#"><i class="glyphicon glyphicon-trash" style="color: #FE9126;"></i> Delete Account</a></li>
											</ul>
										</div>		
									</div>
								</ul>
						</li>		
				</ul>
			</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</c:otherwise>
	</c:choose>
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
<!-- header -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Change Password</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- register -->
	<c:choose>
	<c:when test="${sessionScope.email == null }">
	<div class="register">
		<div class="container">
			<h2>New Password</h2>
			<div class="login-form-grids">
					<input type="password" placeholder="New Password" required id="newpassword">
					<input type="password" placeholder="Confirm Password" required id="confirmpassword">
					<input type="submit" value="Change Password" id="newpasswordrequest">
			</div>
		</div>
	</div>
	</c:when>
	<c:otherwise>
		<div class="register">
		<div class="container">
			<h2>Change Password</h2>
			<div class="login-form-grids">
					<input type="password" placeholder="Old Password" required id="changeoldpassword">
					<input type="password" placeholder="New Password" required id="changenewpassword">
					<input type="submit" value="Change Password" id="changepassword">
			</div>
		</div>
	</div>
	</c:otherwise>
	</c:choose>
<!-- //register -->
<!-- //footer -->
<%@ include file = "footer.jsp" %>