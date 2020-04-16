<%@ include file = "header2.jsp" %>
<link rel="stylesheet" type="text/css" href="css/styling.css">
 <script type="text/javascript" src="js/scripting.js"></script>
 <script type="text/javascript" src="js/product-detail.js"></script>
 <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/alertify.min.js"></script>
	<!-- CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/css/alertify.min.css"/>
<!-- Default theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/css/themes/default.min.css"/>
<!-- Semantic UI theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/css/themes/semantic.min.css"/>
<!-- Bootstrap theme -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.11.0/build/css/themes/bootstrap.min.css"/>
<!-- DataTable -->
<style>
.ajs-message.ajs-custom { color: #FEE3F1;  background-color:#FE9126;  border-color: #FEE3F1; }
</style>
<input type="hidden" name="productCodes" id="productCode" value="<%= request.getParameter("productCode")%>">
<!--- products -->

<div class="container">
  <div class="row">
   <div class="col-sm-6">
        <div id="carousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner" id="slider1">

    </div>

        </div> 
    <div class="clearfix">
        <div id="thumbcarousel" class="carousel slide" data-interval="false">
            <div class="carousel-inner" id="slider2">

            </div>
            <a class="left carousel-control" href="#thumbcarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="right carousel-control" href="#thumbcarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div> 
    </div>
    </div> 
    <div class="col-sm-6" style="margin-top:15px;">
 
                <h3><span class="in_sport" id="title"></span></h3>
        <table class="table table-responsive">
              <tbody>
            <tr>
                  <td><span>Category</span></td>
                  <td id="category"></td>
                </tr>
            <tr>
                  <td><span>Closing Date</span></td>
                  <td id="endedOn"></td>
                </tr>
            <tr>
                  <td><span>Product Code</span></td>
                  <td id="productIdCode"></td>
                </tr>
                 <tr>
               	<td>Starting Price</td>
               	<td id="minPrice"></td>
            </tr>
         
          </tbody>
            </table>
   
       <div class="row">
              <div class="col-md-12">
            <h5><span>Other Details</span></h5>
    <div class="media">
    <div class="media-left">
      <img src="images/useravatar.png" class="media-object" style="width:45px">
    </div>
    <div class="media-body">
      <h4 class="media-heading" id="sellerName"></h4>
      <p id="description"></p>
      </div>
      </div>
  <hr>
          </div>
            </div>
       
        <input type='submit' name='submit' value='Send message' class='button btn btn-cart'/>
         

    </div> 
  </div> 
</div>
<div class="container">
<div class="row">
	<div class="col-md-offset-4 col-md-2">
      <div class="input-group spinner">
    <input type="text" id="sellingPrice" class="form-control" value="15000" readonly />
    <div class="input-group-btn-vertical">
      <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>
      <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>
    </div>
  </div>
</div>
<div class="col-md-1">
	<div class="input-group">
<input type="button" class="btn btn-default" value="My Bid" id="mybid"/>
</div>
</div>
</div>
</div>
<!--- Datatable --->
	<div class="container">
		<div class="row">
<table id="bootstrapDataTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Buyer Name</th>
                <th>Current Bid</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>Product Name</th>
                <th>Buyer Name</th>
                <th>Current Bid</th>
            </tr>
        </tfoot>
        <tbody id="tableData">
 				
        </tbody>
    </table>
</div>
</div>
<!--- Datatable --->
    <script>
(function($) {
	  $('.spinner .btn:first-of-type').on('click', function() {
	    var input = $(this).parent().parent().children('input');
	    input.val(parseInt(input.val(), 10) + 100);
	  });
	  $('.spinner .btn:last-of-type').on('click', function() {
	    var input = $(this).parent().parent().children('input');
	    var newvalue = parseInt(input.val(), 10) - 100;
	    if (newvalue >= 0)
	      input.val(newvalue);
	  });
	})(jQuery);
</script>
<div class="clearfix"> </div>	
					
<!--- products --->
<!-- //footer -->
<%@ include file = "footer.jsp" %>