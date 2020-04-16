<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty param.tougol}">
	<c:remove var="email" scope="session" />
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<%@ include file="files.jsp"%>
<style>
.notifications-wrapper {
	overflow: auto;
	max-height: 250px;
}

.notifications-wrapper a.content {
	text-decoration: none;
	display: block;
	color: #000;
}

.notification-item {
	position: relative;
	padding: 10px;
	padding-left: 70px;
	padding-bottom: 10px;
}

.notification-item img {
	position: absolute;
	top: 7px;
	left: 10px;
	width: 50px;
	height: 50px;
	border-radius: 50px;
}

.item-title {
	font-size: 0.8rem;
	color: #000;
	font-weight: bold;
	margin: 5px 0px;
}

.notifications-wrapper a.content:hover {
	color: #000;
	background: rgba(0, 0, 0, 0.1);
}
</style>

<!-- header -->
<div class="agileits_header">
	<div class="container">
		<div class="w3l_offers">
			<p>
				<i class="glyphicon glyphicon-user" style="color: #FE9126;"></i>
				<c:if test="${sessionScope.name != null }">
					<c:out value="${sessionScope.name }"></c:out>
					<script type="text/javascript" src="js/header-menu.js"></script>
				</c:if>
			</p>
		</div>
			<div class="agile-login">
				<ul style="width: 600px;">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-bell"
							style="color: #FE9126;"></i> Notifications <i class="caret"
							style="color: #FE9126;"></i></a>
						<ul class="dropdown-menu multi-column columns-3"
							style="width: 350px;">
							<div class="row">
								<div class="multi-gd-img">
									<ul class="multi-column-dropdown">
										<h6>Notifications</h6>

										<div class="notifications-wrapper">
											<a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a> <a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a> <a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a> <a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a>



										</div>

									</ul>
								</div>
							</div>

						</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-bell"
							style="color: #FE9126;"></i> Messenger <i class="caret"
							style="color: #FE9126;"></i></a>
						<ul class="dropdown-menu multi-column columns-3"
							style="width: 350px;">
							<div class="row">
								<div class="multi-gd-img">
									<ul class="multi-column-dropdown">
										<a href="messenger.jsp"><h6>See all messages</h6></a>

										<div class="notifications-wrapper">
											<a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a> <a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a> <a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a> <a class="content" href="#">
												<div class="notification-item">
													<img src="http://www.leapcms.com/images/100pixels1.gif">
													<h4 class="item-title">
														Evaluation Deadline <small> 1 day ago</small>
													</h4>
													<p class="item-info">Mr hassan has followed you!</p>
												</div>
											</a>



										</div>

									</ul>
								</div>
							</div>

						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="glyphicon glyphicon-cog"
							style="color: #FE9126;"></i> Settings <i class="caret"
							style="color: #FE9126;"></i></a>
						<ul class="dropdown-menu multi-column columns-3">
							<div class="row">
								<div class="multi-gd-img">
									<ul class="multi-column-dropdown">
										<h6>Personalize</h6>
										<li><a href="index.jsp?tougol=eurt"><i
												class="glyphicon glyphicon-log-out" style="color: #FE9126;"></i>
												Logout</a></li>
										<li><a href="#"><i class="glyphicon glyphicon-pencil"
												style="color: #FE9126;"></i> Update Info</a></li>
										<li><a href="changepassword.jsp"><i
												class="glyphicon glyphicon-lock" style="color: #FE9126;"></i>
												Alter Password</a></li>
										<li><a href="#"><i class="glyphicon glyphicon-trash"
												style="color: #FE9126;"></i> Delete Account</a></li>

									</ul>
								</div>
							</div>
						</ul></li>
					<li><a href="saleproduct.jsp"><i
							class="glyphicon glyphicon-new-window" style="color: #FE9126;"></i>
							Sale Product</a></li>

				</ul>
			</div>
		</div>
		<div class="clearfix"></div>
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
			<h1>
				<a href="index.jsp">Auction Market</a>
			</h1>
		</div>
		<div class="w3l_search">
			<form action="#" method="post">
				<input type="search" name="Search"
					placeholder="Search for a Product..." required="">
				<button type="submit" class="btn btn-default search"
					aria-label="Left Align">
					<i class="fa fa-search" aria-hidden="true"> </i>
				</button>
				<div class="clearfix"></div>
			</form>
		</div>

		<div class="clearfix"></div>
	</div>
</div>
<!-- //header -->
<!-- navigation -->
<div class="navigation-agileits">
	<div class="container">
		<nav class="navbar navbar-default">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header nav_2">
				<button type="button" class="navbar-toggle collapsed navbar-toggle1"
					data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
				<ul class="nav navbar-nav" id="dynamic-category">
					<li class="active"><a href="index.jsp" class="act">Home</a></li>
				</ul>
			</div>
		</nav>
	</div>
</div>