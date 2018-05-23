package pl.coderslab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.app.Book;
import pl.coderslab.app.BookService;
import pl.coderslab.app.DatabaseBookService;
import pl.coderslab.app.MemoryBookService;

@RestController
public class BookControllerDatabase {
	
public BookService bookService;
	
	@Autowired
	public BookControllerDatabase(@Qualifier("databaseBookService") BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/booksDb/all")
	@ResponseBody
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	
	@GetMapping("/booksDb/{bookId}")
	@ResponseBody
	public Book getSingleBook(@PathVariable long bookId) {
		return bookService.getSingleBookById(bookId);
	}
	
	
	@PostMapping("/booksDb/add/")
	public @ResponseBody Book addBook(@RequestBody Book book) {
		//System.out.println(book);
		bookService.saveBook(book);
		return book;
	}
	
	
	@DeleteMapping("/booksDb/remove/{bookId}") 
	public String deleteBook(@PathVariable long bookId) {
		bookService.deleteBook(bookId);
		return "Ksiazke usunieto z listy.";
	}
	
	
	@PutMapping("/booksDb/edit/")
	public ResponseEntity<Book> editBook(@RequestBody Book book) {
		Boolean status = bookService.editBook(book);
		//System.out.println(status);
		if(status) {
			return  new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@DeleteMapping("/booksDb/remove/all") 
	public String resetListOfBooks() {
		bookService.bookListReset();
		return "Lista zostala zresetowana.";
	}

}
