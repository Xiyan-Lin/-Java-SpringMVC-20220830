package spring.mvc.session13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session13.entity.Div;

@Controller
@RequestMapping("/session13/div")
public class DivController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Div div) {
		return "session13/div";
	}
	
	
}
