<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
<c:forEach items="${ listeUtilisateurs}" var ="utilisateur">
    <tr>
       <th scope="row"><c:out value="${utilisateur.id_utilisateur }"></c:out> </th>
      <td><c:out value="${utilisateur.prenom }"></c:out> </td>
      <td><c:out value="${utilisateur.nom }"></c:out> </td>
    </tr> 

<!-- Modal -->
<div class="modal fade" id="vtc_${utilisateur.id_utilisateur }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Site Marchand</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      Voulez vous supprimer ${utilisateur.nom } - ${utilisateur.prenom }
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <a href="utilisateur?id=${utilisateur.id_utilisateur }&action=delete">
        <button type="button" class="btn btn-primary">
        Save changes</button>
        </a>
      </div>
    </div>
  </div>
</div>
</c:forEach>
</table>
</body>
</html>