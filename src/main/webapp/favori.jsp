<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="header" />
	<div class="container">
	<br>
	<div class="text-bg-dark p-2">
				<h4>Vos favoris</h4>
			</div>
	<div class="d-flex flex-wrap">
			<c:forEach items="${ListFavori}" var="Favori">
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
							href="<%request.getContextPath(); %>product?id=${favori.produit.id_produit}"
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