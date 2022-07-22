<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

</head> --%>
<body>
	<!-- Footer -->
	<footer class="footer">
		<!-- Section: Links  -->
		<hr />
		<section class="">
			<div class="container text-center text-md-start mt-5">
				<!-- Grid row -->
				<div class="row mt-3">
					<!-- Grid column -->
					<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
						<!-- Content -->
						<h6 class="text-uppercase fw-bold mb-4">
							<i class="fas fa-gem me-3"></i>FNUC
						</h6>
						<p>
							Des livres, de la musique et de l'IT. <br>Ouais, on est
							originaux.
						</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">Catégories</h6>
						<p>
							<a href="#!" class="text-reset">Informatique</a>
						</p>
						<p>
							<a href="#!" class="text-reset">Livres</a>
						</p>
						<p>
							<a href="#!" class="text-reset">Musique</a>
						</p>
					</div>
					<!-- Grid column -->

					<!-- Grid column -->
					<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
						<!-- Links -->
						<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
						<p>
							<i class="fas fa-home me-3"></i>
						<%= request.getAttribute("coordonneesNom") %>
						
						</p>
						<p>
							<i class="fas fa-envelope me-3"></i>
													<%= request.getAttribute("coordonneesEmail") %>
						</p>
						<p>
							<i class="fas fa-phone me-3"></i>		<%= request.getAttribute("coordonneesTelephone") %>
						</p>
					</div>
					<!-- Grid column -->
				</div>
				<!-- Grid row -->
			</div>
		</section>
		<!-- Section: Links  -->

		<!-- Copyright -->
		<div class="text-center p-4"
			style="background-color: rgba(0, 0, 0, 0.05);">
			© 2022 Copyright: <a class="text-reset fw-bold"
				href="https://mdbootstrap.com/"><%= request.getAttribute("coordonneesNom") %></a>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</body>
<!-- 
</html> -->