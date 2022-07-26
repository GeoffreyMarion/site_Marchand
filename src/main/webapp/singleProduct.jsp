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
			<div class="col-md-12 col-sm-12">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src=${produit.image }
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${produit.titre_produit }</h5>
						<p class="card-text">.</p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">${produit.description}</li>
						<li class="list-group-item">${produit.prix }</li>
						<li class="list-group-item">${produit.titre_produit }en stock</li>
					</ul>
					<div class="card-body">
						<a href="#" class="card-link">${produit.sous_categorie.titre}</a>
						<a href="#" class="card-link">Another link</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>