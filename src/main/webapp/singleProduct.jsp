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
		<br/>		
		<br/>
			<br/>
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
						<li class="list-group-item">${produit.prix } euros</li>
						<li class="list-group-item">${produit.stock} en stock</li>
					</ul>
					<div class="card-body">
						<a href="#" class="btn btn-outline-dark p-2 rounded">${produit.sous_categorie.getTitre()}</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>