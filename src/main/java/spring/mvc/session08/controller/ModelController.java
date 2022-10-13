package spring.mvc.session08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
