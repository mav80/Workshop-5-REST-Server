<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="<%out.print(request.getContextPath());%>/static/css/style.css">
    	<script src="http://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
		<script src="<%out.print(request.getContextPath());%>/static/js/app.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Warsztat 5 - my own REST server</title>
	</head>
	<body>
		<h1>Hello World Warsztat 5 views!</h1>
		       <center>
        <span style="display: inline-block">
            <form action="books/add/" method="post" name="book" id="newBook">
            	<input type="number" name="id" placeholder="id">
                <input type="text" name="title" placeholder="tytuł">
                <input type="text" name="author" placeholder="autor"><br>
                <input type="text" name="publisher" placeholder="wydawca">
                <input type="text" name="type" placeholder="gatunek"><br>
                <input type="text" name="isbn" placeholder="numer isbn"><br>
                <input type="submit" id="submitNewBook" class="sendButton" value="Utwórz nową książkę">
            </form>
        </span>

        <span style="display: inline-block">
            <form id="bookResetForm">
            <input type="submit" id="bookResetButton" class="sendButton" value="Przywróć początkową listę książek">
            </form>
        </span>

        <span style="display: inline-block">
            <form id="editBookForm">
            <input type="text" name="title" placeholder="tytuł">
            <input type="text" name="author" placeholder="autor"><br>
            <input type="text" name="publisher" placeholder="wydawca">
            <input type="text" name="type" placeholder="gatunek"><br>
            <input type="text" name="isbn" placeholder="numer isbn">
            <input type="text" name="id" placeholder="id"><br>
            <input type="submit" id="submitEditBook" class="sendButton" value="Zmień książkę">
            </form>
        </span>
       
        <ul id="books"></ul>
        </center>
	</body>
</html>
