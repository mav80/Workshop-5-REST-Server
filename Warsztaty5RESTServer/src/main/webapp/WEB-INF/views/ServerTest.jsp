<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="<%out.print(request.getContextPath());%>/static/css/style.css">
    	<script src="http://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
		<script src="<%out.print(request.getContextPath());%>/static/js/app2.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Warsztat 5 - my own REST server</title>
	</head>
	<body>
		<h1>Hello World Warsztat 5 server test!</h1>
		<center>
	        <span style="display: inline-block">
		        <form:form method="post" action="books/add/" modelAttribute="book">
					<form:input path="isbn" placeholder="numer isbn" type="number"/>
					<form:input path="title" placeholder="tytuł"/><br>
					<form:input path="author" placeholder="autor"/>
					<form:input path="publisher" placeholder="wydawca"/><br>
					<form:input path="type" placeholder="gatunek"/><br>
					<input type="submit" value="Utwórz nową książkę">
				</form:form>
	        </span>
	
	        <span style="display: inline-block">
	            <form id="bookResetForm">
	            <input type="submit" id="bookResetButton" class="sendButton" value="Przywróć początkową listę książek">
	            </form>
	        </span>
	
	        
	        <span style="display: inline-block">
	        	<form:form method="post" action="books/edit/" modelAttribute="book">
	        		<form:input path="id" placeholder="id" type="number"/>
					<form:input path="isbn" placeholder="numer isbn" type="number"/><br>
					<form:input path="title" placeholder="tytuł"/>
					<form:input path="author" placeholder="autor"/><br>
					<form:input path="publisher" placeholder="wydawca"/>
					<form:input path="type" placeholder="gatunek"/><br>
		            <input type="submit" id="submitEditBook" class="sendButton" value="Zmień zbindowaną książkę">
	        	</form:form>
	        </span>
	       
	        <ul id="books"></ul>
        </center>
        
	</body>
</html>
