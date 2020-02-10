package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteOkAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("WriteOkAction 호출");
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("write_ok");

		modelAndView.addObject("data", arg0.getParameter("data"));
		
		return modelAndView;
	}

}
