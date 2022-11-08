package spring.mvc.session13.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {
	
	@ExceptionHandler({RuntimeException.class, SQLException.class})
    public String fix(Exception ex, Model model, HttpServletRequest request){
        System.out.println("全局例外處理");
        String referer = request.getHeader("Referer");
		model.addAttribute("referer", referer);
        model.addAttribute("ex", ex);
        return "error/global_error";
    }
	
	@ModelAttribute(name = "globalMapData")
    public Map<String,Object> mydata() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("copyright", "ABC公司");
        map.put("version", 11);
        return map;
    }
	
	@InitBinder("b")
    public void b(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }
    
    @InitBinder("a")
    public void a(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }
}
