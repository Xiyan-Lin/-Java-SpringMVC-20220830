package spring.mvc.session13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session13/div")
public class DivController {
	
	@GetMapping("/")
	public String index() {
		return "session13/div";
	}
	
	
}
