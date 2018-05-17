package pl.coderslab.controllers;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.app.Book;
import pl.coderslab.app.MemoryBookService;

@RestController
public class BookController {
	
	public MemoryBookService memoryBookService;
	
	@Autowired
	public BookController(MemoryBookService memoryBookService) {
		this.memoryBookService = memoryBookService;
	}
	
	@GetMapping("/books/all")
	@ResponseBody
	public List<Book> getAllBooks() {
		return memoryBookService.getList();
	}
	
	
	@GetMapping("/books/{bookId}")
	@ResponseBody
	public Book getSingleBook(@PathVariable long bookId) {
		return memoryBookService.getSingleBookById(bookId);
	}
	
	@PostMapping("/books/add/")
	public String addBook(@ModelAttribute Book book) {
		memoryBookService.saveBookToList(book);
		return "Ksiazke dodano do listy.";
	}
	
	@DeleteMapping("/books/delete/{bookId}")
	public String deleteBook(@PathVariable long bookId) {
		memoryBookService.deleteBook(bookId);
		return "Ksiazke usunieto z listy.";
	}
	
	@PutMapping("/books/edit/")
	public String editBook(@ModelAttribute Book book) {
		memoryBookService.editBook(book);
		return "Ksiazka zostala zmieniona.";
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
