	
$(document).ready(function(){
//	$("#allusers").hide(1000);
//	$("#users").click(function(){
//		$("#allproducts").hide(1000);
//        $("#allusers").show(1000);
//    });
//	
//	$("#products").click(function(){
//		$("#allusers").hide(1000);
//        $("#allproducts").show(1000);
//    });
	
//	$.ajax({
//		method:"GET",
//		url:"Messages",
//		data:{
//			type:"getAllBidedProducts",
//		},
//		success:function(a){
//			
//			for(x in a){
//				$("#allproducts").append("<div class='user' onclick='openChat("+a[x].sellerBuyerAccount+",\""+a[x].postedBidProducts+"\")'>"+
//                "<div class='avatar'>"+
//                "<img src='https://bootdey.com/img/Content/avatar/avatar1.png' alt='User name'>"+
//                "<div class='status off'></div>"+
//                "</div>"+
//                "<div class='name'>"+a[x].sellerBuyerAccountName+"</div>"+
//                "<div class='mood'>"+a[x].title+"</div>"+
//            "</div>");
//				
//			}
//		}
//	});
	
	$.ajax({
		method:"GET",
		url:"Messages",
		data:{
			type:"getAllUsers",
		},
		success:function(a){
			for(x in a){
				$("#allproducts").append("<div class='user' onclick='openChat("+a[x].sbaId+")'>"+
                "<div class='avatar'>"+
                "<img src='https://bootdey.com/img/Content/avatar/avatar1.png' alt='User name'>"+
                "<div class='status off'></div>"+
                "</div>"+
                "<div class='name'>"+a[x].name+"</div>"+
                "<div class='mood'>Online</div>"+
            "</div>");
				
			}
		}
	});
	
	$("#mymessage").keypress(function(e) {
		if(e.which == 13){
		$.ajax({
			method:"POST",
			url:"Messages",
			data:{
				type:"sendMessages",
				sendTo:$("#sbaid").val(),
				msg:$("#mymessage").val()
			},
			success:function(a){
				if(a == "success"){
					openChat($("#sbaid").val());
				}
			}
		});
		$("#mymessage").val("");
		}
	});
	
	$("#send").click(function(){
		$.ajax({
			method:"POST",
			url:"Messages",
			data:{
				type:"sendMessages",
				sendTo:$("#sbaid").val(),
				msg:$("#mymessage").val()
			},
			success:function(a){
				if(a == "success"){
					openChat($("#sbaid").val());
				}
			}
		});
		$("#mymessage").val("");
});
	
	setInterval(function(){
		if($("#sbaid").val() != ""){
			openChat($("#sbaid").val());
		}
	    }, 1000*5);
	
});

function openChat(sellerBuyerAccountId){
	$("#sbaid").val(sellerBuyerAccountId);
	$.ajax({
		method:"GET",
		url:"Messages",
		data:{
			type:"getAllChat",
			sellerBuyerAccountId:sellerBuyerAccountId
		},
		success:function(a){	
			if(a != ""){$("#conversation").empty();}
			else{
				
			}
			for(x in a){
					if(a[x].sendToId == sellerBuyerAccountId){
				  $("#conversation").append("<div class='answer right'>"+
	                "<div class='avatar'>"+
	                  "<img src='https://bootdey.com/img/Content/avatar/avatar2.png' alt='User name'>"+
	                  "<div class='status offline'></div>"+
	                "</div>"+
	                "<div class='name'>"+a[x].sendByName+"</div>"+
	                "<div class='text'>"+a[x].message
	                +"</div>"+
	                "<div class='time'>"+a[x].messageArrivalTime+"</div>"+
	              "</div>");
					}
					else{
						  $("#conversation").append("<div class='answer left'>"+
					                "<div class='avatar'>"+
					                  "<img src='https://bootdey.com/img/Content/avatar/avatar1.png' alt='User name'>"+
					                  "<div class='status offline'></div>"+
					                "</div>"+
					                "<div class='name'>"+a[x].sendByName+"</div>"+
					                "<div class='text'>"+a[x].message
					                +"</div>"+
					                "<div class='time'>"+a[x].messageArrivalTime+"</div>"+
					              "</div>");
					}
	            
			}
		}
	});
}