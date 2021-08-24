<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displays</title>
</head>
<body>  
<h1><c:out value="${anime.title}"/></h1>
<p>Description: <c:out value="${anime.description}"/></p>
<p>Genre: <c:out value="${anime.genre}"/></p>
<p>Release Year: <c:out value="${anime.releaseYear}"/></p>
<a href="/animes/${anime.id}/edit">Edit Anime</a>

<form action="/animes/${anime.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>


</body>
</html> 