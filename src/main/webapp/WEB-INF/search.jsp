<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Anime</title>
</head>
<body>
<div class="container">
	<a href="/animes/new">Add A Anime!</a>
	<a class="px-2" href="/animes">Back to Anime Home</a>
	<div class="navbar navbar-expand-lg navbar-light bg-light">
		<form class="d-flex" action="/search" method="post">
		<input class="form-control me-2" placeholder="Ex: Title, Genre, Year.." type="text" name="title">
		<button class="btn-outline-success" type="submit">Search</button>
		</form>
	</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Genre</th>
					<th>Release Year</th>
					<th>Rating</th>
			</thead>
			<tbody>
			<c:forEach items="${animes}" var="anime">
				<tr>
					<td><a href="/animes">${anime.title}</a></td>
					<td>${anime.description}</td>
					<td>${anime.genre}</td>
					<td>${anime.releaseYear}</td>
					<td>${anime.rating}</td>
					<td><a href="/delete/${anime.id}">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		
		</table>


</div>
</body>
</html>