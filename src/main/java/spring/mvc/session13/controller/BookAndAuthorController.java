package spring.mvc.session13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.session13.entity.Author;
import spring.mvc.session13.entity.Book;

@Controller
@RequestMapping("/session13/book_author")
public class BookAndAuthorController {
	
	@GetMapping("/")
	public String index() {
		return "session13/book_author";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String add(@ModelAttribute("b") Book book, 
					  @ModelAttribute("a") Author author) {
		return book + " " + author;
	}
	
}
