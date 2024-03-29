<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>

<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<tilesx:useAttribute name="current"/>

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href='<spring:url value="/"></spring:url>'>Ankieta</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/"></spring:url>'>Home</a></li>
					<security:authorize access="hasRole('ROLE_USER')"><li class="${current == 'nowaAnkieta' ? 'active' : ''}"><a href="<spring:url value="/nowaAnkieta.html" />">Nowa ankieta</a></li></security:authorize>
				</ul>
				<ul class="nav navbar-nav navbar-right my-header">
					<security:authorize access="!isAuthenticated()"><li><a href="<spring:url value="/login.html" />">Login</a></li></security:authorize>
					<security:authorize access="isAuthenticated()">
						<li>
							<span class="header-text">
								Zalogowany jako: <security:authentication property="principal.username"></security:authentication>
							</span>
						</li>
						<li>
							<span class="header-text">
								<span class="glyphicon glyphicon-user"></span>
							</span>
						</li>
						<li>
							<a href="<spring:url value="/logout"/>">
								<span class="glyphicon glyphicon-off"></span>
							</a>
						</li>
					</security:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid --> </nav>
	
		<tiles:insertAttribute name="body" />

		<br>
		<br>

		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>
	<!-- /container -->

</body>
</html>