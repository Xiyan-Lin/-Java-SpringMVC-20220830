package spring.mvc.session08.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session08.entity.Person;

@RequestMapping("/model")
@Controller
public class ModelController {
	
	// 宣告 Model 參數是用來放置要傳給 view 的資料
	// 回傳值 String, 指的就是 view 的路徑 (配合 springmvc-servlet.xml 的設定)
	@GetMapping("/case1")
	public String case1(Model model) {
		model.addAttribute("data1", "Hello model 1");
		model.addAttribute("data2", "Hello model 2");
		model.addAttribute("data3", "Hello model 3");
		return "session08/show_data";
	}
	
	// Model 是陣列/集合/物件: List, Map, Person
	@GetMapping("/case2")
	public String case2(Model model) {
		List<String> names = Arrays.asList("John", "Mary", "Helen");
		Map<String, Integer> fruits = new LinkedHashMap<>();
		fruits.put("apple", 50);
		fruits.put("banana", 30);
		Person person = new Person();
		person.setName("Tom");
		person.setAge(18);
		person.setScore(100.0);
		person.setPass(true);
		model.addAttribute("data1", names);
		model.addAttribute("data2", fruits);
		model.addAttribute("data3", person);
		return "session08/show_data";
	}
	
	// 重定向 redirect
	@GetMapping("/case3")
	public String case3() {
		//String path = "http://tw.yahoo.com"; // 重定向到外網
		//String path = "/index.jsp"; // 重定向到內網某一個 jsp
		//String path = "/mvc/hello/welcome"; // 重定向到某一個 controller
		String path = "./case1"; // 重定向到本身 controller 中的某一個方法
		return "redirect:" + path;
	}
	
}
