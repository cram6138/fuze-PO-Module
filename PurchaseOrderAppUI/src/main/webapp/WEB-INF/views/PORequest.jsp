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
    #name-link{
    color:blue;
    text-decoration: underline;
    }
</style>

  <script src="static/js/jquery.min.js"></script>
  <script src="static/js/kendo.all.min.js"></script>
  <!-- Custom fonts for this template-->

</head>

<body>
<%@ include file="header.jsp"%>
	  <div class="container-fluid">


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
        
<div class="row">
    <div class="card shadow mb-4">
        <div class="card-body">
        <div class="table-responsive">
								<div id="example">
									<div id="grid"></div>
									<div id="details"></div>



						
								</div>



							</div>
            <!-- <div id="grid"></div> -->  
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
  $(document).ready(function() {
	  });
 /*  $("#Teritory").kendoDropDownList({
     dataSource: ["East", "West"],
     value: "East" 
});
$("#Markets").kendoDropDownList({
     dataSource: ["East Markets", "West Markets"],
     value: "East Markets"
});
$("#SubMarket").kendoDropDownList({
     dataSource: ["subMarket1", "subMarket2"],
     value: "subMarket1"
}); */

</script>

</body>

</html>
