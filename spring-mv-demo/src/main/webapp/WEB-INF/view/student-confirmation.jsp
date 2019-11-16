<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
 <h1>Student confirmation Page</h1>
 <p>FirstName: ${student.firstName}</p>
 <p>FirstName: ${student.lastName}</p>
  <p>Favorite Language: ${student.favoriteLanguage}</p>
  <p>Operating Systems
  	<ul>
	    <c:forEach var="temp" items="${student.operatingSystems}">
	   		<li> ${temp}</li>
	   </c:forEach>
	</ul>

  </p>
</body>
</html>