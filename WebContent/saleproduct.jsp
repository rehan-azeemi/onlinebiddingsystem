<%@ include file = "header.jsp" %>
<script src="js/postedbidproducts.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<style>
[hidden] {
  display: none !important;
}
</style>
<!-- register -->
<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
	<div class="register">
		<div class="container">
			<h2>Post Your Product</h2>
			<div class="login-form-grids">
			
				<h5>product information</h5>
					<input type="text" placeholder="Product Title..." required id="title">
					<textarea class="form-control" rows="3" cols="49" id="description" required placeholder="Description..." style="margin-bottom:15px;"></textarea>
					<div class="form-group" id="category">
					<h6>Category</h6>
					<select class="form-control">
					</select>
    				</div>
				<h6>Other Details</h6>
				<input type="text" placeholder="Minimum Price...." required id="price">
				<h6>Date Of End Auctioning</h6>
				<div class="form-group">
					
        			<input class="form-control" id="enddate" name="date" placeholder="MM/DD/YYY" type="date"/>
        	
        			 <label class="btn btn-primary" style="margin-top:20px;">
        			 Browse Images
        			<input type="file" name="files" multiple="multiple" required hidden=""/>
     				</label>
     			</div>
					<input type="submit" value="Post" id="post">
			</div>
		</div>
	</div>
	</form>
<!-- //register -->
<!-- //footer -->
<%@ include file = "footer.jsp" %>