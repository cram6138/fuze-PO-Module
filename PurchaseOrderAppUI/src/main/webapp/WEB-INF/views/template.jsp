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
		<div>
			<span>
				<select id="selectType">
					<option value="">-- Import option -- </option>
					<option value="template"> Import Template </option>
					<option value="eQuote"> Import eQuote</option>
					<option value="catalog"> Import Catalog--</option>
				</select>
			</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<span id="etd">
				<select id="selected"></select>
			</span>
		</div>
		<br>
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
		var baseUrl = appConfig.service_application;
		
		// $('#etd').children().prop('disabled',true);
		$('#etd').hide();
		$('#selectType').change(function() {
			var selectedType = $(this).val();
			if(selectedType == 'template') {
				getTemplateDropdown(baseUrl);
			} else if(selectedType == 'eQuote') {
				geteQuoteDropdown(baseUrl);
			} else if (selectedType == 'catalog') {
				getCatalogDropdown(baseUrl);
			}
			
		})
		
		
		$('#selected').change(function() {
			var objId = $(this).val();
			var selectedType = $('#selectType').val();
			console.log(selectedType);
			loadGridData(objId, selectedType);
			
		})
		
		function loadGridData(objId, selectedType) {
			$(tempObj).each(function () {
				if(this.id == objId) {
					console.log(this)
					var htmlString = "<span><b>Template Name : </b>"+this.name +"</span> &nbsp"+
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
			
			if(objId) {
				
				$("#grid").kendoGrid({
		            dataSource: {
		                transport: {
		                    read: function(options) {
		                    	loadTemplateItems(options, objId, selectedType);
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
		}
		
		function getTemplateDropdown(baseUrl) {
			$.ajax({
	            type: "POST",
	            dataType:"json",
	            cache: false,
	            url: baseUrl + '/template/tempList',
	            success: function(data, textStatus, jqXHR){
	            	// $('#etd').children().prop('disabled',false);
	            	$('#etd').show();
	                tempObj = data;
	                $('#selected').empty();
	                $('#selected').append('<option value=""> -- Select option -- </option>');
	                $.each(data, function(index, value) {
						$('#selected').append('<option value="' + value.id + '">' + value.name + '</option>');
					})               
	            },
	            error: function(jqXHR, textStatus, errorThrown){
	                console.log(errorThrown);  
	            }
	        });
				
		}
		
		function geteQuoteDropdown(baseUrl) {
			$.ajax({
	            type: "GET",
	            dataType:"json",
	            cache: false,
	            url: baseUrl + '/template/eQuotes',
	            success: function(data, textStatus, jqXHR){
	            	// $('#etd').children().prop('disabled',false);
	            	$('#etd').show();
	                tempObj = data;
	                $('#selected').empty();
	                $('#selected').append('<option value=""> -- Select option --  </option>');
	                $.each(data, function(index, value) {
						$('#selected').append('<option value="' + value.id + '">' + value.name + '</option>');
					})               
	            },
	            error: function(jqXHR, textStatus, errorThrown){
	                console.log(errorThrown);  
	            }
	        });
		}
		
		function getCatalogDropdown(uri) {
			
		}
		
		function loadTemplateItems(options, objId, selectedType) {
			var callUrl;
			if (selectedType == 'eQuote') {
				callUrl = baseUrl + '/template/eQuoteImport/' + objId;
			} else if (selectedType == 'template') {
				callUrl = baseUrl + '/template/tempImport/' + objId;
			}
			$.ajax({
	            type: "POST",
	            dataType:"json",
	            cache: false,
	            url: callUrl,
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