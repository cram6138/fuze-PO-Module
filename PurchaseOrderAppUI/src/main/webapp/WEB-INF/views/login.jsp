<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PO FUZE Ginger - Login</title>

<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="static/css/po-admin.min.css" rel="stylesheet">
</head>

<body class="bg-gradient-primary">

	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="row justify-content-center">

					<div class="col-xl-10 col-lg-12 col-md-9">

						<div class="card o-hidden border-0 shadow-lg my-5">
							<div class="card-body p-0">
								<!-- Nested Row within Card Body -->
								<div class="row">
									<!-- <div class="col-lg-6 d-none d-lg-block bg-login-image"></div> -->

									<div class="col-lg-12">
										<div class="p-5">
											<div class="text-center logoImageSize">
												<a
													class="sidebar-brand d-flex align-items-center justify-content-center"
													href="../login"> <span
													class="sidebar-brand-icon rotate-n-15"> <i
														class="fas fa-laugh-wink"></i>
												</span> <span class="sidebar-brand-text mx-3"> FUZE <sup>Ginger</sup>
												</span>
												</a>
											</div>
											<form:form action="login" method="post" modelAttribute="loginForm" class="user" id="user">
												<div class="form-group">
													<label>Email Address:</label> 
													<form:input type="email"
														path="username"
														class="form-control form-control-user" 
														aria-describedby="emailHelp"
														placeholder="Enter Email Address..."/>
												</div>
												<div class="form-group">
													<label>Password:</label> 
													<form:input 
														path="password"
														type="password"
														class="form-control form-control-user" id="password"
														placeholder="Password"/>
												</div>
												<%-- <div class="form-group">
													<div class="custom-control custom-checkbox small">
														<form:input path="admin" type="checkbox" class="custom-control-input"
															id="customCheck"/> 
															<label class="custom-control-label" for="customCheck">Admin</label>
													</div>
												</div> --%>

												<button id="btnLogin" type="submit"
													class="btn btn-primary btn-user btn-block">Login</button>

											</form:form>

											<div class="Error_list"></div>
										</div>
									</div>

								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
			<div class="col-sm-2"></div>
		</div>
		<!-- Outer Row -->


	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="static/js/jquery.min.js"></script>
	<script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="static/js/po-admin.min.js"></script>
	<script src="static/js/config.js"></script>

	<script type="text/javascript">
		/* $(document).ready(function() {
			var baseUrl = appConfig.ui_application;

			var userCredential = {};

			$('#btnLogin').click(function() {
				userCredential.username = $('#email').val();
				userCredential.password = $('#password').val();
				userLogin(userCredential);
			})

			function userLogin(userCredential) {
				console.log(baseUrl + '/token');
				$.ajax({
					type : "POST",
					data : JSON.stringify(userCredential),
					contentType : "application/json",
					cache : false,
					url : baseUrl + '/token',
					success : function(data, textStatus, jqXHR) {
						console.log(data);
						//alert(data);
						window.location.replace("index");
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});

			}

		})
 */	</script>
</body>


</html>
