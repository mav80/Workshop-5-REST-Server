package pl.coderslab.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.app.Book;
import pl.coderslab.app.BookService;

@RestController
public class BookController {
	
	public BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books/all")
	@ResponseBody
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	
	@GetMapping("/books/{bookId}")
	@ResponseBody
	public Book getSingleBook(@PathVariable long bookId) {
		return bookService.getSingleBookById(bookId);
	}
	
	
	@PostMapping("/books/add/")
	public @ResponseBody Book addBook(@RequestBody Book book) {
		//System.out.println(book);
		bookService.saveBook(book);
		return book;
	}
	
	
	@DeleteMapping("/books/remove/{bookId}") 
	public String deleteBook(@PathVariable long bookId) {
		bookService.deleteBook(bookId);
		return "Ksiazke usunieto z listy.";
	}
	
	@PutMapping("/books/edit/")
	public @ResponseBody Book editBook(@RequestBody Book book) {
		bookService.editBook(book);
		return book;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	//first two test controllers
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
	return "{hello: World}";
	}
	
	@RequestMapping("/helloBook")
	@ResponseBody
	public Book helloBook(){
	return new Book(1L,"9788324631766","Thiniking in Java",	"Bruce Eckel","Helion","programming");
	}

}
