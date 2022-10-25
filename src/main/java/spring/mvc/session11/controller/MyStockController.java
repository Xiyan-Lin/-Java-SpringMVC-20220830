package spring.mvc.session11.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session11.entity.MyStock;

@Controller
@RequestMapping("/mystock")
public class MyStockController {
	private List<MyStock> myStocks = new CopyOnWriteArrayList<>();
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute MyStock myStock) {
		model.addAttribute("myStocks", myStocks);
		return "session11/mystock";
	}
	
}
