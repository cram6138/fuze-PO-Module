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
  
  <script>
 
  </script>

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">
	<!-- Sidebar -->
    <!-- End of Sidebar -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
      <div id="content">
      <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar  static-top shadow">
          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
            <span class="sidebar-brand-icon rotate-n-15">
              <i class="fas fa-laugh-wink"></i>
            </span>
            <span class="sidebar-brand-text mx-3">FUZE <sup>Ginger</sup></span>
          </a>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
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

            <!-- Nav Item - Alerts -->
           <!--  <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                Counter - Alerts
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              Dropdown - Alerts
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
            </li> -->
            
           <!--  <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="POViewCart">
                <i class="fa fa-cart-plus"></i>
                PO Cart
                <span class="badge badge-danger badge-counter">2</span>
              </a>
            
            </li> -->

            <!-- Nav Item - Messages -->

<!--             <span class="topbar-divider d-none d-sm-block"> &nbsp;</span> -->
     <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${currentUserInfo.firstName}${currentUserInfo.lastName}</span>
                <img class="img-profile rounded-circle" src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png">
              </a>
              <!-- Dropdown - User Information -->
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
        <!-- End of Topbar -->
         <!-- Topbar -->
         <nav class="navbar navbar-expand navbar-light topbar mb-4 mb-1  static-top">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
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
              <a class="nav-link dropdown-toggle" href="reports" id="alertsDropdown">
                Reports
                <!-- Counter - Alerts -->
                <!-- <span class="badge badge-danger badge-counter">3+</span> -->
              </a>
              <!-- Dropdown - Alerts -->
            </li>
			
          </ul>

        </nav>
        <!-- End of Topbar -->

       
