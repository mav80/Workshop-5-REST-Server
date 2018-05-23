# Workshop-5-REST-Server

The purpose of this workshop is to write a fully functional back-end REST server for the front-end app from Workshop 4. For creating our API I'm using Spring MVC and external library Jackson. 

User can view, add, remove and edit book from the list that is kept in the server memory and initialized upon server start.

I extended this project, by using Hibernate and Spring Data, so that books can now also be kept in a dedicated database - this way any changes made by user won't be lost upon server restart. User can freely switch between these two data sources (server's memory or a disk database) by clicking dedicated button. JavaScript code stays the same, only difference is in controller addresses it calls.

It is also possible to reset the list of books (in the server's memory or in the database) to it's default state by clicking a button - useful when, for example, all the books were deleted.
