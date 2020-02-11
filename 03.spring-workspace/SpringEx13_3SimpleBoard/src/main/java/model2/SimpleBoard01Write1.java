package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleBoard01Write1 implements Controller{

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Writer1 SubController 호출");
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_write1");
		return modelAndView;
	}


}
