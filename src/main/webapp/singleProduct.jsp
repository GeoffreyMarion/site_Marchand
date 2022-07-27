<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>Insert title here</title>
</head>
<body>
	<c:import url="/header" />

	<div class="container">
		<div class="row">
			<br /> <br /> <br />
			<div class="col-md-12 col-sm-12 offset-5">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src=${produit.image }
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${produit.titre_produit }</h5>
						<p class="card-text">${produit.description}.</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">${produit.description}</li>
						<li class="list-group-item">${produit.prix }€</li>
						<li class="list-group-item">${produit.stock}enstock</li>
					</ul>
					<div class="card-body">
						<a
							href="products?idSCat=${produit.sous_categorie.id_sous_categorie }"
							class="btn btn-outline-dark p-2 rounded">${produit.sous_categorie.getTitre()}</a>
					</div>
				</div>
			</div>
		</div>
		<br /> <br />
		<div class="row">
			<div class="col-md-12 col-sm-12 offset-5">
				<h4>Produits similaires:</h4>
			</div>
		</div>

		<div class="row">
<!-- 			<div class="col-md-12 col-sm-12">
 -->				<c:forEach items="${produitsSimilaires}" var="produitSimilaire">
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
							<%-- <a href="product?id=${produit.id_produit}" class="btn btn-dark btn-sm" role="button"
							data-bs-toggle="button" style="margin: 0.3rem;">Voir détail</a>  --%>
							<a
								href="<%request.getContextPath(); %>product?id=${produitSimilaire.id_produit}"
								class="btn btn-dark btn-sm" style="margin: 0.3rem;">Voir
								détail</a> <a href="#" class="btn btn-dark btn-sm" role="button"
								data-bs-toggle="button" style="margin: 0.3rem;">Ajouter au
								panier</a>
						</div>
					</div>
				</c:forEach>
<!-- 			</div> -->
		</div>

	</div>
</body>
</html>