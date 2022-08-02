<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Produit"%>
<%@page import="java.util.ArrayList"%>
<%
Produit produit = (Produit) request.getAttribute("produit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fiche produit</title>
</head>
<body>
	<c:import url="header" />
<c:import url="header" /> --%>

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

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="CSS/styles.css"
	media="screen" />
</head>
<body>
	<c:import url="header" />
	<div class="container">
		<br />

		<div class="card mb-3 col-7">
			<div class="row ">
				<div class="col-6">
					<img src="${produit.image }" class="img-fluid rounded-start m-2"
						alt="${produit.titre_produit }"> <br>
					<div class="d-flex flex-wrap">
						<img src="${produit.image }" class="col-3 m-2"
							alt="${produit.titre_produit }"><img
							src="${produit.image }" class="col-3 m-2"
							alt="${produit.titre_produit }"><img
							src="${produit.image }" class="col-3 m-2"
							alt="${produit.titre_produit }">
					</div>
				</div>
				<div class="col-6">
					<div class="card-header text-bg-dark">
						<b>${produit.titre_produit }</b>
					</div>
					<div class="card-body text-bg-light">
						<ul class="list-group list-group-flush"
							style="font-size: 1rem; font-weight: bold; text-align: right;">
							<li class="list-group-item bg-light">${produit.sous_categorie.titre}</li>
							<li class="list-group-item bg-light">${produit.prix}E</li>
							<li class="list-group-item bg-light">(${produit.stock}) en
								stock</li>
							<li class="list-group-item bg-light"><p>${produit.description}</p></li>
						</ul>
					</div>

						<c:if test="${isConnected==true}">
							<button type="submit" class="btn btn-dark btn-sm"
								style="margin: 0.2rem;">
								<a href="product?fav=${produit.id_produit}"><img
									alt="favori" src="icones/favori.png" style="height: 18"></a>
							</button>
						</c:if>

						<button type="submit" class="btn btn-dark btn-sm"
							style="margin: 0.2rem;">
							<a href="product?pan=${produit.id_produit}"><img
								alt="favori" src="icones/icon_basket3.png" style="height: 18"></a>
						</button>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="text-bg-dark p-2">
				<h4>Produits similaires</h4>
			</div>
		</div>

		<div class="d-flex flex-wrap">
			<c:forEach items="${produitsSimilaires}" var="produitSimilaire">
				<div class="card mb-3" style="width: 14rem; margin: 1rem;">
					<div class="card-header text-bg-dark">
						<b>${produitSimilaire.titre_produit}</b>
					</div>

					<div class="card-body">
						<img class="card-img-top" src="${produitSimilaire.image}"
							alt="${produitSimilaire.titre_produit}">
					</div>
					<ul class="list-group list-group-flush"
						style="font-size: 0.7rem; font-weight: bold; text-align: right;">
						<li class="list-group-item">${produitSimilaire.sous_categorie.titre}</li>
						<li class="list-group-item">${produitSimilaire.prix}E</li>
						<li class="list-group-item">(${produitSimilaire.stock}) en
							stock</li>
					</ul>
					<div class="card-body" style="color: black">
						<a
							href="product?id=${produitSimilaire.id_produit}"
							class="btn btn-dark btn-sm" style="margin: 0.2rem;">Voir
							détail</a>

						<c:if test="${isConnected==true}">
							<button type="submit" class="btn btn-dark btn-sm"
								style="margin: 0.2rem;">
								<a href="product?fav=${produitSimilaire.id_produit}"><img
									alt="favori" src="icones/favori.png" style="height: 18"></a>
							</button>
						</c:if>

						<button type="submit" class="btn btn-dark btn-sm"
							style="margin: 0.2rem;">
							<a href="product?pan=${produitSimilaire.id_produit}"><img
								alt="favori" src="icones/icon_basket3.png" style="height: 18"></a>
						</button>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>
</body>
</html>