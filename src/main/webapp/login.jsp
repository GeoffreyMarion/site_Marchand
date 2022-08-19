<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<div class="d-flex flex-row">
			<form method="post" class="mb-3 col-5" name="sign" action="#">
				<div class="mb-3">
					<label for="" class="form-label"><b>S'enregistrer</b></label>
					<hr>
				</div>
				<c:if test="${messageinscriptionok == true}">
					<div class="alert alert-success" role="alert">Votre
						inscription a bien été prise en compte, veuillez-vous connecter</div>
				</c:if>
				<div class="mb-3">
					<label for="InputNom" class="form-label">Nom</label> <input
						type="text" class="form-control" id="InputNom" name="nom">
				</div>
				<div class="mb-3">
					<label for="InputPrenom" class="form-label">Prenom</label> <input
						type="text" class="form-control" id="InputPrenom" name="prenom">
				</div>
				<div class="mb-3">
					<label for="InputEmail" class="form-label">Adresse E-mail</label> <input
						type="email" class="form-control" id="InputEmail" name="email">
				</div>
				<div class="mb-3">
					<label for="InputPassword" class="form-label">Mot de passe</label>
					<input type="password" class="form-control" id="InputPassword"
						name="password">
				</div>
				<div class="mb-3">
					<label for="InputCPassword" class="form-label">Confirmer
						mot de passe</label> <input type="password" class="form-control"
						id="InputCPassword" name="cpassword">
				</div>
				<button type="submit" class="btn btn-dark" formtarget="sign"
					name="register">S'enregister</button>
			</form>

			<div class="col-1"></div>

			<form method="post" class="mb-3 col-5" name="login" action="#">
				<div class="mb-3">
					<label for="" class="form-label"><b>Se Connecter</b></label>
					<hr>
				</div>
				<c:if test="${messageconnexionno == true}">
					<div class="alert alert-danger" role="alert">Adresse e-mail
						ou mot de passe invalide</div>
				</c:if>
				<div class="mb-3">
					<label for="InputEmail_l" class="form-label">Adresse E-mail</label>
					<input type="email" class="form-control" id="InputEmail_l"
						name="email_l">
				</div>
				<div class="mb-3">
					<label for="InputPassword_l" class="form-label">Mot de
						passe</label> <input type="password" class="form-control"
						id="InputPassword_l" name="password_l">
				</div>
				<div class="mb-3">
					<label for="InputCPassword_l" class="form-label">Confirmer
						mot de passe</label> <input type="password" class="form-control"
						id="InputCPassword_l" name="cpassword_l">
				</div>
				<button type="submit" class="btn btn-dark" formtarget="login"
					name="connect">Se connecter</button>
			</form>
		</div>
	</div>

</body>
</html>