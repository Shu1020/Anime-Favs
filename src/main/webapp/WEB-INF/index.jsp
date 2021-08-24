<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    
    <title>Test Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1 class="text-center">Discover All your Favorite Anime here!</h1>
	<table class="table">
		<thead>
			<tr class="table-primary">
				<th scope="col">Title</th>
				<th>Description</th>
				<th>Genre</th>
				<th>Release Year</th>
				<th>Rating</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${animes}" var="anime">
			<tr>
				<td><c:out value="${anime.title}"/></td>
				<td><c:out value="${anime.description}"/></td>
				<td><c:out value="${anime.genre}"/></td>
				<td><c:out value="${anime.releaseYear}"/></td>
				<td><c:out value="${anime.rating}"/></td>
				<td type="button" class="btn btn-primary"><a class="btn btn-outline-dark" href="/animes/edit/${anime.id}">Edit Anime</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
  		<div class="container-fluid">
	<button type="button" class="btn btn-primary"><a class="navbar-brand" href="/animes/new">Add New Anime!</a></button>
<!-- 	<a href="/animes/edit/{id}">Edit Anime</a> -->
	<button type="button" class="btn btn-success"><a class="navbar-brand" href="/search">Search Anime</a></button>
		</div>
	</nav>
</div>
</body>
</html>
