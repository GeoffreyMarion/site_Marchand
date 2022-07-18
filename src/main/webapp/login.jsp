<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/header.jsp"%>
<div class="container">
<div class="d-flex flex-row">
<form class="mb-3 col-5">
	<div class="mb-3">
	<label for="" class="form-label"><b>S'enregistrer</b></label>
	<hr>
	</div>
	<div class="mb-3">
    <label for="InputNom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="InputNom">
  </div>
  <div class="mb-3">
    <label for="InputPrenom" class="form-label">Prenom</label>
    <input type="text" class="form-control" id="InputPrenom">
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Adresse E-mail</label>
    <input type="email" class="form-control" id="exampleInputEmail1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-dark">S'enregister</button>
</form>

<div class="col-1"></div>

<form class="mb-3 col-5">
<div class="mb-3">
	<label for="" class="form-label"><b>Se Conneter</b></label>
	<hr>
	</div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Adresse E-mail</label>
    <input type="email" class="form-control" id="exampleInputEmail1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-dark">Se connecter</button>
</form>
</div>
</div>

</body>
</html>