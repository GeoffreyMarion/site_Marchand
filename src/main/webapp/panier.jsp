<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Panier"%>
<%@page import="model.Details_panier"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="CSS/styles.css"
	media="screen" />
</head>
<body>
	<c:import url="header" />
	<div class="container pt-5">
		<%-- 		<h3 class="text-bg-dark p-2 ml-4">Mon panier</h3>
		<%
		Panier panier2 = (Panier) session.getAttribute("panier");
		for (Details_panier article : panier2.produits) {
		%>

		<div class="ci-item">
			<div class="ci-item-info">
				<h5>
					<a href="Details?id=<%=article.getProduit().getId_produit()%>">
						<%=article.getProduit().getTitre_produit()%></a>
				</h5>
				<img src="<%=article.getProduit().getImage()%>" width="80" alt="" />
				<p><%=article.getQte()%>
					x
					<%=article.getProduit().getPrix()%>&euro;
				</p>
				<form method="POST" class="pt-3">
					Quantit&eacute; : <input type="number" min="1"
						max=${article.stock } name="pqte"
						value=<% Integer.valueOf(article.getQte());%>>
					<button class="btn btn-danger btn-sm addtobag mb-1" type="submit"
						name="padd" value=${article.id_produit
									}>X</button>
				</form>
				<p><%=article.getQte() * article.getProduit().getPrix()%>&euro;
				</p>
			</div>
		</div>
		<%
		}
		%> --%>
		<%
		if ((boolean) session.getAttribute("emptyCart") == false) {
		%>


		<section class="h-100" style="background-color: #eee;">
			<div class="container h-100 py-5">
				<h3 class="text-bg-dark p-2 ml-4">Mon panier</h3>

				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-10">
						<%
						Panier panier = (Panier) session.getAttribute("panier");
						for (Details_panier article : panier.produits) {
						%>
						<div class="card rounded-3 mb-4">
							<div class="card-body p-4">
								<div
									class="row d-flex justify-content-between align-items-center">
									<div class="col-md-2 col-lg-2 col-xl-2">
										<img src="<%=article.getProduit().getImage()%>"
											class="img-fluid rounded-3"
											alt=<%=article.getProduit().getTitre_produit()%>>
									</div>
									<div class="col-md-3 col-lg-3 col-xl-3">
										<p class="lead fw-normal mb-2"><%=article.getProduit().getTitre_produit()%></p>
									</div>
									<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
										<button class="btn btn-link px-2"
											onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
											<i class="fas fa-minus"></i>
										</button>

										<input id="form1" min="1"
											max="<%=article.getProduit().getStock()%>" name="quantity"
											value="<%=article.getQte()%>" type="number"
											class="form-control form-control-sm" />

										<button class="btn btn-link px-2"
											onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
											<i class="fas fa-plus"></i>
										</button>
									</div>
									<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
										<h5 class="mb-0"><%=article.getProduit().getPrix()%>€
										</h5>
									</div>
									<div class="col-md-1 col-lg-1 col-xl-1 text-end">
										<%-- <button class="btn btn-danger btn-sm addtobag mb-1"
											type="submit" name="padd"
											value=${article.id_produit
									}>X</button> --%>
										<a
											href="panier?idtodelete=<%=article.getProduit().getId_produit() %>"
											class="btn btn-danger btn-sm">X</a>
									</div>
								</div>
							</div>
						</div>
						<div class="card row d-flex">
							<div class="col-6 offset-4 pt-3">
								<h5>Total: ${panier.total()}&euro;</h5>
							</div>

							<div class="col-6">
								<div class="card-body">
									<button type="button"
										class="btn btn-secondary btn-block btn-lg">Paiement</button>
								</div>
							</div>
						</div>
	<%
						}
						%> 
					</div>
				</div>
			</div>
		</section>
		<%
		} else {
		%>
		<section class="h-100">
			<div class="container h-100 py-5">
				<h3 class="text-bg-dark p-2 ml-4">Votre panier est vide.</h3>
				<h3>Pour le moment...</h3>
			</div>
		</section>
		<%
		}
		%>


	</div>
	<script src="./js/handleCart2.js"></script>
</body>
</html>