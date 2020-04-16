$(document).ready(function(){

$.ajax({method:"GET",
		url:"PostedBidProductsServlet",
		data:{
			type:"getallcategories"
			},
		success:function(a){
			if(a != ""){
				for(x in a){
					$("#dynamic-category").append("<li><a href='#'>"+a[x].name+"</a></li>");
				}
				$("#dynamic-category").append("<li><a href='contact.jsp'>Contact Us</a></li>");
				
				
			}
		}
	});




	setInterval(function(){
		$.ajax({method:"GET",
	url:"NotificationsSender",
	data:{
		action:"getNotifications"
		},
	success:function(a){
		if(a != ""){
			
			for(x in a){
				$.notify({
					// options
					icon: 'glyphicon glyphicon-warning-sign',
					title: '',
					message: a[x].sellerBuyerAccount+' bid '+a[x].notification+' on '+a[x].postedBidProducts+' at '+a[x].notificationTime,
					url: 'https://github.com/mouse0270/bootstrap-notify',
					target: '_blank'
				},{
					// settings
					element: 'body',
					position: null,
					type: "info",
					allow_dismiss: true,
					newest_on_top: false,
					showProgressbar: false,
					placement: {
						from: "top",
						align: "left"
					},
					offset: 20,
					spacing: 10,
					z_index: 1031,
					delay: 5000,
					timer: 1000,
					url_target: '_blank',
					mouse_over: null,
					animate: {
						enter: 'animated fadeInDown',
						exit: 'animated fadeOutUp'
					},
					onShow: null,
					onShown: null,
					onClose: null,
					onClosed: null,
					icon_type: 'class',
					template: '<div data-notify="container" class="col-xs-11 col-sm-3 alert alert-{0}" role="alert">' +
						'<button type="button" aria-hidden="true" class="close" data-notify="dismiss">x</button>' +
						'<span data-notify="icon"></span> ' +
						'<span data-notify="title">{1}</span> ' +
						'<span data-notify="message">{2}</span>' +
						'<div class="progress" data-notify="progressbar">' +
							'<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
						'</div>' +
						'<a href="{3}" target="{4}" data-notify="url"></a>' +
					'</div>' 
				});
				
				$.ajax({method:"GET",
					url:"NotificationsSender",
					data:{
						action:"updateAllNotifications",
						notificationId:a[x].bidNotificationId
						},
					success:function(a){
						
					}
				});
				
			}
		}
	}
});
	},1000*20);

})