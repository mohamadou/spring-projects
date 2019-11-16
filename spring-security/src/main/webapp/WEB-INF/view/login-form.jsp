<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
</head>
<body>

	<div class="container h-100">
		<div class="row h-100 justify-content-center align-item-center">
			<div class="card col-md-6 justify-content-center">
				<h3 class="text-center">Sign in</h3>
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						Invalid Username or Password
					</div>
				</c:if>
				
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						Logged out successfully !
					</div>
				</c:if>
				
				<form:form action="${pageContext.request.contextPath}/loginProcessingUrl" method="post">
				 	
					  <div class="form-group row">
					    <label for="username" class="col-sm-12 col-form-label col-form-label-sm">Username</label>
					    <div class="col-sm-10">
					      <input type="text" name="username" class="form-control form-control-sm" id="username" placeholder="Username" />
					    </div>
					  </div>
					  <div class="form-group row">
					    <label for="password" class="col-sm-12 col-form-label">Password</label>
					    <div class="col-sm-10">
					      <input type="password" name="password" class="form-control form-control-sm" id="password" placeholder="Password" />
					    </div>
					  </div>
				 
					  <div class="form-group row">
					    <div class="col-sm-10">
					      <input type="submit" value="Login" class="btn btn-primary" />
					    </div>
					  </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>