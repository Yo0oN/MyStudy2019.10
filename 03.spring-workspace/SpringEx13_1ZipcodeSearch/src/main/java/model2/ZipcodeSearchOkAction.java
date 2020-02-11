package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.ZipcodeDAO;
import model1.ZipcodeTO;

public class ZipcodeSearchOkAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ZipcodeSearchOkAction 호출");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("zipcodeSearchOk");

		ZipcodeDAO dao = new ZipcodeDAO();
		
		ArrayList<ZipcodeTO> toLists = dao.search(arg0.getParameter("dong"));

		modelAndView.addObject("toLists", toLists);

		return modelAndView;
	}
}
