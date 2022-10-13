package spring.mvc.session08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/data")
@Controller
public class DataController {
	
	// 執行路徑: /mvc/data/case1
	//@RequestMapping(value = "/case1", method = RequestMethod.GET)
	//@GetMapping(value = "/case1")
	@GetMapping("/case1")
	public ModelAndView case1() {
		String data = "Hello data 1"; // 資料(Model)
		String view = "/WEB-INF/view/session08/show_data.jsp"; // 資料呈現地(資料渲染地)
		// 建立 ModelAndView, 目的: 將 data(model) 與 view 封裝起來
		ModelAndView mv = new ModelAndView();
		mv.addObject("data1", data);
		mv.setViewName(view);
		return mv;
	}
	
	@GetMapping("/case2")
	public ModelAndView case2() {
		String data = "Hello data 2"; // 資料(Model)
		String view = "/WEB-INF/view/session08/show_data.jsp"; // 資料呈現地(資料渲染地)
		// 建立 ModelAndView, 目的: 將 data(model) 與 view 封裝起來
		return new ModelAndView(view, "data2", data);
	}
	
	
	
}
