package spring.mvc.session09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lotto")
public class LottoController {
	
	// lotto 主畫面
	@GetMapping("/")
	public String index(Model model) {
		return "session09/lotto";
	}
	
}
