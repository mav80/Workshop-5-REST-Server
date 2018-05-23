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
		<title>Warsztat 5 - REST server</title>
	</head>
	<body>
		<h3 style="text-align: center">Warsztat 5 - SPRING MVC, REST server</h3>

        <p style="text-align: justify">Celem warsztatu jest jest napisanie funkcjonalności backendowej do katalogowania książek metodą 
        REST z poprzedniego warsztatu. Do stworzenia API wykorzystałem Spring MVC, bibliotekę Jackson oraz dodatkowe adnotacje.
        Warstwa kliencka, napisana w HTML-u  oraz JavaScripcie, tak jak poprzednio, komunikuje się z serwerem za pomocą AJAX i 
        po najechaniu myszką na element zawierający tytuł książki pobiera w formacie JSON dane o książce 
        a następnie wyświetla je poniżej.</p>
        
		<center>
		
	        <span style="display: inline-block">
		        <form:form method="post" action="books/add/" modelAttribute="book" id="newBook">
					<form:input path="isbn" placeholder="numer isbn" type="number"/>
					<form:input path="title" placeholder="tytuł"/><br>
					<form:input path="author" placeholder="autor"/>
					<form:input path="publisher" placeholder="wydawca"/><br>
					<form:input path="type" placeholder="gatunek"/><br>
					<input type="submit" id="submitNewBook" class="sendButton" value="Utwórz nową książkę">
				</form:form>
	        </span>
	
			<span style="display: inline-block">

		            <form id="buttonsForm" style="padding-top: 0px">
			            <span style="display: block">
							<input type="submit" id="bookResetButton" class="sendButton" value="Przywróć początkową listę książek">
							
							<input type="submit" id="dataSourceSwitchButton" class="sendButton" value="Przełącz źródło danych">
				        </span>
				        
				        <p style="font-size: 0.3em"></p>
				        
			            <span>
			           	 	<span id="currentDataSource1">Obecne źródło danych: </span><span id="currentDataSource2">pamięć serwera</span>
		            	</span>
		            </form>
		      
	        </span>
	
	        
	        <span style="display: inline-block">
	        	<form:form method="post" action="books/edit/" modelAttribute="book" id="editBookForm">
	        		<form:input path="id" placeholder="id" type="number"/>
					<form:input path="isbn" placeholder="numer isbn" type="number"/><br>
					<form:input path="title" placeholder="tytuł"/>
					<form:input path="author" placeholder="autor"/><br>
					<form:input path="publisher" placeholder="wydawca"/>
					<form:input path="type" placeholder="gatunek"/><br>
		            <input type="submit" id="submitEditBook" class="sendButton" value="Zmień książkę">
	        	</form:form>
	        </span>
	       
	        <ul id="books"></ul>
	        
        </center>
        
	</body>
</html>
