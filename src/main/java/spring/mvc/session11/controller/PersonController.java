package spring.mvc.session11.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session11.entity.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private List<Person> people = new CopyOnWriteArrayList<Person>();
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute Person person) {
		model.addAttribute("people", people);
		return "session11/person";
	}
	
	@PostMapping("/")
	public String add(Model model, @ModelAttribute @Valid Person person, BindingResult result) {
		// 驗證 Person
		// 驗證結果會放在 result 中
		if(result.hasErrors()) {
			// 若有錯誤發生就會自動機錯誤訊息傳送到指定的 view 中
			model.addAttribute("people", people);
			return "session11/person";
		}
		people.add(person);
		return "redirect:./";
	}
	
	
}
