<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" type="text/css" href="/CSS/styles.css"
	media="screen" /> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/styles.css" />

</head>
<body>
	<%@include file="/header.jsp"%>

	<%--   <jsp:include page="header" /> --%>

	<div class="container" id="index_main_container">

		<div id="carouselExampleFade" class="carousel slide carousel-fade"
			data-bs-ride="carousel" style="height: 200px;">
			<div class="carousel-inner">
				<c:forEach items="${ListSlide}" var="slide" varStatus="status">
					<c:if test="${status.first}">
						<div class="carousel-item active" style="height: 200px;">
							<img src="${slide.image}" class="d-block w-100" alt="...">
							<div class="carousel-caption d-none d-md-block">
								<h5>${slide.titre_slide}</h5>
							</div>
						</div>
					</c:if>
					<c:if test="${!status.first}">
						<div class="carousel-item" style="height: 200px;">
							<img src="${slide.image}" class="d-block w-100" alt="...">
							<div class="carousel-caption d-none d-md-block">
								<h5>${slide.titre_slide}</h5>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleFade" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleFade" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
		<br>

		<div class="d-flex flex-wrap">
			<c:forEach items="${ListImages}" var="produit">
				<div class="card mb-3" style="max-width: 14rem; margin: 1rem;">
					<div class="card-header">
						<b>${produit.sous_categorie.titre}</b>
					</div>
					<div class="card-body">
						<img src="${produit.image}" class="card-img" alt="...">
					</div>
				</div>
			</c:forEach>
		</div>
		<%@include file="/footer.jsp"%>
		<%-- <jsp:include page="footer" /> --%>

	</div>

</body>
</html>