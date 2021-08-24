<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Anime</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1>Add Your Favorite New Animes!</h1>
<form:form class="form-floating mb-3" action="/animes" method="post" modelAttribute="anime">
	<p>
		<form:label for="floatingInput" path="title">Title:</form:label>
		<form:errors path="title"/>
		<form:input type="title" class="form-control" id="floatingInput" path="title"/>
	</p>
	
	
	<p>
		<form:label for="floatingInput" path="genre">Genre:</form:label>
		<form:errors path="genre"/>
		<form:input class="form-control" id="floatingInput" path="genre"/>
	</p>
	
	<p>
		<form:label for="floatingInput" path="releaseYear">Release Year:</form:label>
		<form:errors path="releaseYear"/>
		<form:input class="form-control" id="floatingInput" type="number" path="releaseYear"/>
	</p>
	
	<p class="text">
		<form:label for="floatingInput" path="description">Description:</form:label>
		<form:errors path="description"/>
		<form:textarea class="form-control" id="floatingInput" placeholder="Write the Anime Description here..." path="description"/>
	</p>
	<p>
		<form:label path="rating">Rating</form:label>
		<form:errors path="rating"/>
		<form:input path="rating"/>
		
	<div class="btn-group">
		<input class="btn btn-success active" aria-current="page" type="submit" value="AddNewAnime!">
		<a href="/animes" class="btn btn-outline-dark"> Return to Anime</a>
	</div>
</form:form>

</body>
</html>