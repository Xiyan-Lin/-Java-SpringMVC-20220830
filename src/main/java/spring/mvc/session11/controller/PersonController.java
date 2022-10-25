package spring.mvc.session11.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session11.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private List<Person> people = new CopyOnWriteArrayList<Person>();
	
	public String index(Model model, @ModelAttribute Person person) {
		model.addAttribute("people", people);
		return "session11/person";
	}
	
}
