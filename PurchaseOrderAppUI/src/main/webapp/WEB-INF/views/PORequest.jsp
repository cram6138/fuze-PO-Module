<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>PO Request - Dashboard</title>
  <link rel="stylesheet" href="static/css/kendo.default-v2.min.css" />

  <script src="static/js/jquery.min.js"></script>
  <script src="static/js/kendo.all.min.js"></script>
  <script src="static/js/config.js"></script>
  <!-- Custom fonts for this template-->

</head>

<body>
<%@ include file="header.jsp"%>
<div class="container-fluid">        
<div class="row">
    <div class="card shadow mb-4" id="example">
    
        <div class="card-body demo-section k-content">
        	<ul  id="panelbar">
            <li  id="ProjectSearch">
                Project Search
                <div class="row">
                <div class="col-sm-12">
                
                 <form class="user">
               <div class="form-group row">
          <div class="col-sm-3 mb-3 mb-sm-0">
              <label style="color:#e74a3b;">Teritory</label>
            <input class="form-control" id="Teritory" >
          </div>
          <div class="col-sm-3">
            <label style="color:#e74a3b;">Markets</label>
            <input  class="form-control" id="Markets">
          </div>
          <div class="col-sm-3">
            <label style="color:#e74a3b;">Sub Markets</label>
            <input  class="form-control" id="SubMarket">
          </div>
          <div class="col-sm-3">
              <label style="width:100%;">&nbsp;</label>
              
            <a href="#"  id="get" class="btn btn-danger btn-user btn-block d-lg-inline">
                Search
              </a>
              <a href="#" class="btn btn-primary btn-user btn-block d-lg-inline">
                Reset
              </a>
              <a href="#"  class="d-lg-inline" data-toggle="modal" data-target="#advancedSearch">
                Advanced Search
              </a>
              
          </div>
          
        </div>
        </form>
        <div class="table-responsive">
								<div id="grid"></div>
																</div>
        
        </div>
        </div>
            </li>
            <li id="SiteProjectDetails">
                Site Project Details
            <div class="padding-10">
			<div class="row">
			  <div class="col-sm-2 d-inline">
			  
			  <a href="#"   onclick="getRequestData()"  class="btn btn-danger">Create PO Request </a>
			  </div>
              <!-- <div class="col-sm-5 d-inline">
              <div class="form-group">
              <label>New Fuze Request Name</label>
              <textarea rows="2" cols="2" class="form-control"></textarea>
              </div>
              </div>
              <div class="col-sm-5 d-inline">
               <div class="form-group">
               <label>New Fuze Request Description</label>
               <textarea rows="2" cols="2" class="form-control"></textarea>
               </div>
              </div> -->
              </div>
              </div>
			<div class="table-responsive">
			<div id="details"></div>
			</div>
         </li>
            <li id="PORequestDetails">
                PO Request Details
                <div>
                <div id="tabstrip">
                            <ul>
                             <li class="k-state-active"> Catalog</li>
                             <li> Equipment Planning </li>
                             <li> View Cart </li>
                            </ul>
                           <div>
                           <div class="row">
							<div class="col-sm-3">
								<div class="dropdown">
								<div class="form-group">
								    <select class="form-control" id="selectType">
								   	  <option value="">--Select Template--</option>
								      <option value="template">Import Template</option>
								      <option value="eQuote">Import eQuote</option>
								      <option value="catalog">Import Catalog</option>
								    </select>
	  							</div>
	 			 			    </div>
			 				 <div class="dropdown" id="etd">
							<div class="form-group">
							    <select class="form-control" id="selected">
							    </select>
							</div>
		  				   </div>
 
								
					   </div>
							<div class="col-sm-9" >
							<div id="nonCatalog" class="col-padding-margin-5">
							<div class="form-row">
							    <div class="col">
							      <input type="text" class="form-control"  id="ItemId" placeholder="Item id">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control"  id="Itemname" placeholder="Item name">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control" id="ItemDescription" placeholder="Item Description">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control" id="VendorName" placeholder="Vendor Name">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control" id="VendorId" placeholder="Vendor Id">
							    </div>
							    <div class="col">
							    <button type="button" class="btn btn-primary" onclick="getCatalogSearch()">Get</button>
							    </div>
							    
							  </div>
							  <div class="col-padding-margin-5">
							  <table  class="table table-striped">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>description</th>
							<th>vendor</th>
							<th>vendorId</th>
						</tr>
						<tbody id="catalog_table">
						
						</tbody>
					</table>
					</div>
							</div>
							<div id="isListItems">
							<div id="ItemListData"></div>
							</div>
							<div class="col-sm-3">
							<button type="button" class="btn btn-primary"  onclick="redirectToCart()">View Cart</button>
							</div>
						</div>
		        </div>
		        </div>
		       
                            <div>
                                <span class="sunny">&nbsp;</span>
                                <div class="weather">
                                    <h2>21<span>&ordm;C</span></h2>
                                    <p>Sunny weather in London.</p>
                                </div>
                            </div>
                            <div>
                             <div class="row">
			  					<div class="col-sm-2">
							    <div class="form-group">
			                <div><a href="#"  onclick="listofItem()" class="btn btn-danger ">Project List</a></div>
			  				</div>
			  			   </div>
			  			   <div class="col-sm-10">
			  			   
			  		
    <div class="form-row">
							    <div class="col">
							      <input type="text" class="form-control"  id="poName" placeholder="Name Of the PO">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control"  id="teritory" placeholder="Enter Teritory">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control"  id="market_po" placeholder="Enter Market">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control" id="pslc" placeholder="Pslc">
							    </div>
							    <div class="col">
							      <input type="text" class="form-control" id="siteTracker" placeholder="Site Tracker">
							    </div>
							   
					</div>		    
							  </div>
				    	</div>
 				<form action="/POsList" id="addPOForm">
					<table  class="table table-striped">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Contract Id</th>
							<th data-type="date">Due Date</th>
							<th>Ship To Id</th>
							<th>Activity</th>
							<th>Comments</th>
							<th>Model</th>
							<th>Description</th>
							<th>Price</th>
							<th>In Stock</th>
							<th>Quantity</th>
			
						</tr>
						<tbody id="records_table">
						</tbody>
					</table>
					<input type="button" id="addPO"
						style="margin-left: 45%; color: white; background-color: blue;"
						value="SUBMIT" />
				</form>
           </div>
                            </div>
                </div>
            </li>
           
        </ul>
    </div>
    </div>
      </div>
      </div>
        <!-- /.container-fluid -->
	<%@ include file="footer.jsp"%>
 
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="/">Logout</a>
        </div>
      </div>
    </div>
  </div>

<!-- Modal -->
<div class="modal fade" id="advancedSearch" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="advancedSearch">People Soft</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <form>
                <div class="form-group row">
                  <label for="colFormLabelSm" class="col-sm-4 col-form-label col-form-label-sm text-right"><b>PSLC:</b></label>
                  <div class="col-sm-8">
                    <input type="text" class="form-control form-control-sm" id="colFormLabelSm">
                  </div>
                </div>
                <div class="form-group row">
                    <label for="colFormLabelSm" class="col-sm-4 col-form-label col-form-label-sm text-right"><b>PS Project:</b></label>
                    <div class="col-sm-8">
                      <input type="text" class="form-control form-control-sm" id="colFormLabelSm">
                    </div>
                  </div>
                  
                </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Search</button>
        </div>
      </div>
    </div>
  </div>
  
<!-- Modal -->
<div id="PoRequestId" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">
		<!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" onclick="closeModel()" data-dismiss="modal1">&times;</button>
        <h4 class="modal-title">List Of Projects</h4>
      </div>
      <div class="modal-body">
			<div class="table-responsive">
				<div id="grid1"></div>
			</div>
	 </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal1" onclick="closeModel()">Close</button>
      </div>
    </div>
</div>
</div>
  <div class="modal fade" id="advancedSearch" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="advancedSearch">PO Request Data</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Search</button>
        </div>
      </div>
    </div>
  </div>



  <!-- Bootstrap core JavaScript-->
  <!-- <script src="vendor/jquery/jquery.min.js"></script> -->
  <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="https://demos.telerik.com/kendo-ui/content/shared/js/console.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="static/js/custom.js"></script>
  <script src="static/js/po-admin.min.js"></script>
    

  <!-- Page level plugins -->
  <!-- <script src="vendor/chart.js/Chart.min.js"></script> -->

  <!-- Page level custom scripts -->
  <!-- <script src="js/demo/chart-area-demo.js"></script> -->
  <!-- <script src="js/demo/chart-pie-demo.js"></script> -->

<script>
var cartItemList=[];
var CurrentCatalogData =[];
var CurrentCartList=[];
			$(document).ready(
					function() {
						var tempObj;
						
						var oldValue = [];
						var oldValueIds=[];
						$("#nonCatalog").hide();
						$.getScript("static/js/config.js", function(){
							
						var baseURL = appConfig.service_application;
						$.ajax({
							url : baseURL+'/getCartItemsDetails',
							type : 'POST',
							dataType : "json",
							data : JSON.stringify({
								"id" : 1
							}),
							contentType : "application/json; charset=utf-8",
							success : function(response) {
								console.log(response);
								var trHTML = '';
								$.each(response.cartitems,
										function(i, ListData) {
											trHTML += '<tr><td>'
													+ ListData.item.id
													+ '</td><td>'
													+ ListData.item.name
													+ '</td><td>'
													+ ListData.item.contractId
													+ '</td><td>'
													+ ListData.item.dueDate
													+ '</td><td>'
													+ ListData.item.shipToId
													+ '</td><td>'
													+ ListData.item.activity
													+ '</td><td>'
													+ ListData.item.comments
													+ '</td><td>'
													+ ListData.item.model
													+ '</td><td>'
													+ ListData.item.description
													+ '</td><td>'
													+ ListData.item.price
													+ '</td><td>'
													+ ListData.item.inStock
													+ '</td><td>'
													+ ListData.quantity
													+ '</td></tr>';
											oldValue.push(ListData.item.id)
										});
								$('#records_table').empty();
								$('#records_table').append(trHTML);
							}
						});
						$("#addPO").on("click", function() {
							var poName=$("#poName").val();
							var teritory=$("#teritory").val();
							var Market_po=$("#market_po").val();
							var pslc=$("#pslc").val();
							var siteTracker=$("#siteTracker").val();
							var baseURL = appConfig.service_application;
							$.ajax({
								//http://localhost:8080/RePO/getPoRequest   this is API and above one is response right?
								url : baseURL+'/RePO/createPORequest',
								type : 'POST',
								dataType : "json",
								contentType : "application/json",

								data : JSON.stringify({"poName": poName,
									"teritory": teritory,
									"market": Market_po,
									"pslc": pslc,
									"siteTracker": siteTracker,
									"poStatus": "poStatus",
									"poitems" : oldValue,
									"projectIds" : [2]
							
						}),
								success : function(response) {
									console.log(response);
									if(response.status == true) {
										alert("PO Request Created Successfuly.");
										location.reload(true)
									} else {
										alert("Something went wrong.");
									}
								}
							})
						})
					});
						
						$('#etd').hide();
						$('#selectType').change(function() {
							var baseURL = appConfig.service_application;
							var selectedType = $(this).val();
							if(selectedType == 'template') {
								getTemplateDropdown(baseURL);
							} else if(selectedType == 'eQuote') {
								geteQuoteDropdown(baseURL);
							} else if (selectedType == 'catalog') {
								getCatalogDropdown(baseURL);
							}
							
						})
						
	function getTemplateDropdown(baseURL) {
		var baseURL = appConfig.service_application;
		$("#isListItems").hide();
			$.ajax({
	            type: "POST",
	            dataType:"json",
	            cache: false,
	            url: baseURL + '/template/tempList',
	            success: function(data, textStatus, jqXHR){
	            	// $('#etd').children().prop('disabled',false);
	            	$('#etd').show();
	                tempObj = data;
	                $("#nonCatalog").hide();
	                $("#isListItems").show();
	                $('#selected').show();
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
						
						$('#selected').change(function() {
							var objId = $(this).val();
							var selectedType = $('#selectType').val();
							console.log(selectedType);
							loadGridData(objId, selectedType);
							
						})
						
						function loadGridData(objId, selectedType) {
							/* $(tempObj).each(function () {
								if(this.id == objId) {
									console.log(this)
									var htmlString = "<span><b>Template Name : </b>"+this.name +"</span> &nbsp"+
									"<span><b>Site Type : </b>"+this.siteType +"</span> &nbsp"+
									"<span><b>Site Sub Type : </b>"+this.siteSubType +"</span> &nbsp"+
									"<span><b>Sub Market : </b>"+this.subMarket +"</span>&nbsp"+
									"<span><b>Vendor Name : </b>"+this.vendorName +"</span> &nbsp"+
									"<span><b>Project Type : </b>"+this.projectType +"</span><br>"+
									"<span><b>Candidate Type : </b>"+this.candidateType +"</span> &nbsp"+
									"<span><b>Encloser : </b>"+this.encloser +"</span>"+
									"<span><b>Generator : </b>"+this.generator +"</span> &nbsp"+
									"<span><b>Ran Vendor : </b>"+this.ranVendor +"</span> &nbsp"+
									"<span><b>Activity Type : </b> "+this.activityType +"</span> &nbsp"+
									"<span><b>Band : </b>"+this.band +"</span>"
									$('#templateDetails').html(htmlString);
								}
								$('b').css("color", "red");
								$('b .pdrght').css("padding-right", "5px");
							}) */
							
							if(objId) {
								
								$("#ItemListData").kendoGrid({
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
				                       	 quantity: {type:"string"}
				                       	 //activity: {type:"string"},
				                       	 //comments: {type:"string"},
				                       	 //contactId: {type:"string"}
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
						            	{field: "quantity", title: "Quantity"}
						            	//{field: "items.activity", title: "Activity"},
						            	//{field: "items.comments", title: "Comments"},
						            	//{field: "items.contactId", title: "Contact Id"}
						            ]
						        });
								
							}
						}
						
						function getCatalogDropdown(){
							$("#isListItems").hide();
							var baseURL = appConfig.service_application;
							 $("#nonCatalog").show();
				                $('#selected').hide();
							}
						
						function geteQuoteDropdown(baseURL) {
							$("#isListItems").hide();
							$.ajax({
					            type: "GET",
					            dataType:"json",
					            cache: false,
					            url: baseURL + '/template/eQuotes',
					            success: function(data, textStatus, jqXHR){
					            	// $('#etd').children().prop('disabled',false);
					            	$('#etd').show();
					            	 $("#nonCatalog").hide();
						                $('#selected').show();
						                $("#isListItems").show();
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
						
						
						function loadTemplateItems(options, objId, selectedType) {
							var baseURL = appConfig.service_application;
							var callUrl;
							if (selectedType == 'eQuote') {
								callUrl = baseURL + '/template/eQuoteImport/' + objId;
							} else if (selectedType == 'template') {
								callUrl = baseURL + '/template/tempImport/' + objId;
							}else if (selectedType == 'catalog') {
								callUrl = baseURL + '/template/tempImport/' + objId;
								
								
							}
							$.ajax({
					            type: "POST",
					            dataType:"json",
					            cache: false,
					            url: callUrl,
					            success: function(data){
					            	console.log(data);
					            	options.success(data);
					            	cartItemList=data;
					            },
					            error: function(jqXHR, textStatus, errorThrown){
					                console.log(errorThrown);  
					            }
				        	});
						}
						
						
						
					});
			
			function getCatalogSearch(){
				$.getScript("static/js/config.js", function(){
				var baseURL = appConfig.service_application;
				var ItemId=$("#ItemId").val();
				var Itemname=$("#Itemname").val();
				var ItemDescription=$("#ItemDescription").val();
				var VendorName=$("#VendorName").val();
				var VendorId=$("#VendorId").val();
				$.ajax({
		            type: "POST",
		            dataType:"json",
		            cache: false,
		            contentType : "application/json; charset=utf-8",
		            url: baseURL + '/searchItems',
		            data:JSON.stringify({
		            	"id":ItemId,
		            	"name": Itemname,
		                "description":ItemDescription,
		                "vendor": VendorName,
		                "vendorId": VendorId
		            }),
		            success: function(data, textStatus, jqXHR){
		            	// $('#etd').children().prop('disabled',false);
		            	console.log(data);
		            	
		            	var trHTML = '';
						$.each(data,
								function(i, ListData) {
									trHTML += '<tr><td>'
											+ ListData.id
											+ '</td><td>'
											+ ListData.name
											+ '</td><td>'
											+ ListData.description
											+ '</td><td>'
											+ ListData.vendor
											+ '</td><td>'
											+ ListData.vendorId
											
											+ '</td></tr>';
											
								});
						$('#catalog_table').empty();
						$('#catalog_table').append(trHTML);
		            	
		            	cartItemList=data;
		            	/* $('#etd').hide();
		                tempObj = data;
		                $("#nonCatalog").show();
		                $('#selected').hide();
		                $('#selected').append('<option value=""> -- Select option --  </option>');
		                $.each(data, function(index, value) {
							$('#selected').append('<option value="' + value.id + '">' + value.name + '</option>');
						}) */               
		            },
		            error: function(jqXHR, textStatus, errorThrown){
		                console.log(errorThrown);  
		            }
		        });
				
				});
			}
			
			function redirectToCart(){
		     var listText=cartItemList[0].id;
				$.getScript("static/js/config.js", function(){
					var baseURL = appConfig.service_application;
						$.ajax({
			            type: "POST",
			            dataType:"json",
			            cache: false,
			            url: baseURL + '/addCartItems',
			            contentType : "application/json; charset=utf-8",
			            data:JSON.stringify({
			            	   "cartId" : 1,
			            	    "itemIds":[{
			            	    	"itemId":listText,
			            	    	"quantity":20
			            	    	}]
			            	    	
			            	    
			            	}),
			            success: function(data, textStatus, jqXHR){
			            	// $('#etd').children().prop('disabled',false);
			            	console.log(data);
			            	if(data.status == "success") {
								alert("List of Items Added into Cart.");
								location.reload(true);
							} else {
								alert("Something went wrong.");
							}
			            	
			            	/* $('#etd').hide();
			                tempObj = data;
			                $("#nonCatalog").show();
			                $('#selected').hide();
			                $('#selected').append('<option value=""> -- Select option --  </option>');
			                $.each(data, function(index, value) {
								$('#selected').append('<option value="' + value.id + '">' + value.name + '</option>');
							}) */               
			            },
			            error: function(jqXHR, textStatus, errorThrown){
			                console.log(errorThrown);  
			            }
			        });
					
					});
				
			}
			 var checkedProjectList=[];
		        function onChange(e) {
		        	var arryList =[];
		        	checkedProjectList= this.selectedKeyNames().join(", ");
		        	console.log("The selected product ids are: [{" + this.selectedKeyNames().join(", ") + "}]" );
		            //kendoConsole.log("The selected product ids are: [" + this.selectedKeyNames().join(", ") + "]");
		        };
		</script>
</body>

</html>
