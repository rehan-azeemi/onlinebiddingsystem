$(document).ready(function(){
	
	//For Viewing Detail of Product//
	
	$.ajax({method:"GET",
		url:"ProductDetail",
		data:{
			type:"viewProductDetail",
			productCode:$("#productCode").val()
			},
		success:function(a){
			if(a != ""){
				var dataThumb = 0;
				
				$("#slider1").append("<div class='item active' data-thumb='"+dataThumb+"'>"+
				            			"<img src='RenderingImages?image="+a.imagesPath[0].path.substring(13)+"'>"+
									  "</div>");
				
				for(var i=1; i<a.imagesPath.length; i++){
					$("#slider1").append("<div class='item' data-thumb='"+dataThumb+"'>"+
	            			"<img  src='RenderingImages?image="+a.imagesPath[i].path.substring(13)+"'>"+
						  "</div>");
					
					if((i+1)%4==0){
						dataThumb++;
					}
				}
				
				var dataSlideTo = 0;
				var j = 0;
				var iter = Math.ceil(a.imagesPath.length/4);
				
				var data;
				
				for(var i=1; i<=iter; i++){
					data = "";
					if(i==1){
						data += "<div class='item active'>";
					}
					else{
						data += "<div class='item'>";
					}
					
					while(j < a.imagesPath.length){
						
						data += "<div data-target='#carousel' data-slide-to='"+(dataSlideTo++)+"' class='thumb'><img src='RenderingImages?image="+a.imagesPath[j].path.substring(13)+"'></div>";
						
						if((j+1)%4 == 0){
							break;
						}
						
						j++;
					}
					
					data += "</div>";
					
					$("#slider2").append(data);
				}
				
				$("#title").append(a.title);
				$("#endedOn").append(a.endBid.split(" ")[0]);
				$("#productIdCode").append(a.postedBidProducts);
				$("#minPrice").append(a.minPrice+"/$");
				$("#category").append(a.category);
				$("#description").append(a.description);
				$("#sellerName").append(a.sellerBuyerAccountName+" <small><i>Posted on "+a.startBid.split(" ")[0]+"</i></small>");
				$("#sellingPrice").val(a.minPrice);
			}
		}
			
	});
	
	$.ajax({method:"GET",
		url:"ProductDetail",
		data:{
			type:"biddingDetail",
			productCode:$("#productCode").val()
			},
		success:function(a){
			if(a == "nodata"){
				 alertify.set('notifier','position', 'top-right');
				 alertify.notify('Bid is not started yet.', 'custom', 10, function(){console.log('dismissed');});
				 $('#bootstrapDataTable').hide();
			}
			else{
				
				for(x in a){
					$("#tableData").append("<tr>" +
							"<td>" +a[x].postedBidProductsName +"</td>"+
							"<td>" +a[x].sellerBuyerAccountName+"</td>"+
							"<td>" +a[x].currentBid+"</td>"+
							"</tr>");
				}
				
				$('#bootstrapDataTable').DataTable();
			
			}
		}
	});
	
	$("#mybid").click(function(){
		$.ajax({
		method:"POST",
		url:"ProductDetail",
		data:{
			type:"myBid",
			currentBid:$("#sellingPrice").val(),
			productCode:$("#productCode").val()
		},
		success:function(a){
			$('#bootstrapDataTable').show();
			$('#bootstrapDataTable tbody').html('');
			
			for(x in a){
				$("#tableData").append("<tr>" +
						"<td>" +a[x].postedBidProductsName +"</td>"+
						"<td>" +a[x].sellerBuyerAccountName+"</td>"+
						"<td>" +a[x].currentBid+"</td>"+
						"</tr>");
			}
			
			$('#bootstrapDataTable').DataTable();
		}
	});
	});
	
	
//	setInterval(function(){
//		$.ajax({method:"GET",
//			url:"ProductDetail",
//			data:{
//				type:"biddingDetail"
//				},
//			success:function(a){
//					
//				$('#bootstrapDataTable').show();
//				$('#bootstrapDataTable tbody').html('');
//					
//					for(x in a){
//						$("#tableData").append("<tr>" +
//								"<td>" +a[x].postedBidProductsName +"</td>"+
//								"<td>" +a[x].sellerBuyerAccountName+"</td>"+
//								"<td>" +a[x].currentBid+"</td>"+
//								"</tr>");
//					}
//					
//					$('#bootstrapDataTable').DataTable();
//				
//				}
//		});
//	    }, 1000*60);
	
});