<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header" />
	<div class="container">

		<div class="card mb-3 col-9" style="margin: 1rem;">
			<div class="card-header text-bg-dark">
				<b>Formulaire de contact</b>
			</div>
			<form method="post" class="mb-3" name="contact" action="#">
				<ul class="list-group list-group-flush"
					style="font-size: 1rem; font-weight: bold;">
					<li class="list-group-item bg-light col-12 d-flex flex-row">
						<div class="col-5">
							<label for="InputSujet" class="form-label">Sujet</label> <input
								type="text" class="form-control" id="InputSujet" name="sujet">
						</div>
						<div class="col-1"></div>
						<div class="col-5">
							<label for="InputEmail" class="form-label">Adresse E-mail</label>
							<c:if test="${userid!=1}">
								<input type="email" class="form-control" id="InputEmail"
									name="email" value="${mail}">
							</c:if>
							<c:if test="${userid==1}">
								<input type="email" class="form-control" id="InputEmail"
									name="email">
							</c:if>
						</div>
					</li>

					<li class="list-group-item bg-light"><label for="InputMessage"
						class="form-label">Message</label> <textarea class="form-control"
							id="InputMessage" name="message" style="height: 30vh"></textarea></li>
				</ul>
			
			</form>
			<div class="card-body bg-light" style="color: black">
				<button type="submit" class="btn btn-dark" formtarget="contact"
					name="send">Envoyer</button>
			</div>
		</div>
	</div>

</body>
</html>