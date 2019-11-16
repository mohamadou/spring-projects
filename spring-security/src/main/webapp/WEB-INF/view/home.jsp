<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	<div class="row justify-content-center mt-2  mx-auto">
			<div class="col col-8 text-center">
				<h2>PrestaDak Home Page</h2>
			</div>
		</div>
		<div class="row">
			<div class="col col-10">
				<p>
				<security:authorize access="isAuthenticated()">
				    Welcome Back, <security:authentication property="principal.username"/>
				</security:authorize>
				</p>
			</div>
			
			<div class="col col-2 text-center">
				<form:form action="${pageContext.request.contextPath}/logout">
					<input type="submit" value="Logout">
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col col-12">
				<p>
				<security:authorize access="isAuthenticated()">
				    Role(s):  <security:authentication property="principal.authorities"/>
				</security:authorize>
				</p>
			</div>
			<div class="col col-12">
				<security:authorize access="hasRole('MANAGER')">
					<p>
						<a href="${pageContext.request.contextPath}/leaders">Leaders infos</a>
					</p>
				</security:authorize>
				<security:authorize access="hasRole('ADMIN')">
					<p>
						<a href="${pageContext.request.contextPath}/systems">Sys Admin infos</a>
					</p>
				</security:authorize>
			</div>
		</div>
	</div>
</body>
</html>