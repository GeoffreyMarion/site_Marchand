<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Utilisateurs</title>
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
	<div id="wrapper">


		<div class="content-page">
			<div class="content">

				<!-- Start Content-->
				<div class="container-fluid">

					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div class="page-title-box">
								<h4 class="page-title">Utilisateurs</h4>
							</div>
						</div>
					</div>
					<!-- end page title -->
					
					<a href="a_produit?create=1"><button type="button"
							class="btn btn-success waves-effect waves-light width-md">Create</button></a>
					<div class="row">
						<br>
					</div>
					<c:if test="${creation == true}">
					<div class="alert alert-success" role="alert">Un produit a été créé avec succès</div>
				</c:if>
				<c:if test="${edition == true}">
					<div class="alert alert-success" role="alert">Un produit a été édité avec succès</div>
				</c:if>
				<c:if test="${suppression == true}">
					<div class="alert alert-danger" role="alert">Un produit a été supprimé avec succès</div>
				</c:if>

					<c:if test="${create==1}">
						<div class="row">
							<div class="col-12">
								<div class="card-box">
									<h4 class="header-title" style="color: white;">Create</h4>

									<form class="form-horizontal" method="post">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Titre</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="simpleinput"
													value="Some text value..." name="titre">
											</div>
										</div>
										<div class="form-group row">
                                            <label class="col-sm-3 col-form-label" for="example-textarea">Description</label>
                                            <div class="col-sm-9">
                                                <textarea class="form-control" id="example-textarea" rows="5" name="description"></textarea>
                                            </div>
                                        </div>
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Prix</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" id="simpleinput"
													value="Some text value..." name="prix">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Image</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="simpleinput"
													value="Some text value..." name="image">
											</div>
										</div>
										 <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Sous categorie</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="scat">
                                                	<c:forEach items="${ListSCat}" var="sous_categorie">
                                                    	<option value="${sous_categorie.id_sous_categorie}">${sous_categorie.titre}</option>
													</c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Stock</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" id="simpleinput"
													value="Some text value..." name="stock">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Stock minimum</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" id="simpleinput"
													value="Some text value..." name="stockmin">
											</div>
										</div>
										<button type="submit"
											class="btn btn-light waves-effect waves-light width-md" name="c-create">Envoyer</button>
									</form>

								</div>
								<!-- end card-box -->
							</div>
							<!-- end col -->
						</div>
					</c:if>

					<c:if test="${edit!=null}">
						<div class="row">
							<div class="col-12">
								<div class="card-box">
									<h4 class="header-title" style="color: white;">Update</h4>

									<form class="form-horizontal" method="post">
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Titre</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="simpleinput"
													value="${prod.titre_produit}" name="e-titre">
											</div>
										</div>
										<div class="form-group row">
                                            <label class="col-sm-3 col-form-label" for="example-textarea">Description</label>
                                            <div class="col-sm-9">
                                                <textarea class="form-control" id="example-textarea" rows="5" name="e-description">${prod.description}</textarea>
                                            </div>
                                        </div>
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Prix</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" id="simpleinput"
													value="${prod.prix}" name="e-prix">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Image</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="simpleinput"
													value="${prod.image}" name="e-image">
											</div>
										</div>
										 <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Input Select</label>
                                            <div class="col-sm-9">
                                                <select class="form-control" name="e-scat">
                                                	<c:forEach items="${ListSCat}" var="sous_categorie">
                                                	<c:if test="${sous_categorie.id_sous_categorie == prod.sous_categorie.id_sous_categorie}">
                                                		<option value="${sous_categorie.id_sous_categorie}"selected>${sous_categorie.titre}</option>
                                                	</c:if>
                                                	<c:if test="${sous_categorie.id_sous_categorie != prod.sous_categorie.id_sous_categorie}">
                                                    	<option value="${sous_categorie.id_sous_categorie}">${sous_categorie.titre}</option>
                                                    	</c:if>
													</c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Stock</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" id="simpleinput"
													value="${prod.stock}" name="e-stock">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-sm-3 col-form-label" for="simpleinput">Stock minimum</label>
											<div class="col-sm-9">
												<input type="number" class="form-control" id="simpleinput"
													value="${prod.stock_minimum}" name="e-stockmin">
											</div>
										</div>
										<button type="submit"
											class="btn btn-light waves-effect waves-light width-md" name="c-edit">Envoyer</button>
									</form>

								</div>
								<!-- end card-box -->
							</div>
							<!-- end col -->
						</div>
					</c:if>
					<!-- end row -->

					<div class="row">
						<div class="col-lg-12">
							<div class="card-box">

								<div class="table-responsive">
									<table class="table mb-0 text-bg-dark">
										<thead>
											<tr>
												<th>#</th>
												<th>Titre</th>
												<th>Description</th>
												<th>Prix</th>
												<th>Image</th>
												<th>Sous categorie</th>
												<th>Stock</th>
												<th>Stock min</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${ListProduit}" var="produit">
												<tr>
													<th scope="row">${produit.id_produit}</th>
													<td>${produit.titre_produit}</td>
													<td>${produit.description}</td>
													<td>${produit.prix}</td>
													<td><img alt="${produit.titre_produit}" src="${produit.image}" style="height: 35"></td>
													<td>${produit.sous_categorie.titre}</td>
													<td>${produit.stock}</td>
													<td>${produit.stock_minimum}</td>
													<td><a
														href="a_produit?edit=${produit.id_produit}"><button
																type="submit"
																class="btn btn-sm btn-icon btn-light waves-effect waves-light">
																<i class="mdi mdi-keyboard"></i>
															</button></a> <a
														href="a_produit?suppr=${produit.id_produit}"><button
																type="submit"
																class="btn btn-sm btn-icon btn-danger waves-effect waves-light">
																<i class="mdi mdi-close"></i>
															</button></a></td>
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