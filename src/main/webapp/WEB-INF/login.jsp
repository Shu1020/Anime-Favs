<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<h1>Login</h1>
	<p><c:out value="${error}"/></p>
	<form method="post" action="/login">
	<p>
		<label type="email" for="email">Email</label>
		<input type="text" id="email" name="email"/>
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>
	</p>
	<input type="submit" value="Login to Anime Fans!" <a href="/login/animes"/>>
	</form>
	
		<h1>Register Now!</h1>
	<p><form:errors path="user.*"/></p>
	
	<form:form method="post" action="/login" modelAttribute="user">
		<p>
			<form:label path="email" for="email">Email:</form:label>
			<form:input type="email" path="email"/>
		</p>
		
		<p>
			<form:label path="password">Password:</form:label>
			<form:input path="password"/>
		</p>
		
		<p>
			<form:label path="passwordConf">Password Confirmation:</form:label>
			<form:input path="passwordConf"/>
		</p>
		<input type="submit" value="Register!">
	</form:form>
</body>
</html>