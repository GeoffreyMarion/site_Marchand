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
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${ listeUtilisateurs}" var ="element">
    <tr>
       <th scope="row"><c:out value="${element.id_utilisateur }"></c:out> </th>
      <td><c:out value="${element.prenom }"></c:out> </td>
      <td>${element.nom } </td>
      
      <td> <a href="utilisateur?id=${element.id_utilisateur }&action=edit">
      	<img alt="" src="images/edit.webp" style="width:40px;">
      </a>
      
      
<%--      <img alt="" src="images/supp.webp" width="40px;" data-bs-toggle="modal" data-bs-target="#vtc_${element.id_utilisateur }">  
 --%>    
     </td>
    </tr>
    
    <!-- Button trigger modal -->
<%-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#vtc_${element.id_conducteur }">
  Launch demo modal
</button> --%>

<!-- Modal -->
<div class="modal fade" id="vtc_${element.id_utilisateur }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Site Marchand</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      Voulez vous supprimer ${element.nom } - ${element.prenom }
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <a href="conducteur?id=${element.id_utilisateur }&action=delete">
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