package spring.mvc.session11.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session11.entity.MyStock;
import spring.mvc.session11.validator.MyStockValidator;

@Controller
@RequestMapping("/mystock")
public class MyStockController {
	private List<MyStock> myStocks = new CopyOnWriteArrayList<>();
	
	@Autowired
	private MyStockValidator myStockValidator;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute MyStock myStock) {
		model.addAttribute("myStocks", myStocks);
		return "session11/mystock";
	}
	
	@PostMapping("/")
	public String add(Model model, @ModelAttribute @Valid MyStock myStock, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("myStocks", myStocks);
			return "session11/mystock";
		}
		myStocks.add(myStock);
		return "redirect:./";
	}
}
