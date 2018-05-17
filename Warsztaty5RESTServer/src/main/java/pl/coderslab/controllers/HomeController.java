package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.coderslab.app.Book;

@Controller
public class HomeController {
	
	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("book", new Book());
		return "index";
	}
	
	@GetMapping("/servertest")
	public String serverTest(Model model) {
		model.addAttribute("book", new Book());
		return "ServerTest";
	}

}
