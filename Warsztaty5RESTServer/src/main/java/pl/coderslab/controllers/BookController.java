package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.app.Book;
import pl.coderslab.app.MemoryBookService;

@Controller
public class BookController {
	
	public MemoryBookService memoryBookService;
	
	@Autowired
	public BookController(MemoryBookService memoryBookService) {
		this.memoryBookService = memoryBookService;
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
