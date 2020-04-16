<%@ include file = "files.jsp" %>
<script src="js/postedbidproducts.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
				<h1><a href="index.jsp">Auction Market</a></h1>
			</div>
			<div class="login" id="message">
				<c:choose>
				<c:when test="${param.detsop != null}">
					<h2>Your Product has been Posted</h2>
					<div class="forgot" style="text-align:center;">
					<a href="saleproduct.jsp" >Want to post another product ?</a>
					</div>
				</c:when>
				<c:when test="${param.drowssapwen != null }">
					<h2>Your Password has been changed</h2>
					<div class="forgot" style="text-align:center;">
					<a href="login.jsp" >Please Login to continue ?</a>
					</div>
				</c:when>
				</c:choose>
			</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<%@ include file = "footer.jsp" %>