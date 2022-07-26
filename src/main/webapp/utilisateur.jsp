<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="CSS/styles.css"
	media="screen" />

</head>
<body>
	<c:import url="/header" />
	<c:if test="${empty listeUtilisateurs }">
	Pas d'utilisateur disponible
</c:if>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Prénom</th>
				<th scope="col">Nom</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ listeUtilisateurs}" var="utilisateur">
				<tr>
					<th scope="row"><c:out value="${utilisateur.id_utilisateur }"></c:out>
					</th>
					<td><c:out value="${utilisateur.prenom }"></c:out></td>
					<td><c:out value="${utilisateur.nom }"></c:out></td>
				</tr>

				<!-- Modal -->
				<div class="modal fade" id="vtc_${utilisateur.id_utilisateur }"
					tabindex="-1" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Site
									Marchand</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">Voulez vous supprimer
								${utilisateur.nom } - ${utilisateur.prenom }</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<a
									href="utilisateur?id=${utilisateur.id_utilisateur }&action=delete">
									<button type="button" class="btn btn-primary">Save
										changes</button>
								</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
	</table>
</body>
</html>