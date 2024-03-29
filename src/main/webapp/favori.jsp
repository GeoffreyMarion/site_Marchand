<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favori</title>
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
	<br>
	<div class="text-bg-dark p-2 d-flex">
				<img alt=""src="icones/favori.png" height="35px" class="me-2"><h4>Mes produits favoris</h4>
			</div>
	<div class="d-flex flex-wrap">
			<c:forEach items="${ListFavori}" var="favori">
				<div class="card mb-3" style="width: 14rem; margin: 1rem;">
					<div class="card-header text-bg-dark">
						<b>${favori.produit.titre_produit}</b>
					</div>

					<div class="card-body">
						<img class="card-img-top m-2" src="${favori.produit.image}"
							alt="${favori.produit.titre_produit}">
					</div>
					<ul class="list-group list-group-flush"
						style="font-size: 0.7rem; font-weight: bold; text-align: right;">
						<li class="list-group-item bg-light">${favori.produit.sous_categorie.titre}</li>
						<li class="list-group-item bg-light">${favori.produit.prix}E</li>
						<li class="list-group-item bg-light">(${favori.produit.stock}) en stock</li>
					</ul>
					<div class="card-body bg-light" style="color: black">
						<a
							href="product?id=${favori.produit.id_produit}"
							class="btn btn-dark btn-sm"
							style="margin: 0.2rem;">Voir détail</a> 
							
							<button type="submit" class="btn btn-dark btn-sm"
							style="margin: 0.2rem;">
							<a href="favori?del=${favori.id_favori}"><img
								alt="delete" src="icones/favorisup.png" style="height: 18"></a>
						</button>
							
							<button type="submit" class="btn btn-dark btn-sm"
							style="margin: 0.2rem;">
							<a href="favori?pan=${favori.produit.id_produit}"><img
								alt="favori" src="icones/icon_basket3.png" style="height: 18"></a>
						</button>
					</div>
				</div>
			</c:forEach>
		</div>
		
	</div>
</body>
</html>