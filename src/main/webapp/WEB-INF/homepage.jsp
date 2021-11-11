<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
	<h3>Login</h3>
	<p>${loginError}</p>
	<form method="post" action="/login">
	<div class="form-group">
		<label>Email:</label>
		<input type="email" name="lemail">
	</div>
	<div class="form-group">
		<label>Password:</label>
		<input type="password" name="lpassword">
	</div>
	<button>Login!</button>
	</form>
	<div class="row">
	<div class="col">
	</div>
		<form action="/login" method="post" modelAttribute="user">
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:errors path="email"/>
				<form:input type="email" class="form-control" path="email"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:errors path="password"/>
				<form:input type="password" class="form-control" path="password"/>
			</div>
			<button>Login</button>
		</form>
	</div>
	</div>
	
	<h1>Register</h1>
	<div class="row">
	<div class="col">
	</div>
	<h3>Register</h3>
		<form action="/register" method="post" modelAttribute="email">
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:errors path="fristName"/>
				<form:input class="form-control" path="firstName"/>
			</div>
			<div class="form-group">
				<form:label path="lasttName">Last Name</form:label>
				<form:errors path="lastName"/>
				<form:input class="form-control" path="lastName"/>
			</div>
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:errors path="email"/>
				<form:input type="email" class="form-control" path="email"/>
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:errors path="password"/>
				<form:input type="password" class="form-control" path="password"/>
			</div>
			<div class="form-group">
				<form:label path="passwordConf">Password Conf</form:label>
				<form:errors path="passwordConf"/>
				<form:input type="password" class="form-control" path="passwordConf"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Register"/>
			<button>Register</button>
		</form>
	</div>

</body>
</html>