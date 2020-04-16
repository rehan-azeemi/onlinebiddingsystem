<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty param.tougol}">
	<c:remove var="email" scope="session" />
	<c:redirect url="login.jsp"></c:redirect>
</c:if>
<title>Super Market an Ecommerce Online Shopping Category Flat
	Bootstrap Responsive Website Template | Groceries :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Super Market Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/newstyle.css" rel="stylesheet" type="text/css"
	media="all" />

<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/header-menu.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
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
</head>

<body>
	<!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers" style="width: 600px;">
				<p>
					<i class="glyphicon glyphicon-user" style="color: #FE9126;"></i>
					<c:if test="${sessionScope.name != null }">
						<c:out value="${sessionScope.name }"></c:out>
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
										<h6>Messages</h6>

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
					<button type="submit" class="btn btn-defaults search"
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
					<button type="button"
						class="navbar-toggle collapsed navbar-toggle1"
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

	<!-- //navigation -->
	<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft"
				data-wow-delay=".5s">
				<li><a href="index.html"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li class="active">Products</li>
			</ol>
		</div>
	</div>
	<!-- //breadcrumbs -->