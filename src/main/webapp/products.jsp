<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>produits</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="CSS/styles.css"
	media="screen" />
</head>
<body>
	<c:import url="header" />
	<div class="container">


		<div id="carouselExampleFade" class="carousel slide carousel-fade"
			data-bs-ride="carousel" style="height: 200px;">
			<!-- 			<div class="carousel-indicators"> -->
			<%-- 				<c:forEach items="${ListSlide}" var="slide" varStatus="status"> --%>
			<%-- 					<c:if test="${status.first}"> --%>
			<!-- 						<button type="button" data-bs-target="#carouselExampleCaptions" -->
			<%-- 							data-bs-slide-to="${slide.id_slide}" class="active" aria-current="true" --%>
			<%-- 							aria-label="Slide ${slide.id_slide}"></button> --%>
			<%-- 					</c:if> --%>
			<%-- 					<c:if test="${!status.first}"> --%>
			<!-- 						<button type="button" data-bs-target="#carouselExampleCaptions" -->
			<%-- 							data-bs-slide-to="${slide.id_slide}" aria-label="Slide ${slide.id_slide}"></button> --%>
			<%-- 					</c:if> --%>
			<%-- 				</c:forEach> --%>
			<!-- 			</div> -->
			<div class="carousel-inner">
				<c:forEach items="${ListSlide}" var="slide" varStatus="status">
					<c:if test="${status.first}">
						<div class="carousel-item active" style="height: 200px;">
							<img src="${slide.image}" class="d-block w-100"
								alt="${slide.titre_slide}">
							<div class="carousel-caption d-none d-md-block">
								<h5>${slide.titre_slide}</h5>
							</div>
						</div>
					</c:if>
					<c:if test="${!status.first}">
						<div class="carousel-item" style="height: 200px;">
							<img src="${slide.image}" class="d-block w-100"
								alt="${slide.titre_slide}">
							<div class="carousel-caption d-none d-md-block">
								<h5>${slide.titre_slide}</h5>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleFade" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleFade" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<br>
		<c:if test="${id!=null}">
			<div class="text-bg-dark p-2">
				<h4>Nos produits dans la sous-catégorie ${Sous_cat.titre}</h4>
			</div>
		</c:if>
		<c:if test="${idc!=null}">
			<div class="text-bg-dark p-2">
				<h4>Nos produits dans la catégorie ${Sous_cat.categorie.titre}</h4>
			</div>
		</c:if>

		<c:if test="${id==null}">
			<c:if test="${idc==null}">
			<div class="text-bg-dark p-2"><h4>Nos produits</h4> </div>
				<c:if test="${ListProduit.size()==0}">
					<br>
					<div class="alert alert-danger" role="alert">Il n'y a aucun produits qui correspond à votre recherche ${mot}</div>
				</c:if>
			</c:if>
		</c:if>

		<div class="d-flex flex-wrap">
			<c:forEach items="${ListProduit}" var="produit">
				<div class="card mb-3" style="width: 14rem; margin: 1rem;">
					<div class="card-header text-bg-dark">
						<b>${produit.titre_produit}</b>
					</div>

					<div class="card-body">
						<img class="card-img-top m-2" src="${produit.image}"
							alt="${produit.titre_produit}">
					</div>
					<ul class="list-group list-group-flush"
						style="font-size: 0.7rem; font-weight: bold; text-align: right;">
						<li class="list-group-item bg-light">${produit.sous_categorie.titre}</li>
						<li class="list-group-item bg-light">${produit.prix}E</li>
						<li class="list-group-item bg-light">(${produit.stock}) en stock</li>
					</ul>
					<div class="card-body bg-light" style="color: black">
						<%-- <a href="product?id=${produit.id_produit}" class="btn btn-dark btn-sm" role="button"
							data-bs-toggle="button" style="margin: 0.3rem;">Voir détail</a>  --%>
						<a
							href="<%request.getContextPath(); %>product?id=${produit.id_produit}"
							class="btn btn-dark btn-sm"
							style="margin: 0.3rem;">Voir détail</a> <a href="#"
							class="btn btn-dark btn-sm" role="button" data-bs-toggle="button"
							style="margin: 0.3rem;">Ajouter au panier</a>
					</div>
				</div>
			</c:forEach>
		
		</div>

	</div>

</body>
</html>