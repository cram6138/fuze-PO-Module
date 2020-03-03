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
  

<style>
    a.btn.btn-primary.btn-user.btn-block.d-lg-inline{
        margin:2px;
    }
    
    #name-link,#name-link1{
    color:blue;
    text-decoration: underline;
    }
    .modal-lg, .modal-xl{
    max-width:90% !important;
    }
    #PoRequestId .modal-header{
        display: block;
    }
    .card.shadow.mb-4 {
    width:100%;
    }
    .k-panelbar>.k-item>.k-link{
    color:#e74a3b;}
    .k-panelbar>.k-item>.k-link.k-state-selected.k-state-hover, .k-panelbar>.k-item>.k-link.k-state-selected:hover,.k-panelbar>.k-item>.k-link.k-state-selected{
        background-color: #f7f7f7;
    color: black;
    }
    .padding-10{
    display:block;
    position:relative;
    padding:10px;
    }
    
    
</style>

  <script src="static/js/jquery.min.js"></script>
  <script src="static/js/kendo.all.min.js"></script>
  <!-- Custom fonts for this template-->

</head>

<body>
<%@ include file="header.jsp"%>
	  <div class="container-fluid">
        
<div class="row">
    <div class="card shadow mb-4">
    
        <div class="card-body">
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
                                <li class="k-state-active">
                                      View Cart
                                </li>
                                <li>
                                    Equipment Planning
                                </li>
                                <li>
                                    Catalog
                                </li>
                                
                            </ul>
                            <div>
                            <div class="row">
			  <div class="col-sm-3 d-inline">
			  <div class="form-group">
			  <label>&nbsp;</label>
			  <div>
<a href="#"  onclick="listofItem()" class="btn btn-danger ">Project List</a>
			  
			  </div>
			  </div>
			  
			  </div>
              <div class="col-sm-3 d-inline">
              <div class="form-group">
              <label>Name Of the PO</label>
              <input type="text" class="form-control"/>
              </div>
              </div>
              <div class="col-sm-3 d-inline">
               <div class="form-group">
               <label>Teritory</label>
               <input type="text" class="form-control"/>
               </div>
              </div>
              <div class="col-sm-3 d-inline">
               <div class="form-group">
               <label>Market</label>
<input type="text" class="form-control"/>
               </div>
              </div>
              </div>
 <h3 style="text-align: center; color: blue;">List Of Cart Details</h3>
	<form action="/POsList" id="addPOForm">
		<table id="records_table" class="table table-striped">
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
		</table>
		<input type="button" id="addPO"
			style="margin-left: 45%; color: white; background-color: blue;"
			value="SUBMIT" />

	</form>
                                                          </div>
                            <div>
                                <span class="sunny">&nbsp;</span>
                                <div class="weather">
                                    <h2>29<span>&ordm;C</span></h2>
                                    <p>Sunny weather in New York.</p>
                                </div>
                            </div>
                            <div>
                                <span class="sunny">&nbsp;</span>
                                <div class="weather">
                                    <h2>21<span>&ordm;C</span></h2>
                                    <p>Sunny weather in London.</p>
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
			$(document).ready(
					function() {
						var oldValue = [];
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
								$('#records_table').append(trHTML);
							}
						});
						$("#addPO").on("click", function() {
							var poName=$("#poName").val;
							var teritory_123=$("#teritory_123").val;
							var Market_2=$("#Market_2").val;
							var pslc=$("#pslc").val;
							var siteTracker=$("#siteTracker").val;
							var baseURL = appConfig.service_application;
							$.ajax({
								url : baseURL+'/createPORequest',
								type : 'POST',
								dataType : "json",
								contentType : "application/json",

								data : JSON.stringify({"poName": poName,
									"teritory": teritory_123,
									"market": Market_2,
									"pslc": pslc,
									"siteTracker": siteTracker,
									"poStatus": "poStatus",
									"poitems" : oldValue,
									"projectIds" : [2]
							
						}),
								success : function(response) {
									console.log(response);
									if(response.pores.status == true) {
										alert("PO Request Created Successfuly.");
										location.reload(true)
									} else {
										alert("Something went wrong.");
									}
								}
							})
						})
					});
					});
		</script>
</body>

</html>
