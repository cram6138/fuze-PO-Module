<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="static/css/kendo.default-v2.min.css" />
<title>template</title>
	
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="margin-left: 20%">
		<span >Import Template :</span> <select id="select">
			<option value="">-- Select Template --</option>
		</select><br>
		<div id="templateDetails"></div><br>
	</div>
		<div id="grid"></div>

	<%@ include file="footer.jsp"%>

<script src="static/js/jquery.min.js"></script>
<script src="static/js/kendo.all.min.js"></script>	
<script src="static/js/config.js"></script>
<script>
	$(document).ready(function () {
		var tempObj;
		var uri = appConfig.service_application;
		console.log(uri);
		$.ajax({
            type: "POST",
            dataType:"json",
            cache: false,
            url: uri + '/template/tempList',
            success: function(data, textStatus, jqXHR){
                tempObj = data;
                $.each(data, function(index, value) {
					$('#select').append('<option value="' + value.id + '">' + value.templateName + '</option>');
				})               
            },
            error: function(jqXHR, textStatus, errorThrown){
                console.log(errorThrown);  
            }
        });
		
		$('#select').change(function() {
			var templateId = $(this).val();
			
			$(tempObj).each(function () {
				if(this.id == templateId) {
					console.log(this)
					var htmlString = "<span><b>Template Name : </b>"+this.templateName +"</span> &nbsp"+
					"<span><b>Site Type : </b>"+this.siteType +"</span> &nbsp"+
					"<span><b>Site Sub Type : </b>"+this.siteSubType +"</span> &nbsp"+
					"<span><b>Sub Market : </b>"+this.subMarket +"</span><br>"+
					"<span><b>Vendor Name : </b>"+this.vendorName +"</span> &nbsp"+
					"<span><b>Project Type : </b>"+this.projectType +"</span> &nbsp"+
					"<span><b>Candidate Type : </b>"+this.candidateType +"</span> &nbsp"+
					"<span><b>Encloser : </b>"+this.encloser +"</span><br>"+
					"<span><b>Generator : </b>"+this.generator +"</span> &nbsp"+
					"<span><b>Ran Vendor : </b>"+this.ranVendor +"</span> &nbsp"+
					"<span><b>Activity Type : </b> "+this.activityType +"</span> &nbsp"+
					"<span><b>Band : </b>"+this.band +"</span>"
					$('#templateDetails').html(htmlString);
				}
				$('b').css("color", "red");
				$('b .pdrght').css("padding-right", "5px");
			})
			
			if(templateId) {
				
				$("#grid").kendoGrid({
		            dataSource: {
		                transport: {
		                    read: function(options) {
		                    	loadTemplateItems(options, templateId);
		                    },
				schema: {
		        	 model: {
                        id: "id",
                        fields: {
                         name: {type:"string"},
                       	 model: {type:"string"}, 
                       	 description: {type:"string"},
                       	 quantity: {type:"string"},
                       	 activity: {type:"string"},
                       	 comments: {type:"string"},
                       	 contactId: {type:"string"}
                        }
                    }
		        },
		                },
		                pageSize: 20
		            },
		            groupable: false,
		            sortable: true,
                    filterable: true,
		            pageable: {
		                refresh: true,
		                pageSizes: true,
		                buttonCount: 5
		            },
		            columns: [{field: "items.name", title: "Name"},
		            	{field: "items.model", title: "Model"},
		            	{field: "items.description", title: "Descripton"}, 
		            	{field: "quantity", title: "Quantity"}, 
		            	{field: "items.activity", title: "Activity"},
		            	{field: "items.comments", title: "Comments"},
		            	{field: "items.contactId", title: "Contact Id"}
		            ]
		        });
				
			}
		})
		
		function loadTemplateItems(options, templateId) {
			$.ajax({
	            type: "POST",
	            dataType:"json",
	            cache: false,
	            url: uri + '/template/tempImport/' + templateId,
	            success: function(data){
	            	console.log(data);
	            	options.success(data);
	            },
	            error: function(jqXHR, textStatus, errorThrown){
	                console.log(errorThrown);  
	            }
        	});
		}
		
	})
</script>
</body>
</html>