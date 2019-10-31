<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="col-md-6">
				<p> 
					<button class="btn btn-default btn-success" onclick="window.location.href='showFormForAdd'; return false;">Add Customer</button> 
				</p>
			</div>
			<div class="col-md-6">
				<form:form action="searchCustomer" method="get">
					  <div class="form-group row">
					    <div class="col-sm-10">
					      <input type="text" name="theSearchName" class="form-control form-control-sm" id="theSearchName" placeholder="Search by name" />
					    </div>
					     <input type="submit" value="Search" class="btn btn-default btn-sm" />
					  </div>
			    </form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<td>First Name</td>
							<td>Last Name</td>
							<td>Email</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="customer" items="${customers}">
							<c:url var="updateLink" value="/customer/showFormForUpdate">
								<c:param name="customerId">${customer.id}</c:param>
							</c:url>
							<c:url var="deleteLink" value="/customer/deleteCustomer">
								<c:param name="customerId">${customer.id}</c:param>
							</c:url>
							<tr>
								<td>${customer.firstName}</td>
								<td>${customer.lastName}</td>
								<td>${customer.email}</td>
								<td>
									<a href="${updateLink}">Update</a> | 
									<a href="${deleteLink}" onclick="if(!(confirm('Voulez vous vraiment supprimer ce client'))) return false;">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>