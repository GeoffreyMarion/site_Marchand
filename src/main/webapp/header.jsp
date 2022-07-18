<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<!-- CSS -->
<!-- <link href="./CSS/styles.css" rel="stylesheet" type="text/css">
 -->
<%-- <style>
<%@
include

 

file


="./
CSS
/


styles


.css


"%
>
</style> --%>

</head>
<body>
	<div class="container text-center">
		<br> <br>
		<ul class="nav">
			<li class="nav-item icons test"><a class="nav-link active"
				aria-current="page" href="<c:url value = "/"/>"><img alt=""
					src="images/icon_panier.jpeg" style="width: 40px; height: 20px">
			</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="<c:url value = "/produits"/>">Nos
					produits</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="<c:url value = "/categories"/>">Categories</a>
			</li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="<c:url value = "/panier"/>">Panier</a></li>
		</ul>

		<p class="test">TEST</p>
		<img alt="" src="images/icon_panier.jpeg"
			;" style="width: 40px; height: 20px">

<img src="images/icon_home.png" height="50" width="50">

<img src="${pageContext.request.contextPath}/images/icon_home.png" height="100%" width="100%"/> 
<img src="image1.jpeg">



	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>