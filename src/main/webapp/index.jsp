<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="CSS/styles.css"
	media="screen" />

</head>
<body>
	<%@include file="/header.jsp"%>
	<div class="container">
		<div id="carousel" class="carousel slide" data-bs-touch="false"
			data-bs-interval="false">
			<div class="carousel-inner">
				<c:forEach items="${ListSlide}" var="slide">
					<div class="carousel-item">
						<img src="${slide.image}" class="d-block w-100" alt="...">
					</div>
				</c:forEach>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carousel" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>

		<div class="d-flex flex-row">
			<c:forEach items="${ListImages}" var="produit">
				<div class="card bg-dark text-white">
					<img src="${produit.image}" class="card-img" alt="...">
					<div class="card-img-overlay">
						<h5 class="card-title">${produit.sous_categorie.titre}</h5>
					</div>
				</div>

			</c:forEach>
		</div>

	</div>
</body>
</html>