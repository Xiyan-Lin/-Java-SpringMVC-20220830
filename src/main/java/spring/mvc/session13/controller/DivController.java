package spring.mvc.session13.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.session13.entity.Div;

@Controller
@RequestMapping("/session13/div")
public class DivController {
	
	@GetMapping("/")
	public String index(@ModelAttribute Div div) {
		return "session13/div";
	}
	
	@PostMapping("/")
	public String calc(@ModelAttribute Div div) {
		int result = div.getX() / div.getY();
		div.setResult(result);
		return "session13/div";
	}
	
	// 捕獲資料配置錯誤
	//@ExceptionHandler({ArithmeticException.class, BindException.class})
	@ExceptionHandler({BindException.class})
	public String fixed(Exception ex, Model model, HttpServletRequest request) {
		String referer = request.getHeader("Referer"); // 前一頁的位置
		model.addAttribute("referer", referer);
		model.addAttribute("ex", ex); // 錯誤訊息
		return "session13/error";
	}
}
