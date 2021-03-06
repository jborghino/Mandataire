<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
	String uname = (String) session.getAttribute("UserName");
	String upass = (String) session.getAttribute("UserPassword");
	pageContext.setAttribute("uname", uname);
	pageContext.setAttribute("upass", upass);
%>

<html>
<head>
<link rel="stylesheet"
	href=<c:url value="/template/css/bootstrap.min.css"/>>
<link rel="stylesheet"
	href=<c:url value="/template/css/font-awesome.min.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/mycss.css"/>>
<!-- Bootstrap -->
<script src=<c:url value="/template/js/jquery.min.js"/>></script>
<!-- slider -->
<script src=<c:url value="/template/js/bootstrap.min.js"/>></script>
<script src=<c:url value="/template/js/jquery.isotope.min.js"/>></script>

</head>

<body>


	<div class="container">
		<div class="jumbotron">
			<h2>Mandataire Auto</h2>
		</div>
	</div>


	<div class="container">
		<h3>Les meilleurs véhicule en vente</h3>
		<br />
		<div class="row">
			<div class="col-lg-9">

				<div id="isotopecontent" class="col-lg-12">
					<c:forEach var="v" items="${vehicules }">
						<div class="element">
							<img class="imageVehicule" alt="${v.marque } ${v.modele }" src="${v.url }">
							<p class="marque">${v.marque } ${v.modele }</p>
							<p class="equipement">${v.equipement }</p>
							<p class="buttonVehicule">
								<a href="detail.do?id=${v.id }"><button>Voir le detail</button></a>
							</p>

						</div>
					</c:forEach>

				</div>
			</div>

			<div class="col-lg-3">
				<div class="main padder">
					<section class="panel">
						<form action="../j_spring_security_check" method="POST"
							class="panel-body">
							<div class="block">
								<label class="control-label">Email</label> <input type="email"
									placeholder="test@example.com" class="form-control"
									name="j_username">
							</div>
							<div class="block">
								<label class="control-label">Mot de passe</label> <input
									type="password" id="inputPassword" placeholder="Password"
									class="form-control" name="j_password">
							</div>

							<button type="submit" class="btn btn-info">Connexion</button>

							<a href="../client/init.do" class="col-lg-12 col-lg-offset-5">Créer
								un compte</a>


						</form>
					</section>


				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12 col-lg-offset-9">
			
				
			</div>
		</div>
	</div>


	<script type="text/javascript">
		var j = jQuery.noConflict();
		j(document).ready(function() {

			j('a').on('click', function() {
				j(this).blur();
			});

			var container = j('#isotopecontent');
			container.isotope({
				itemSelector : '.element',
				animationEngine : 'jquery'
			});

		});
	</script>

</body>

</html>