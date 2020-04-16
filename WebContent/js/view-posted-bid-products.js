$(document).ready(function(){
	
	//For Viewing Posted Bid Products//
	
	$.ajax({method:"POST",
		url:"PostedBidProductsServlet",
		data:{
			type:"getAllPostedBidProducts"
			},
		success:function(a){
			
			if(a != ""){
				for(x in a){
					
				$("#products").append("<div class='col-md-4 top_brand_left' style='margin-bottom:20px;'>"+
									"<div class='hover14 column'>"+
										"<div class='agile_top_brand_left_grid'>"+
											"<div class='agile_top_brand_left_grid_pos'>"+
												"<img src='images/offer.png' alt=' ' class='img-responsive' />"+
											"</div>"+
											"<div class='agile_top_brand_left_grid1'>"+
												"<figure>"+
													"<div class='snipcart-item block' >"+  
														"<div class='snipcart-thumb'>"+
															"<a href='products.jsp'><img  id='zoom' title=' ' alt=' ' src='RenderingImages?image="+a[x].imagesPath[0].path.substring(13)+"' /></a>"+		
															"<p>"+a[x].title+"</p>"+
															
															"<p> Started at : <span>"+a[x].minPrice+"</span></p>"+
														"</div>"+
														"<div class='snipcart-details top_brand_home_details'>"+
															"<input type='submit' name='submit' value='Check Details' class='button' onclick='viewProduct(\""+a[x].postedBidProducts+"\")'/>"+
															"</div>"+
													"</div>"+
												"</figure>"+
											"</div>"+
										"</div>"+
									"</div>"+
								"</div>");
				}
			}
		}
	});
	

//	$(document).on('submit', '#myForm', function(event) {
//		event.preventDefault();
//	});
});


function viewProduct(productIds){
	$.ajax({
		url:"PostedBidProductsServlet",
		method:"POST",
		data:{
			type:"viewProduct",
			productId:productIds
			},
		success:function(a){
			if(a == "success"){
				window.location = "productdetail.jsp?productCode="+productIds;
			}
		}
	});
}

