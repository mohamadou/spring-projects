<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<p>
		<h2>CRM: Customer Relationship Management</h2>
		</p>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3>Save Customer</h3>
				<form:form action="saveCustomer" method="post" modelAttribute="customer" >
				 		<form:hidden path="id"/>
					  <div class="form-group row">
					    <label for="firstName" class="col-sm-2 col-form-label col-form-label-sm">First Name</label>
					    <div class="col-sm-10">
					      <form:input path="firstName" class="form-control form-control-sm" id="firstnName" placeholder="First Name" />
					    </div>
					  </div>
					  <div class="form-group row">
					    <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
					    <div class="col-sm-10">
					      <form:input path="lastName" class="form-control form-control-sm" id="lastName" placeholder="Last Name" />
					    </div>
					  </div>
					  <div class="form-group row">  
					    <label for="email" class="col-sm-2 col-form-label col-form-label-lg">Email</label>
					    <div class="col-sm-10">
					      <form:input path="email" class="form-control form-control-sm" id="email" placeholder="Email" />
					    </div>
					  </div>
					  
					  <div class="form-group row">
					    <div class="col-sm-10">
					      <input type="submit" value="Save" class="btn btn-default btn-lg" />
					    </div>
					  </div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			 	<p> <a href="${pageContext.request.contextPath}/customer/list">Back to the list</a> </p>
			</div>
		</div>
	</div>

</body>
</html>