package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@RequestMapping("/hello")
	public String hello(){
	return "{hello: World}";
	}

}
