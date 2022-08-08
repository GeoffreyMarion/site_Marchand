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
<%@page import="model.Panier"%>
<%@page import="model.Details_panier"%>

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
<body class="has-drawer">
	<c:import url="header" />
	<div class="container">
		<%-- 		<%
		if (session.getAttribute("panier") != null) {
		%>
		<p>Panier non vide</p>
<% for(int i=0; i<session.getAttribute("panier").size(); i++) { %>	
			<p>${} </p>
	
<% } %>		

 <c:forEach var="element" items="session.getAttribute("panier")">
 <p>${element.id_produit}</p>
 </c:forEach>
		<%
		}
		%> --%>

		<%
		Panier panier = (Panier) session.getAttribute("panier");
		for (Details_panier article : panier.produits) {
		%>

		<div class="ci-item">
			<img src="<%=article.getProduit().getImage()%>" width="80" alt="" />
			<div class="ci-item-info">
				<h5>
					<a href="Details?id=<%=article.getProduit().getId_produit()%>"> <%=article.getProduit().getTitre_produit()%></a>
				</h5>
				<p><%=article.getQte()%>
					x
					<%=article.getProduit().getPrix()%>&euro;
				</p>

			</div>
		</div>
		<%
		}
		%>
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
							<a href="product?fav=${produit.id_produit}"><img alt="favori"
								src="icones/favori.png" style="height: 18"></a>
						</button>
					</c:if>

					<%-- 			<button type="submit" class="btn btn-dark btn-sm"
						style="margin: 0.2rem;">
						<a href="product?pan=${produit.id_produit}"><img alt="favori"
							src="icones/favori.png" style="height: 18"></a>
					</button> --%>
					<form method="POST">
						Quantit&eacute; : <input type="number" min="1"
							max=${produit.stock
							} name="pqte" value="1">
						<button class="btn btn-dark btn-sm addtobag" type="submit"
							name="padd">Ajouter au panier</button>
					</form>
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
						<a href="product?id=${produitSimilaire.id_produit}"
							class="btn btn-dark btn-sm" style="margin: 0.2rem;">Voir
							détail</a>

						<c:if test="${isConnected==true}">
							<button type="submit" class="btn btn-dark btn-sm"
								style="margin: 0.2rem;">
								<a href="product?fav=${produitSimilaire.id_produit}"><img
									alt="favori" src="icones/favori.png" style="height: 18"></a>
							</button>
						</c:if>

						<%-- <button type="submit" class="btn btn-dark btn-sm"
							style="margin: 0.2rem;">
							<a href="product?pan=${produitSimilaire.id_produit}"><img
								alt="favori" src="icones/favori.png" style="height: 18"></a>
						</button> --%>
						<div class="col-sm-12">
							<form method="POST" class="pt-3">
								Quantit&eacute; : <input type="number" min="1"
									max=${produitSimilaire.stock } name="pqte" value="1">
								<button class="btn btn-dark btn-sm addtobag mt-1" type="submit"
									name="padd">Ajouter au panier</button>
							</form>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<!-- MODAL CLICK ON BTN Voir mon panier -->
		<!-- SIDE DRAWER -->
		<div id="side-drawer" class="position-fixed">
			<div class="h-100 bg-white">
				<div class="p-4 bg-light">
					<h2>Mon panier</h2>
					<div class="container_total-and-btn-valider">
						<!-- <a href="#"> -->
						<h5 class="text-total">Total: €</h5>
					</div>
				</div>
				<!-- CART DETAILS -->
				<div class="container container_details-cart">
					<h6>Désignation:</h6>
					<button class="btn btn-outline-danger right-side-drawer_title"
						onclick="">
						Supprimer
						<!-- <h3 class="right-side-drawer_title">Mon panier</h3> -->
					</button>
				</div>
				<!-- END OF CART DETAILS -->
				<!-- <ul class="list-group" onclick="closeSideDrawer()">
          <a
            href="#"
            class="list-group-item list-group-item-action border-0 rounded-0 active"
            >Link</a
          >
          <a
            href="#"
            class="list-group-item list-group-item-action border-0 rounded-0"
            >Link</a
          >
        </ul> -->
			</div>
		</div>
		<div id="side-drawer-void" class="position-fixed d-none"
			onclick="closeSideDrawer()"></div>
		<!-- END OF SIDE DRAWER -->
		<!-- END OF MODAL CLICK ON BTN Voir mon panier -->
	</div>
</body>
</html>