package spring.mvc.session13.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		String referer = request.getHeader("Referer");
		ModelAndView mv = new ModelAndView();
		mv.addObject("referer", referer);
		mv.addObject("ex", ex);
		mv.setViewName("error/global_error");
		return mv;
	}

}
