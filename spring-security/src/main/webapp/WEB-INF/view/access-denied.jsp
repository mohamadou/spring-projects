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
				<h3>Access denied : you are not authorized to access this resource</h3>
				<hr>
			</div>
		</div>
		
		<div class="row">
			<div class="col col-12">
				<p>
					<a href="${pageContext.request.contextPath}">Back to home Page</a>
				</p>

			</div>
		</div>
	</div>
</body>
</html>