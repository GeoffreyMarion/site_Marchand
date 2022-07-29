<header class="p-3 bg-dark text-white sticky-top">
<!-- 	<div class="container"> -->
		<div
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="${index}"
				class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
				<img alt="" src="images/logo.png" height="40px">
				<a href="index"
				class="pt-2" id="header_titre_site"><b>FNUC</b></a>
			</a>
			<div class="col-1"></div>

			<ul
				class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
			<li><a href="contact" class="nav-link px-2 text-white"
				id="header_contact"><b>Nous contacter</b></a></li>
			<li><a href="/site_Marchand/products"
				class="nav-link px-2 text-white" id="header_produits"><b>Nos
						Produits</b></a></li>
		</ul>

			<p class="pt-4"><b>Nos Categories:</b></p>

			<ul class="list-unstyled ps-0 d-flex justify-content-center pt-4 ">
				<c:forEach items="${ listeCategories}" var="categorie">
					<div class="dropdown">
						<button
							class="btn btn-dark dropdown-toggle btn_dropdown_category"
							type="button" data-bs-toggle="dropdown" aria-expanded="false"><b>${categorie.titre }</b></button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<c:forEach items="${ listeSousCateg}" var="sousCategorie">
								<c:if
									test="${sousCategorie.categorie.id_categorie == categorie.id_categorie}">
									<li><a class="dropdown-item" href="products?idSCat=${sousCategorie.id_sous_categorie }">${sousCategorie.titre }</a></li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</c:forEach>
			</ul>

			<div class="d-flex pt-4" id="header_form_search">
				<form class="col-9 col-lg-auto" role="search" method="post" action="products" id="recherche">
					<input type="search"
						class="form-control form-control-dark text-black pt-2"
						placeholder="Rechercher..." aria-label="Search" name="mot">
				</form>
				<button class="btn btn-sm" type="submit" form="recherche">
						<img src="icones/icon_loop.png" width="25" alt="Loop" />
					</button>
			</div>

			<div class="text-end">
				<div
					class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start pt-2">
					<a href="${index}"
						class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"
						id="header_icon_basket"> <img alt=""
						src="icones/icon_basket3.png" height="40px">
					</a>
					<a href="favori"
						class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"
						id="header_icon_basket"> <img alt=""
						src="icones/favori.png" height="40px">
					</a>

					<div class="tb_right_pull-right">
						<ul class="header_list_user">
							<%
							if ((boolean) session.getAttribute("isConnected") == false) {
							%>
							<li>
								<div class="tbr-info">
									<a href="login"><span><b>Inscription / connexion</b></span></a>
								</div>
							</li>
							<%
							} else {
							%>
							<li>
								<div class="tbr-info">
									<a href="#"><span><b>Bonjour ${prenomuser} ${nomuser}</b></span></a>
								</div>
							</li>
							<li><a href="${index}"
								class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
									<img alt="" src="icones/icon_person.png" height="40px"> <!-- 									<div class="tbr-info"> -->
									<!-- 										<a href="#"><span>Mon compte</span></a> --> <!-- 									</div> --></li>
							<li>
								<div class="tbr-info">
									<a href="deconnexion"><span><b>D&eacute;connexion </b></span></a>
								</div>
							</li>
							<%
							}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
<!-- 	</div> -->
</header>