<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<c:if test="${not empty param.tougol}">
<c:remove var="email" scope="session" />
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<%@ include file = "files.jsp" %>	
<link rel="stylesheet" type="text/css" href="css/chat.css">
<script  src="js/chatting.js"></script>
<input type="hidden" id="sbaid">
<!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p><i class="glyphicon glyphicon-user" style="color: #FE9126;"></i><c:if test="${sessionScope.name != null }">
<c:out value="${sessionScope.name }"></c:out>
</c:if></p>
			</div>
			<div class="agile-login pull-right">
<ul>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="glyphicon glyphicon-bell" style="color: #FE9126;"></i> Notifications <i class="caret"
						style="color: #FE9126;"></i></a>
					<ul class="dropdown-menu multi-column columns-3" style="width:300px;">
						<div class="row">
							<div class="multi-gd-img">
								<ul class="multi-column-dropdown">
									<h6>Notifications</h6>
									
									<div class="notifications-wrapper">
										<a class="content" href="#">
											<div class="notification-item">
												<h4 class="item-title">Rehan Ali bided 14000</h4>
												<p class="item-info"> HP Laptop, By Asif Ali</p>
											</div>
										</a>
									</div>
									
									<div class="notifications-wrapper">
										<a class="content" href="#">
											<div class="notification-item">
												<h4 class="item-title">Evaluation Deadline 1 day ago</h4>
												<p class="item-info">Marketing 101, Video Assignment</p>
											</div>
										</a>
									</div>
									
									<div class="notifications-wrapper">
										<a class="content" href="#">
											<div class="notification-item">
												<h4 class="item-title">Evaluation Deadline 1 day ago</h4>
												<p class="item-info">Marketing 101, Video Assignment</p>
											</div>
										</a>
									</div>
									
								</ul>
							</div>
						</div>

					</ul></li>
				<li><a href="saleproduct.jsp"><i
						class="glyphicon glyphicon-new-window" style="color: #FE9126;"></i>
						Sale Product</a></li>


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
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
</div>
		<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>Order online or call us : (+92) 334 1994199</li>
					
				</ul>
			</div>
			<div class="w3ls_logo_products_left">
				<h1><a href="index.jsp">Auction Market</a></h1>
			</div>
		<div class="w3l_search">
			<form action="#" method="post">
				<input type="search" name="Search" placeholder="Search for a Product..." required="">
				<button type="submit" class="btn btn-default search" aria-label="Left Align">
					<i class="fa fa-search" aria-hidden="true"> </i>
				</button>
				<div class="clearfix"></div>
			</form>
		</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>

<body>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.6.8-fix/jquery.nicescroll.min.js"></script>
<div class="container" style="margin-bottom:20px; margin-top:20px;">
<div class="content container-fluid bootstrap snippets">
      <div class="row row-broken">
        <div class="col-sm-3 col-xs-12">
          <div class="col-inside-lg decor-default chat" style="overflow: hidden; outline: none;" tabindex="5000">
            <div class="chat-users">
              <h6>My Products</h6>
                <div id="allproducts">
                	
                </div>
            </div>
          </div>
        </div>
        <div class="col-sm-9 col-xs-12 chat" style="overflow: hidden; outline: none;" tabindex="5001">
          <div class="col-inside-lg decor-default">
            <div class="chat-body">
              <h6 id="seller">Conversation</h6>
				<div id="conversation">
				</div>
             
              <div class="answer-add">
                <input placeholder="Write a message" id="mymessage" style="height: 50px; border:0px;">
                <span class="answer-btn answer-btn-1"></span>
                <input type="button" class="answer-btn answer-btn-2" id="send">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
    $(".chat").niceScroll();
})
</script>
</div>
</body>
<%@ include file = "footer.jsp" %>