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
  <title>PO FUZE - Dashboard</title>
  <!-- Custom fonts for this template-->
  <link href="static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="static/css/po-admin.min.css" rel="stylesheet">
  <link rel="stylesheet" href="static/css/kendo.default-v2.min.css" />
<style>
.k-panelbar>.k-item>.k-link.k-state-selected {
    color: black;
    background-color: #f4f4f4;
}
</style>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
      <div id="content">

        <nav class="navbar navbar-expand navbar-light bg-white topbar  static-top shadow">

          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>


          <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
            <span class="sidebar-brand-icon rotate-n-15">
              <i class="fas fa-laugh-wink"></i>
            </span>
            <span class="sidebar-brand-text mx-3">FUZE <sup>Ginger</sup></span>
          </a>


          <ul class="navbar-nav ml-auto">


            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>

              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>


            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>

              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <span class="mr-3">
                    <span class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </span>
                  </span>
                  <span>
                    <span class="small text-gray-500">December 12, 2019</span>
                    <span class="font-weight-bold">A new monthly report is ready to download!</span>
                  </span>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <span class="mr-3">
                    <span class="icon-circle bg-success">
                      <i class="fas fa-donate text-white"></i>
                    </span>
                  </span>
                  <span>
                    <span class="small text-gray-500">December 7, 2019</span>
                    $290.29 has been deposited into your account!
                  </span>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <span class="mr-3">
                    <span class="icon-circle bg-warning">
                      <i class="fas fa-exclamation-triangle text-white"></i>
                    </span>
                  </span>
                  <span>
                    <span class="small text-gray-500">December 2, 2019</span>
                    Spending Alert: We've noticed unusually high spending for your account.
                  </span>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>
            
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="POViewCart">
                <i class="fa fa-cart-plus"></i>
                <!-- PO Cart -->
                <span class="badge badge-danger badge-counter">2</span>
              </a>
            
            </li>

            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">User Name</span>
                <img class="img-profile rounded-circle" src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png">
              </a>

              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>
	</nav>
         <nav class="navbar navbar-expand navbar-light topbar mb-4 mb-1  static-top">

          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form> -->

          <!-- Topbar Navbar -->
          <ul class="navbar-nav">

            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${index}" href="index" id="alertsDropdown">
                Home
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${PORequest}" href="PORequest" id="alertsDropdown">
                PO Request
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>

            <%-- <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${POTracker}" href="POTracker" id="alertsDropdown">
                PO Tracker
              </a>
            </li> --%>

            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${classActiveSettings}" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                PO Fallout
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>

            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${template}" href="templates" id="alertsDropdown">
                PO Template
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
             <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="templates" id="alertsDropdown">
                Service Contract Admin
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
             <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${template}" href="templates" id="alertsDropdown">
                Container
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
             <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle ${template}" href="templates" id="alertsDropdown">
                User Info
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>

            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="reports" id="alertsDropdown">
                Reports
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
            
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="reports" id="alertsDropdown">
                Admin
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="reports" id="alertsDropdown">
                Support
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
			
          </ul>

        </nav>
        <!-- End of Topbar -->
<div class="container-fluid">        
<div class="row">
    <div class="card shadow mb-4" id="example">
        <div class="card-body demo-section k-content">
        	<ul  id="panelbar">
            <li  id="ProjectSearch">
                My Reservations
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
            <label style="color:#e74a3b;">Local Market</label>
            <input  class="form-control" id="SubMarket">
          </div>
          <div class="col-sm-3">
            <label style="color:#e74a3b;">Container Code</label>
            <input  class="form-control" id="SubMarket">
          </div>
          <div class="col-sm-3">
            <label style="color:#e74a3b;">Buyer</label>
            <input  class="form-control" id="SubMarket">
          </div>
          <div class="col-sm-3">
            <label style="color:#e74a3b;">Project ID</label>
            <input  class="form-control" id="SubMarket">
          </div>
          <div class="col-sm-3">
            <label style="color:#e74a3b;">Search Key</label>
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
       
        
        </div>
        </div>
            </li>
            <li id="SiteProjectDetails">
                Container Search / Reserve
            <div class="padding-10">
			<div class="row">
			  
              </div>
              </div>
			<div class="table-responsive">
			<div id="details"></div>
			</div>
         </li>
            <li id="PORequestDetails">
                Container Details
                <div>
              test1
                </div>
            </li>
               <li id="ContainerReserve">
                Container Reserve/ UnReserve
            <div class="padding-10">
			<div class="row">
			  
              </div>
              </div>
              <div class="table-responsive">
			<div id="containerdetails"></div>
			</div>
         </li>
        </ul>
    </div>
    </div>
      </div>
      </div>
        <!-- /.container-fluid -->
	<footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; FUZE Ginger 2020</span>
          </div>
        </div>
      </footer>
 
  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  </div>
  </div>
  </div>

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
  <script src="vendor/jquery/jquery.min.js"></script> 
  <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="https://demos.telerik.com/kendo-ui/content/shared/js/console.js"></script>

  <!-- Core plugin JavaScript-->
 <!--  <script src="static/vendor/jquery-easing/jquery.easing.min.js"></script> -->

  <!-- Custom scripts for all pages-->
    <script src="static/js/jquery.min.js"></script>
  <script src="static/js/kendo.all.min.js"></script>
  <script src="static/js/reservation.js"></script>
  <script src="static/js/po-admin.min.js"></script>
</body>
</html>
