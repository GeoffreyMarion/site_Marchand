<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Visite</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- App favicon -->
<link rel="shortcut icon" href="assets/images/favicon.ico">

<!-- jvectormap -->
<link href="assets/libs/jqvmap/jqvmap.min.css" rel="stylesheet" />

<!-- DataTables -->
<link href="assets/libs/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/libs/datatables/responsive.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />

<!-- App css -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/icons.min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/app.min.css" rel="stylesheet" type="text/css" />

</head>
<body class="left-side-menu-dark">

	<c:import url="a_header" />

	<!-- Begin page -->
	<div id="wrapper" style="overflow: scroll">


		<div class="content-page">
			<div class="content">

				<!-- Start Content-->
				<div class="container-fluid">

					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<h4 class="page-title">Visites</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="d-flex flex-wrap">
						<form class="col-5 d-flex flex-wrap" role="search" method="post"
							action=a_visite id="recherche">
							<input type="search"
								class="form-control form-control-dark text-black col-5 me-3"
								placeholder="Rechercher..." aria-label="Search" name="mot">
								<button class="btn btn-dark btn-sm" type="submit" form="recherche">
							<img src="icones/icon_loop.png" width="18" alt="Loop" />
						</button>
						</form>
						<form class="col-5 form d-flex flex-wrap" method="post" action=a_visite>
										 <div class="form-group row">
                                            <div class="col-9">
                                                <input type="date"
								class="form-control form-control-dark text-black"
								placeholder="Rechercher..." aria-label="Search" name="date">
                                            </div>
                                        </div>
										<button type="submit"
											class="btn btn-light waves-effect waves-light width-md" name="s-date">Chercher</button>
									</form>
					</div>
					<div class="row">
						<br>
					</div>
					
					<!-- end row -->

					<div class="row">
						<div class="col-lg-12">
							<div class="card-box">

								<div class="table-responsive">
									<table class="table mb-0 text-bg-dark">
										<thead>
											<tr>
												<th>#</th>
												<th>Produit</th>
												<th>Utilisateur</th>
												<th>Date</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${ListVisite}" var="visite">
												<tr>
													<th scope="row">${visite.id_visite}</th>
													<td>${visite.produit.id_produit}-${visite.produit.titre_produit}</td>
													<td>${visite.utilisateur.prenom} ${visite.utilisateur.nom}</td>
													<td>${visite.date_visite}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- end card-box -->
						</div>
						<!-- end col -->
					</div>

				</div>
				<!-- container -->

			</div>
			<!-- content -->

			<!-- Footer Start -->
			<footer class="footer">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12 text-center">
							2018 - 2019 &copy; Greeva theme by <a href="">Coderthemes</a>
						</div>
					</div>
				</div>
			</footer>
			<!-- end Footer -->

		</div>

		<!-- ============================================================== -->
		<!-- End Page content -->
		<!-- ============================================================== -->


	</div>
	<!-- END wrapper -->

	<!-- Right Sidebar -->
	<div class="right-bar">
		<div class="rightbar-title">
			<a href="javascript:void(0);" class="right-bar-toggle float-right">
				<i class="mdi mdi-close"></i>
			</a>
			<h5 class="m-0 text-white">Settings</h5>
		</div>
		<div class="slimscroll-menu">
			<!-- User box -->
			<div class="user-box">
				<div class="user-img">
					<img src="assets/images/users/avatar-1.jpg" alt="user-img"
						title="Mat Helme" class="rounded-circle img-fluid"> <a
						href="javascript:void(0);" class="user-edit"><i
						class="mdi mdi-pencil"></i></a>
				</div>

				<h5>
					<a href="javascript: void(0);">Prenom Nom</a>
				</h5>
				<p class="text-muted mb-0">
					<small>Admin Head</small>
				</p>
			</div>

			<!-- Settings -->
			<hr class="mt-0" />
			<h5 class="pl-3">Basic Settings</h5>
			<hr class="mb-0" />


			<div class="p-3">
				<div class="checkbox checkbox-primary mb-2">
					<input id="checkbox1" type="checkbox" checked> <label
						for="checkbox1"> Notifications </label>
				</div>
				<div class="checkbox checkbox-primary mb-2">
					<input id="checkbox2" type="checkbox" checked> <label
						for="checkbox2"> API Access </label>
				</div>
				<div class="checkbox checkbox-primary mb-2">
					<input id="checkbox3" type="checkbox"> <label
						for="checkbox3"> Auto Updates </label>
				</div>
				<div class="checkbox checkbox-primary mb-2">
					<input id="checkbox4" type="checkbox" checked> <label
						for="checkbox4"> Online Status </label>
				</div>
				<div class="checkbox checkbox-primary mb-0">
					<input id="checkbox5" type="checkbox" checked> <label
						for="checkbox5"> Auto Payout </label>
				</div>
			</div>

			<!-- Timeline -->
			<hr class="mt-0" />
			<h5 class="pl-3 pr-3">
				Messages <span class="float-right badge badge-pill badge-danger">25</span>
			</h5>
			<hr class="mb-0" />
			<div class="p-3">
				<div class="inbox-widget">
					<div class="inbox-item">
						<div class="inbox-item-img">
							<img src="assets/images/users/avatar-1.jpg"
								class="rounded-circle" alt="">
						</div>
						<p class="inbox-item-author">
							<a href="javascript: void(0);" class="text-dark">Chadengle</a>
						</p>
						<p class="inbox-item-text">Hey! there I'm available...</p>
						<p class="inbox-item-date">13:40 PM</p>
					</div>
					<div class="inbox-item">
						<div class="inbox-item-img">
							<img src="assets/images/users/avatar-2.jpg"
								class="rounded-circle" alt="">
						</div>
						<p class="inbox-item-author">
							<a href="javascript: void(0);" class="text-dark">Tomaslau</a>
						</p>
						<p class="inbox-item-text">I've finished it! See you so...</p>
						<p class="inbox-item-date">13:34 PM</p>
					</div>
					<div class="inbox-item">
						<div class="inbox-item-img">
							<img src="assets/images/users/avatar-3.jpg"
								class="rounded-circle" alt="">
						</div>
						<p class="inbox-item-author">
							<a href="javascript: void(0);" class="text-dark">Stillnotdavid</a>
						</p>
						<p class="inbox-item-text">This theme is awesome!</p>
						<p class="inbox-item-date">13:17 PM</p>
					</div>

					<div class="inbox-item">
						<div class="inbox-item-img">
							<img src="assets/images/users/avatar-4.jpg"
								class="rounded-circle" alt="">
						</div>
						<p class="inbox-item-author">
							<a href="javascript: void(0);" class="text-dark">Kurafire</a>
						</p>
						<p class="inbox-item-text">Nice to meet you</p>
						<p class="inbox-item-date">12:20 PM</p>

					</div>
					<div class="inbox-item">
						<div class="inbox-item-img">
							<img src="assets/images/users/avatar-5.jpg"
								class="rounded-circle" alt="">
						</div>
						<p class="inbox-item-author">
							<a href="javascript: void(0);" class="text-dark">Shahedk</a>
						</p>
						<p class="inbox-item-text">Hey! there I'm available...</p>
						<p class="inbox-item-date">10:15 AM</p>

					</div>
				</div>
				<!-- end inbox-widget -->
			</div>
			<!-- end .p-3-->

		</div>
		<!-- end slimscroll-menu-->
	</div>
	<!-- /Right-bar -->

	<!-- Right bar overlay-->
	<div class="rightbar-overlay"></div>

	<!-- Vendor js -->
	<script src="assets/js/vendor.min.js"></script>

	<!-- KNOB JS -->
	<script src="assets/libs/jquery-knob/jquery.knob.min.js"></script>
	<!-- Chart JS -->
	<script src="assets/libs/chart-js/Chart.bundle.min.js"></script>

	<!-- Jvector map -->
	<script src="assets/libs/jqvmap/jquery.vmap.min.js"></script>
	<script src="assets/libs/jqvmap/jquery.vmap.usa.js"></script>

	<!-- Datatable js -->
	<script src="assets/libs/datatables/jquery.dataTables.min.js"></script>
	<script src="assets/libs/datatables/dataTables.bootstrap4.min.js"></script>
	<script src="assets/libs/datatables/dataTables.responsive.min.js"></script>
	<script src="assets/libs/datatables/responsive.bootstrap4.min.js"></script>

	<!-- Dashboard Init JS -->
	<script src="assets/js/pages/dashboard.init.js"></script>

	<!-- App js -->
	<script src="assets/js/app.min.js"></script>

</body>
</html>