package spring.mvc.session13.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
	
}
