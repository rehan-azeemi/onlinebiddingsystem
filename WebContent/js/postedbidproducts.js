$(document).ready(function(){
	
	//For Category//
	
	$.ajax({method:"GET",
		url:"PostedBidProductsServlet",
		data:{
			type:"getallcategories"
			},
		success:function(a){
			if(a != ""){
				for(x in a){
					$("#category").find("select").append("<option value="+a[x].categoryId+">"+a[x].name+"</option>");
				}
			}
		}
	});
	
	
	//For Selling Product//
	
	  $("#post").click(function (event) {

	        //stop submit the form, we will post it manually.
	        event.preventDefault();
	        
	        if(productSaleFormValidation() == true){

	        // Get form
	        var form = $('#fileUploadForm')[0];

			// Create an FormData object
	        var data = new FormData(form);

			// If you want to add an extra field for the FormData
	        data.append("title",$("#title").val());
	        data.append("description", $("#description").val());
	        data.append("category", $("#category").find('option:selected').val());
	        data.append("minprice", $("#price").val());
	        data.append("date", $("#enddate").val());

			// disabled the submit button
	        $("#post").prop("disabled", true);

	        $.ajax({
	            type: "POST",
	            enctype: 'multipart/form-data',
	            url: "PostedBidProductsServlet",
	            data: data,
	            processData: false,
	            contentType: false,
	            cache: false,
	            timeout: 600000,
	            success: function (data) {

	                if(data == "success"){
	                	$("#post").prop("disabled", false);
	                	window.location = "message.jsp?detsop=eurt";
	                	
	                }

	            },
	            error: function (e) {

	                $("#result").text(e.responseText);
	                console.log("ERROR : ", e);
	                $("#btnSubmit").prop("disabled", false);

	            }
	        });
	        
	        }

	    });	
});

function productSaleFormValidation(){
	
	if($("#title").val() == ""){
		$("#title").notify("You can't leave this empty",{position:"right"});
		$("#title").css({'border-color':'red'});
		return false;
	}
	else if($("#description").val() == ""){
		$("#description").notify("You can't leave this empty",{position:"right"});
		$("#description").css({'border-color':'red'});
		return false;
	}
	else if($("#price").val() == ""){
		$("#price").notify("You can't leave this empty",{position:"right"});
		$("#price").css({'border-color':'red'});
		return false;
	}
	else if($("#enddate").val() == ""){
		$("#enddate").notify("You can't leave this empty",{position:"right"});
		$("#enddate").css({'border-color':'red'});
		return false;
	}
		
	return true;
}