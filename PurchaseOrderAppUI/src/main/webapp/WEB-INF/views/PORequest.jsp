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
  <style>
  
  #appendto {
    position: fixed;
    bottom: 30px;
    right: 30px;
    width: 200px;
  }
  .form-control{
     height: 2.2rem !important;
    padding: 0px !important;
  }
  .k-animation-container,.k-widget.k-popup.k-notification.k-notification-info.k-state-border-up{
padding: 10px;
    height: 50px !important;
  }
  
  </style>

</head>

<body>
<%@ include file="header.jsp"%>
<div class="container-fluid">  
<span id="popupNotification" style="display:none;"></span>      
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
			  <div class="col-sm-4 d-inline">
			  
			  <a href="#"   onclick="getRequestData()"  class="btn btn-danger">Create PO Request </a>
			   <a href="#"   onclick="generateExcel()"  class="btn btn-danger">Generate Excel </a>
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
                             <li id="tab1" class="k-state-active"> Catalog</li>
                             <!-- <li id="tab2"> Equipment Planning </li> -->
                             <li id="tab3"> View Cart </li>
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
							  <table  class="table table-bordered table-sm">
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
							<button type="button" id="addCart" class="btn btn-primary"  onclick="redirectToCart()">Add to Cart</button>
							</div>
						</div>
		        			</div>
		        			</div>
		        			
		       
                           <!--  <div>
                                <span class="sunny">&nbsp;</span>
                                <div class="weather">
                                    <h2>21<span>&ordm;C</span></h2>
                                    <p>Sunny weather in London.</p>
                                </div>
                            </div> -->
                           <div>
                             <div class="row">
			  					<div class="col-sm-3">
			  					 <form action="/POsList" id="addPOForm">
							<div class="form-group">
							<label>Enter PO Name:</label>
        	<input type="text" class="form-control"  id="poName" placeholder="Enter PO Name">
        </div>
		<div class="form-group">
		<label>Enter Teritory:</label>
            <input type="text" class="form-control"  id="teritory" placeholder="Enter Teritory">
        </div>
        <div class="form-group">
        <label>Enter Market:</label>
            <input type="text" class="form-control"  id="market_po" placeholder="Enter Market">
        </div>
        <div class="form-group">
        <label>Enter Pslc:</label>
            <input type="text" class="form-control" id="pslc" placeholder="Pslc">
        </div>
        <div class="form-group">
        <label>Enter Site Tracker:</label>
            <input type="text" class="form-control" id="siteTracker" placeholder="Site Tracker">
        </div>
        <div class="form-group">
          <input type="button"  onclick="listofItem()" class="btn btn-danger" value="Select ProjectList" />
			               
        	<input type="button" id="addPO" class="btn btn-info" value="Generate PO" />
		</div>		
				
        </form>
        </div>	
			  				<div class="col-sm-9">
          
							<table  class="table-responsive table table-bordered table-sm">
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
							<tbody id="records_table"></tbody>
							</table>
									    
							  </div>
				    	</div>
 				
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
        <button type="button" class="btn btn-default" data-dismiss="modal1" onclick="closeModel()">OK</button>
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
  <div id="appendto"></div>

<div id="elementToasert" aria-live="polite" aria-atomic="true" style="position: relative; min-height: 200px;">
  <div class="toast" style="position: absolute; top: 0; right: 0;">
    <div class="toast-header">
      <img src="..." class="rounded mr-2" alt="...">
      <strong class="mr-auto">Bootstrap</strong>
      <small>11 mins ago</small>
      <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="toast-body">
      Hello, world! This is a toast message.
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
var tabToActivate1 = $("#tab1");
var tabToActivate2 = $("#tab2");
var tabToActivate3 = $("#tab3");
var cartItemList=[];
var CurrentCatalogData =[];
var CurrentCartList=[];
var currentSelectedtype ="";
var cart="";
var oldValue = [];
var oldValueIds=[];
var tempObj;
var popupNotification = $("#popupNotification").kendoNotification({
		 position: {
             pinned: true,
             top: 30,
             right: 30,
             appendTo: "#appendto"
         }
         }).data("kendoNotification");
		$(document).ready(
					function() {
	$("#nonCatalog").hide();
						$("#addCart").hide();
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
									"projectIds" :[2]
									//"projectIds" :[checkedProjectList.toString()]
							
						}),
								success : function(response) {
									console.log(response);
									if(response.status == true) {
										//alert("PO Request Created Successfuly.");
					                    popupNotification.show("PO Request Created Successfuly", "info");
										//var refreshGrid =$("#grid").data("kendoGrid");
										//$("#details").data("kendoGrid").refresh();
										//refreshGrid.refresh();
										//selectedPODetail();
										//openPODetail();
										//clearCart();
										location.reload(true);
									} else {
										popupNotification.show("Something went wrong", "error");
										//alert("Something went wrong.");
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
							currentSelectedtype=selectedType;
							
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
	                $("#addCart").show();
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
				                $("#addCart").show();
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
					                $("#addCart").show();
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
				var listText=[];
				var CartList={};
				if(cart== ""){
					if(currentSelectedtype=="catalog"){
						listText.push('{"itemId":' + cartItemList[0].id +',"quantity":'+cartItemList[0].vendorId+'}');
							
					}else{
						$.each(cartItemList, function(index, value) {
					    	 listText.push('{"itemId":' + value.items.id +',"quantity":'+value.quantity+'}');	
							})
					}
					//var obj={};
					//obj= JSON.parse('{"cartId":1,"itemIds":['+listText+']}');
				var	obj= '{"cartId":1,"itemIds":['+listText+']}';
					//var coverJson=[];
					//coverJson.push(obj);
				}
				
				//console.log(cartItemList);
				
			//	alert(cart);
				$.getScript("static/js/config.js", function(){
					var baseURL = appConfig.service_application;
						$.ajax({
			            type: "POST",
			            dataType:"json",
			            cache: false,
			            url: baseURL + '/addCartItems',
			            contentType : "application/json; charset=utf-8",
			            data:obj,
			            textStatus:"Success",
			            success: function(data, textStatus, jqXHR){
			            	if(data.status == "success") {
			            		//$('#elementToasert').toast('show')
			            		// var d = new Date();
			                  //  popupNotification.show(kendo.toString(d, 'HH:MM:ss.') + kendo.toString(d.getMilliseconds(), "000"), "error");
			             
			            	popupNotification.show("List of Items Added into Cart.", "info");
								//alert("List of Items Added into Cart.");
								//selectedPODetail();
								$("#tabstrip").kendoTabStrip().data("kendoTabStrip").activateTab(tabToActivate3);
								getCartItemList1();
							} else {
								popupNotification.show("Something went wrong", "error");
								//alert("Something went wrong.");
							}
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
		        function getCartItemList1(){
		        	var tempObj;
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
		        	});
		        }
		</script>
		<script id="emailTemplate" type="text/x-kendo-template">
        <div class="new-mail">
            <img src="../content/web/notification/envelope.png" />
            <h3>#= title #</h3>
            <p>#= message #</p>
        </div>
    </script>

    <script id="errorTemplate" type="text/x-kendo-template">
        <div class="wrong-pass">
            <img src="../content/web/notification/error-icon.png" />
            <h3>#= title #</h3>
            <p>#= message #</p>
        </div>
    </script>

    <script id="successTemplate" type="text/x-kendo-template">
        <div class="upload-success">
            <img src="../content/web/notification/success-icon.png" />
            <h3>#= message #</h3>
        </div>
    </script>

</body>

</html>
