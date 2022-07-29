<header class="p-3 bg-dark text-white sticky-top">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			
			<a href="index"
				class="d-flex align-items-center justify-content-center col-1">
				<img alt="" src="images/logo.png" height="40px">
			</a>

			<ul class="d-flex nav align-items-center col-3 me-lg-auto">
			<li><a href="contact" class="nav-link px-2 text-white"
				id="header_contact"><b>Nous Contacter</b></a></li>
			<li><a href="/site_Marchand/products"
				class="nav-link px-2 text-white" id="header_produits"><b>Nos
						Produits</b></a></li>
		</ul>

		<div class="d-flex align-items-center">
		<p class=""><b>Nos Categories:</b></p>

			<ul class="list-unstyled ps-0 d-flex justify-content-center">
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
			</div>

			<div class="d-flex" id="header_form_search">
				<form class="col-9 col-lg-auto" role="search" method="post" action="products" id="recherche">
					<input type="search"
						class="form-control form-control-dark text-black"
						placeholder="Rechercher..." aria-label="Search" name="mot">
				</form>
				<button class="btn btn-sm" type="submit" form="recherche">
						<img src="icones/icon_loop.png" width="25" alt="Loop" />
					</button>
			</div>
			
			<div class="d-flex align-items-center">
			<a href="index"
						id="header_icon_basket"> <img alt=""
						src="icones/icon_basket3.png" height="40px">
					</a>
					<a href="favori"
						id="header_icon_basket"> <img alt=""
						src="icones/favori.png" height="40px">
					</a>
			</div>
			
			<div class="text-end">
				<div class="d-flex align-items-center">
					<div class="tb_right_pull-right">
						<ul class="header_list_user">
							<%
							if ((boolean) session.getAttribute("isConnected") == false) {
							%>
							<li>
								<div class="tbr-info">
									<a href="login" style="font-size: 0.7rem"><span><b>Inscription / connexion</b></span></a>
								</div>
							</li>
							<%
							} else {
							%>
							<li>
								<div class="tbr-info align-items-center">
									<a href="#" style="font-size: 0.7rem"><span><b>Bonjour ${prenomuser} ${nomuser}</b></span></a>
								</div>
							</li>
							<li>
							<div class="tbr-info align-items-center">
									<a href="#" style="font-size: 0.7rem"><span><b>Mon compte</b></span></a>
								</div>
								</li>
							<li>
								<div class="tbr-info align-items-center">
									<a href="deconnexion" style="font-size: 0.7rem"><span><b>D&eacute;connexion </b></span></a>
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
</header>