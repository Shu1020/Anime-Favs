<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Anime List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="text-center">
<h1>Edit Anime</h1>
<form:form action="/animes/edit/${anime.id}" method="post" modelAttribute="anime">
    <!-- <input name="_method"> -->
    <p>
        <form:label for="formControlInput" class="form-label" path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input type="title" class="form-control" id="formControlInput" path="title"/>
    </p>
    <p>
        <form:label for="formControlInput" class="form-label" path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea type="description" class="form-control" id="formControlInput" path="description"/>
    </p>
    <p>
        <form:label for="formControlInput" class="form-label" path="genre">Genre</form:label>
        <form:errors path="genre"/>
        <form:input type="genre" class="form-control" path="genre"/>
    </p>
    <p>
        <form:label for="formControlInput" class="form-label" path="releaseYear">Release Year</form:label>
        <form:errors path="releaseYear"/>     
        <form:input class="form-control" id="formControlInput" type="number" path="releaseYear"/>
    </p>    
    <p>
    	<form:label path="rating">Rating</form:label>
		<form:errors path="rating"/>
		<form:input type="number" class="form-control" path="rating"/>
    </p>
    <div class="d-grid gap-2">
    <input class="btn btn-primary" type="submit" value="Submit"/>
    </div>
</form:form>
</div>

</body>
</html>