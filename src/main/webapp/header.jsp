<!DOCTYPE html>
<html>
<c:url value="utilisateur" var="utilisateur"></c:url>
<c:url value="about" var="about"></c:url>
<c:url value="contact" var="contact"></c:url>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="CSS/styles.css"
	media="screen" />

</head>
<c:url value="utilisateur" var="utilisateur"></c:url>
<c:url value="about" var="about"></c:url>
<c:url value="contact" var="contact"></c:url>
<body>
	<header class="p-3 bg-secondary text-white">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="${index}"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					<img alt="" src="image/logo.png" height="40px">
				</a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="#" class="nav-link px-2 text-white"></a></li>
					<li><a href="#" class="nav-link px-2 text-white"></a></li>
					<li><a href="#" class="nav-link px-2 text-white"></a></li>
					<li><a href="#" class="nav-link px-2 text-white" id="test2">Nos
							produits</a></li>
				</ul>

				<ul class="list-unstyled ps-0 d-flex">
					<c:forEach items="${ listeCategories}" var="categorie">
						<%
						System.out.println("listeCategories.get(0)" + "${ listeCategories}");
						%>
						<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button"
								id="dropdownMenuButton1" data-bs-toggle="dropdown"
								aria-expanded="false">${categorie.titre }</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul>
						</div>
					</c:forEach>
				</ul>


				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
					<input type="search"
						class="form-control form-control-dark text-white"
						placeholder="Rechercher..." aria-label="Search">
				</form>

				<div class="text-end">
					<!-- <button type="button" class="btn btn-outline-light me-2">Login</button> -->
					<!-- 					<button type="button" class="btn btn-warning">Sign-up</button>
 -->
					<div
						class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
						<a href="${index}"
							class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"
							id="icon_basket"> <img alt="" src="icones/icon_basket2.png"
							height="40px">
						</a> <a href="${index}"
							class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
							<img alt="" src="icones/icon_person.png" height="40px">
					</div>
				</div>
			</div>
		</div>
	</header>
	<br>
</body>
</html>