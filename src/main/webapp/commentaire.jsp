<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<div class="container pt-5">
		<h3 class="text-bg-dark p-2">Laissez un commentaire et une note
			pour l'article : ${produit.titre_produit}</h3>

		<div class="row">
			<div class="d-flex offset-8 mr-2">
				<div class="card mb-3 col-4">
					<div class="row ">
						<div class="col-6">
							<a href="product?id=${produit.id_produit }">
								<img src="${produit.image }" class="img-fluid rounded-start m-2"
								alt="${produit.titre_produit }">
							</a> <br>
						</div>
						<div class="col-6">
							<div class="card-header text-bg-dark">
								<b>${produit.titre_produit }</b>
							</div>
							<div class="card-body text-bg-light">
								<ul class="list-group list-group-flush"
									style="font-size: 1rem; font-weight: bold; text-align: right;">
									<li class="list-group-item bg-light">${produit.prix}E</li>
									<li class="list-group-item bg-light"><p>${produit.description}</p></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="card mb-3 col-12" style="margin: 1rem;">
			<form method="post" class="mb-3" name="commentaire" action="#">
				<ul class="list-group list-group-flush"
					style="font-size: 1rem; font-weight: bold;">

					<li class="list-group-item bg-light"><label for="InputMessage"
						class="form-label"></label> <textarea class="form-control"
							id="InputMessage" name="contentCommentaire" style="height: 30vh"></textarea></li>
				</ul>

				<label for="cars">Notez ce produit</label> <select name="note"
					id="note">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>

				<div class="card-body text-bg-light">
					<button type="submit" class="btn btn-dark" name="send">Envoyer</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>