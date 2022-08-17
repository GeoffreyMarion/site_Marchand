<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Administrateur</title>
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

	<!-- Begin page -->
	<div id="wrapper" style="overflow: scroll">

		<!-- Topbar Start -->

		<c:import url="a_header" />

		<!-- Left Sidebar End -->

		<!-- ============================================================== -->
		<!-- Start Page Content here -->
		<!-- ============================================================== -->

		<div class="content-page">
			<div class="content">

				<!-- Start Content-->
				<div class="container-fluid">

					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
<!-- 								<div class="page-title-right"> -->
<!-- 									<ol class="breadcrumb m-0"> -->
<!-- 										<li class="breadcrumb-item"><a -->
<!-- 											href="javascript: void(0);">Greeva</a></li> -->
<!-- 										<li class="breadcrumb-item"><a -->
<!-- 											href="javascript: void(0);">Email</a></li> -->
<!-- 										<li class="breadcrumb-item active">Inbox</li> -->
<!-- 									</ol> -->
<!-- 								</div> -->
								<h4 class="page-title">Inbox</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="row">

						<!-- Right Sidebar -->
						<div class="col-lg-12">
							<div class="card-box">
								<!-- Left sidebar -->
<!-- 								<div class="inbox-leftbar"> -->

<!-- <!-- 									<a href="email-compose.html" --> -->
<!-- <!-- 										class="btn btn-danger btn-block waves-effect waves-light">Compose</a> --> -->

<!-- 									<div class="mail-list mt-4"> -->
<!-- 										<a href="#" class="list-group-item border-0 text-danger"><i -->
<!-- 											class="mdi mdi-inbox font-18 align-middle mr-2"></i>Inbox<span -->
<!-- 											class="badge badge-danger float-right ml-2 mt-1">8</span></a> <a -->
<!-- 											href="#" class="list-group-item border-0"><i -->
<!-- 											class="mdi mdi-star font-18 align-middle mr-2"></i>Starred</a> <a -->
<!-- 											href="#" class="list-group-item border-0"><i -->
<!-- 											class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>Draft<span -->
<!-- 											class="badge badge-info float-right ml-2 mt-1">32</span></a> <a -->
<!-- 											href="#" class="list-group-item border-0"><i -->
<!-- 											class="mdi mdi-send font-18 align-middle mr-2"></i>Sent Mail</a> -->
<!-- 										<a href="#" class="list-group-item border-0"><i -->
<!-- 											class="mdi mdi-delete font-18 align-middle mr-2"></i>Trash</a> -->
<!-- 									</div> -->

<!-- 									<h6 class="mt-4">Labels</h6> -->

<!-- 									<div class="list-group b-0 mail-list"> -->
<!-- 										<a href="#" class="list-group-item border-0"><span -->
<!-- 											class="mdi mdi-circle text-info mr-2"></span>Web App</a> <a -->
<!-- 											href="#" class="list-group-item border-0"><span -->
<!-- 											class="mdi mdi-circle text-warning mr-2"></span>Recharge</a> <a -->
<!-- 											href="#" class="list-group-item border-0"><span -->
<!-- 											class="mdi mdi-circle text-dark mr-2"></span>Wallet Balance</a> <a -->
<!-- 											href="#" class="list-group-item border-0"><span -->
<!-- 											class="mdi mdi-circle text-primary mr-2"></span>Friends</a> <a -->
<!-- 											href="#" class="list-group-item border-0"><span -->
<!-- 											class="mdi mdi-circle text-success mr-2"></span>Family</a> -->
<!-- 									</div> -->

<!-- 								</div> -->
								<!-- End Left sidebar -->

								<div class="inbox-rightbar">

									<div class="btn-group">
<!-- 										<button type="button" -->
<!-- 											class="btn btn-sm btn-light waves-effect"> -->
<!-- 											<i class="mdi mdi-archive font-18 vertical-middle"></i> -->
<!-- 										</button> -->
<!-- 										<button type="button" -->
<!-- 											class="btn btn-sm btn-light waves-effect"> -->
<!-- 											<i class="mdi mdi-alert-octagon font-18 vertical-middle"></i> -->
<!-- 										</button> -->
										<button type="button"
											class="btn btn-sm btn-light waves-effect">
											<i class="mdi mdi-delete-variant font-18 vertical-middle"></i>
										</button>
									</div>
<!-- 									<div class="btn-group"> -->
<!-- 										<button type="button" -->
<!-- 											class="btn btn-sm btn-light dropdown-toggle waves-effect" -->
<!-- 											data-toggle="dropdown" aria-expanded="false"> -->
<!-- 											<i class="mdi mdi-folder font-18 vertical-middle"></i> <i -->
<!-- 												class="mdi mdi-chevron-down font-14 ml-1"></i> -->
<!-- 										</button> -->
<!-- 										<div class="dropdown-menu"> -->
<!-- 											<span class="dropdown-header">Move to</span> <a -->
<!-- 												class="dropdown-item" href="javascript: void(0);">Social</a> -->
<!-- 											<a class="dropdown-item" href="javascript: void(0);">Promotions</a> -->
<!-- 											<a class="dropdown-item" href="javascript: void(0);">Updates</a> -->
<!-- 											<a class="dropdown-item" href="javascript: void(0);">Forums</a> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 									<div class="btn-group"> -->
<!-- 										<button type="button" -->
<!-- 											class="btn btn-sm btn-light dropdown-toggle waves-effect" -->
<!-- 											data-toggle="dropdown" aria-expanded="false"> -->
<!-- 											<i class="mdi mdi-label font-18 vertical-middle"></i> <i -->
<!-- 												class="mdi mdi-chevron-down font-14 ml-1"></i> -->
<!-- 										</button> -->
<!-- 										<div class="dropdown-menu"> -->
<!-- 											<span class="dropdown-header">Label as:</span> <a -->
<!-- 												class="dropdown-item" href="javascript: void(0);">Updates</a> -->
<!-- 											<a class="dropdown-item" href="javascript: void(0);">Social</a> -->
<!-- 											<a class="dropdown-item" href="javascript: void(0);">Promotions</a> -->
<!-- 											<a class="dropdown-item" href="javascript: void(0);">Forums</a> -->
<!-- 										</div> -->
<!-- 									</div> -->

<!-- 									<div class="btn-group"> -->
<!-- 										<button type="button" -->
<!-- 											class="btn btn-sm btn-light dropdown-toggle waves-effect" -->
<!-- 											data-toggle="dropdown" aria-expanded="false"> -->
<!-- 											<i class="mdi mdi-dots-horizontal font-18 vertical-middle"></i> -->
<!-- 											More <i class="mdi mdi-chevron-down font-14 ml-1"></i> -->
<!-- 										</button> -->
<!-- 										<div class="dropdown-menu"> -->
<!-- 											<span class="dropdown-header">More Option :</span> <a -->
<!-- 												class="dropdown-item" href="javascript: void(0);">Mark -->
<!-- 												as Unread</a> <a class="dropdown-item" -->
<!-- 												href="javascript: void(0);">Add to Tasks</a> <a -->
<!-- 												class="dropdown-item" href="javascript: void(0);">Add -->
<!-- 												Star</a> <a class="dropdown-item" href="javascript: void(0);">Mute</a> -->
<!-- 										</div> -->
<!-- 									</div> -->

									<div class="mt-4">
										<ul class="message-list">
											<c:forEach items="${ListContact}" var="contact">
											<c:if test="${contact.etat_contact == 0 }"><li class="unread"></c:if>
											<c:if test="${contact.etat_contact == 1 }"><li class="read"></c:if>
												<div class="col-mail col-mail-1">
													<a href="" class="title">${contact.utilisateur.prenom} ${contact.utilisateur.nom}</a>
												</div>
												<div class="col-mail col-mail-2">
													<a href="" class="title">${contact.email}</a>
												</div>
												<div class="col-mail col-mail-3">
													<a href="" class="title">${contact.sujet}</a>
												</div>
												<div class="col-mail col-mail-4">
													<span class="teaser">${contact.message}</span>
												</div>
											</li>
											</c:forEach>
										</ul>
									</div>
									<!-- end .mt-4 -->

<!-- 									<div class="row"> -->
<!-- 										<div class="col-7">Showing 1 - 20 of 289</div> -->
<!-- 										end col -->
<!-- 										<div class="col-5"> -->
<!-- 											<div class="btn-group float-right"> -->
<!-- 												<button type="button" class="btn btn-light btn-sm"> -->
<!-- 													<i class="mdi mdi-chevron-left"></i> -->
<!-- 												</button> -->
<!-- 												<button type="button" class="btn btn-info btn-sm"> -->
<!-- 													<i class="mdi mdi-chevron-right"></i> -->
<!-- 												</button> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 										end col -->
<!-- 									</div> -->
									<!-- end row-->
								</div>
								<!-- end inbox-rightbar-->

								<div class="clearfix"></div>
							</div>
							<!-- end card-box -->

						</div>
						<!-- end Col -->

					</div>
					<!-- End row -->

				</div>
				<!-- container-fluid -->

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
					<a href="javascript: void(0);">Agnes Kennedy</a>
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

	<!-- App js -->
	<script src="assets/js/app.min.js"></script>

</body>
</html>