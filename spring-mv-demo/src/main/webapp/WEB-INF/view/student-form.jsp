<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
    color: red;
    }
</style>
</head>
<body>
<form:form methode="post" action="processForm" modelAttribute="student">
	Name:<form:input path="firstName"/> <br>
	LastName:<form:input path="lastName"/> 
	<form:errors path="lastName" cssClass="error"/>
	<br>
	FavoriteLanguage: <br>
	<%-- Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C#<form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP<form:radiobutton path="favoriteLanguage" value="PHP"/>
	Python<form:radiobutton path="favoriteLanguage" value="Python"/> --%>
	
	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
	<br>
	Operating Systems <br>
	Linux<form:checkbox path="operatingSystems" value="Linux"/>
	Windows<form:checkbox path="operatingSystems" value="Windows"/>
	Ubunty<form:checkbox path="operatingSystems" value="Ubuntu"/>
	Mac<form:checkbox path="operatingSystems" value="Mac"/>
	<input type="submit" value="Send">
</form:form>
</body>
</html>