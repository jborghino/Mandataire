<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

	<div class="container">
		<div class="row">
			<div class="col-lg-6">

				<form:form action="save.do" commandName="cl" method="POST"
					cssClass="form-horizontal">

					<form:hidden name="id" path="id" />

					<form:errors path="nom" />

					<div class="form-group">
						<form:label path="nom">Nom</form:label>
						<form:input name="nom" path="nom" cssClass="bg-focus form-control" />
					</div>

					<form:errors path="prenom" />

					<div class="form-group">
						<form:label path="prenom">Prenom</form:label>
						<form:input name="prenom" path="prenom"
							cssClass="bg-focus form-control" />
					</div>

					<form:errors path="adresse" />

					<div class="form-group">
						<form:label path="adresse">Adresse</form:label>
						<form:input name="adresse" path="adresse"
							cssClass="bg-focus form-control" />
					</div>

					<form:errors path="mail" />

					<div class="form-group">
						<form:label path="mail">Mail</form:label>
						<form:input name="mail" path="mail"
							cssClass="bg-focus form-control" />
					</div>

					<br />

					<form:errors path="password" />

					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:input type="password" name="password" path="password"
							cssClass="bg-focus form-control" />
					</div>

					<br />

					<security:authorize ifAllGranted="ROLE_ADMIN">
						<form:errors path="role" />

					<div class="form-group">
						<form:label path="role">Role</form:label>
						<form:input name="role" path="role"
							cssClass="bg-focus form-control" />
					</div>
					</security:authorize>

					<input type="submit" value="Valider" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>

</html>