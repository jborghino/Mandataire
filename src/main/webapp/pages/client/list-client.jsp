<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>
<link rel="stylesheet" href=<c:url value="/template/css/bootstrap.css"/>>
<link rel="stylesheet"
	href=<c:url value="/template/css/font-awesome.min.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/font.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/style.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/plugin.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/landing.css"/>>
<link rel="stylesheet" href=<c:url value="/template/css/mycss.css"/>>

<!-- datepicker -->
<script
	src=<c:url value="/template/js/datepicker/bootstrap-datepicker.js"/>></script>
<!-- / footer -->
<script src=<c:url value="/template/js/jquery.min.js"/>></script>
<!-- Bootstrap -->
<script src=<c:url value="/template/js/bootstrap.js"/>></script>
<!-- app -->
<script src=<c:url value="/template/js/app.js"/>></script>
<script src=<c:url value="/template/js/app.plugin.js"/>></script>
<script src=<c:url value="/template/js/app.data.js"/>></script>
<!-- fuelux -->
<script src=<c:url value="/template/js/fuelux/fuelux.js"/>></script>
<!-- slider -->
<script src=<c:url value="/template/js/slider/bootstrap-slider.js"/>></script>
<!-- file input -->
<script
	src=<c:url value="/template/js/file-input/bootstrap.file-input.js"/>></script>
<!-- combodate -->
<script src=<c:url value="/template/js/combodate/moment.min.js"/>></script>
<script src=<c:url value="/template/js/combodate/combodate.js"/>></script>
<!-- parsley -->
<script src=<c:url value="/template/js/parsley/parsley.min.js"/>></script>
<!-- select2 -->
<script src=<c:url value="/template/js/select2/select2.min.js"/>></script>

<!--[if lt IE 9]>
    <script src="/template/js/ie/respond.min.js" cache="false"></script>
    <script src="/template/js/ie/html5.js" cache="false"></script>
    <script src="/template/js/ie/excanvas.js" cache="false"></script>
  <![endif]-->
</head>


<body>

	<div class="jumbotron">
		<div class="container">
			<h1>Bootstrap Spring MVC</h1>

		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div id="logout" class="row">
					<a href="<c:url value="../j_spring_security_logout" />"> Log
						out&nbsp; </a> <i class="fa fa-arrow-circle-right"></i>
				</div>
			</div>
		</div>


		<!-- ADMIN ONLY -->
		<security:authorize ifAllGranted="ROLE_ADMIN">
			<!-- AJOUT CLIENT -->
			<div class="row">
				<div class="col-lg-6">
					<a href="init.do"><i class="fa fa-plus-square">Ajouter un client</i></a>
					<a href="../article/init.do"><i class="fa fa-plus-square">Ajouter un article</i></a>
					
				</div>
			</div>
			<!-- FIN AJOUT CLIENT -->

			<div class="row">
				<div class="col-lg-5">
					<table
						class="table-condensed table-hover table-striped table-bordered"
						id="myTable">
						<tr>
							<th style="width: 10%">Nom</th>
							<th style="width: 10%">Prenom</th>
						</tr>
						<c:forEach var="client" items="${clients }">

							<tr>
								<td>${client.nom }</td>
								<td>${client.prenom }</td>
							</tr>
						</c:forEach>
					</table>
				</div>


			</div>

		</security:authorize>
		<!-- END ADMIN ONLY -->

		<!-- USER ONLY -->
		<security:authorize ifAllGranted="ROLE_USER">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<h3>Vos commandes</h3>
					</div>
				</div>
		</security:authorize>
		<!-- END USER ONLY -->


	</div>


</body>


</html>