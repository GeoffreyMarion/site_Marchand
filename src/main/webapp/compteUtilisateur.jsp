<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Compte utilisateur</title>
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
	<br>
	<div class="container">
		<div class="d-flex flex-row">
		
			<div class="card mb-3 col-3">
					<div class="card-header text-bg-dark">
						<b>Vos informations</b>
					</div>

<!-- 					<div class="card-body"> -->
<!-- 						<img class="card-img-top m-2" id="products_product_img" -->
<%-- 							src="${produit.image}" alt="${produit.titre_produit}"> --%>
<!-- 					</div> -->
					<ul class="list-group list-group-flush"
						style="font-weight: bold; text-align: center;">
						<li class="list-group-item bg-light">${prenomuser}</li>
						<li class="list-group-item bg-light">${nomuser}</li>
						<li class="list-group-item bg-light">${dateuser}</li>
						<li class="list-group-item bg-light">${uemail}</li>
					</ul>
					<div class="card-body text-bg-light">
						<div class="container d-flex flex-column justify-content-around align-items-start">
							<c:forEach items="${ListAdresses}" var="adresse_livraison">
						<div class=" d-flex flex-row">
								<div class="mb-3" style="font-weight: bold">Adresse</div>
								<div class="col-12"></div>
								<button type="submit" class="btn btn-dark btn-sm">
									<a
										href="compteutilisateur?suppr=${adresse_livraison.id_adresse}"><img
										alt="supprimer" src="icones/supprimer.png" style="height: 18"></a>
								</button></div>
							<ul class="list-group list-group-flush"
						style="font-weight: bold; text-align: center;">
							<li class="list-group-item bg-light">${adresse_livraison.adresse}</li>
							<li class="list-group-item bg-light">${adresse_livraison.code_postal}
								${adresse_livraison.ville} ${adresse_livraison.pays}</li></ul>
								<br>
					</c:forEach>
						</div>
					</div>
				</div>
		
			<div class="col-1"></div>
			<form method="post" class="mb-3 col-3" name=modifier action="#">
				<div class="mb-3">
					<label for="" class="form-label"><b>Modifier mes
							informations</b></label>
					<hr>
				</div>
				<%-- 				<c:if test="${messageinscriptionok == true}"> --%>
				<!-- 					<div class="alert alert-success" role="alert">Votre -->
				<!-- 						inscription a bien été prise en compte, veuillez-vous connecter</div> -->
				<%-- 				</c:if> --%>
				<div class="mb-3">
					<label for="InputPrenom" class="form-label">Nouveau prenom</label>
					<input type="text" class="form-control" id="InputPrenom"
						name="prenom" value="${prenomuser}">
				</div>
				<div class="mb-3">
					<label for="InputNom" class="form-label">Nouveau nom</label> <input
						type="text" class="form-control" id="InputNom" name="nom"
						value="${nomuser}">
				</div>
				<div class="mb-3">
					<label for="InputEmail" class="form-label">Nouvelle adresse
						E-mail</label> <input type="email" class="form-control" id="InputEmail"
						name="email" value="${uemail}">
				</div>
				<div class="mb-3">
					<label for="InputPassword" class="form-label">Nouveau mot
						de passe</label> <input type="password" class="form-control"
						id="InputPassword" name="password">
				</div>
				<div class="mb-3">
					<label for="InputCPassword" class="form-label">Confirmer
						Nouveau mot de passe</label> <input type="password" class="form-control"
						id="InputCPassword" name="cpassword">
				</div>
				<button type="submit" class="btn btn-dark" formtarget="modifier"
					name="edit">Modifier</button>
			</form>
			<div class="col-1"></div>
			<form method="post" class="mb-3 col-3" name="adresse" action="#">
				<div class="mb-3">
					<label for="" class="form-label"><b>Ajouter Adresse</b></label>
					<hr>
				</div>
				<div class="mb-3">
					<label for="InputPrenom" class="form-label">Adresse</label> <input
						type="text" class="form-control" id="InputPrenom" name="adresse">
				</div>
				<div class="mb-3">
					<label for="InputNom" class="form-label">Code postal</label> <input
						type="text" class="form-control" id="InputNom" name="codepostal">
				</div>
				<div class="mb-3">
					<label for="InputEmail" class="form-label">Ville</label> <input
						type="text" class="form-control" id="InputEmail" name="ville">
				</div>
				<div class="mb-3">
					<label for="InputPassword" class="form-label">Pays</label> <input
						type="text" class="form-control" id="InputPassword" name="pays">
				</div>
				<button type="submit" class="btn btn-dark" formtarget="adresse"
					name="add">Envoyer</button>
			</form>

		</div>
	</div>

</body>
</html>