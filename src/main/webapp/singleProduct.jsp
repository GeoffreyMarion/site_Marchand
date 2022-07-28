<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Produit"%>
<%@page import="model.Commentaire"%>
<%@page import="java.util.ArrayList"%>
<%
Produit produit = (Produit) request.getAttribute("produit");
%>
<%
ArrayList<Commentaire> commentaires = (ArrayList<Commentaire>) request.getAttribute("commentairesFromProduit");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fiche produit</title>
</head>
<body>
	<c:import url="header" />

	<%-- <div class="container">
		<br />

		<div class="card mb-3 col-7">
			<div class="row ">
				<div class="col-12">
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
					</div>

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
						<a href="product?id=${produit.id_produit}"
							class="btn btn-dark btn-sm" role="button" data-bs-toggle="button"
							style="margin: 0.3rem;">Voir détail</a> <a
							href="<%request.getContextPath(); %>product?id=${produitSimilaire.id_produit}"
							class="btn btn-dark btn-sm" style="margin: 0.3rem;">Voir
							détail</a> <a href="#" class="btn btn-dark btn-sm" role="button"
							data-bs-toggle="button" style="margin: 0.3rem;">Ajouter au
							panier</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div> --%>

	<div class="container">
		<div class="row pt-4">
			<div class="card col-6">
				<img src="${produit.image }" class="img-fluid rounded-start m-2"
					alt="${produit.titre_produit }"> <br>
				<div class="d-flex flex-wrap">
					<img src="${produit.image }" class="col-3 m-2"
						alt="${produit.titre_produit }"><img src="${produit.image }"
						class="col-3 m-2" alt="${produit.titre_produit }"><img
						src="${produit.image }" class="col-3 m-2"
						alt="${produit.titre_produit }">
				</div>
			</div>
			<div class="col-6 p-2">
				<div class="card-header text-bg-dark p-2">
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
			</div>
			<%
			if (commentaires.size() >0) {
			%>
			<div class="row pt-4">
				<div class="text-bg-dark p-2">
					<h4>Ce qu'en disent nos clients:</h4>
				</div>
				<div class="pt-5">
					<c:forEach items="${ commentairesFromProduit}" var="commentaire">
						<div class="card mb-3">
							<div class="card-header">Date: ${commentaire.note }</div>
							<div class="card-body">
								<blockquote class="blockquote mb-0">
									<p>${commentaire.commentaire }</p>
									<footer class="blockquote-footer">
										De: <cite title="Source Title">${commentaire.utilisateur.getPrenom() }.</cite>
										Note: <cite title="Source Title">${commentaire.note }/5.</cite>
									</footer>
								</blockquote>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<%}%>

			<br />
			<div class="row pt-4">
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
							<a href="product?id=${produit.id_produit}"
								class="btn btn-dark btn-sm" role="button"
								data-bs-toggle="button" style="margin: 0.3rem;">Voir détail</a>
							<a
								href="<%request.getContextPath(); %>product?id=${produitSimilaire.id_produit}"
								class="btn btn-dark btn-sm" style="margin: 0.3rem;">Voir
								détail</a> <a href="#" class="btn btn-dark btn-sm" role="button"
								data-bs-toggle="button" style="margin: 0.3rem;">Ajouter au
								panier</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>