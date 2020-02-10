package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.SimpleBoard01DAO;
import model1.SimpleBoard01TO;

public class SimpleBoard01View1 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("View1 SubController 호출");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_view1");
		
		SimpleBoard01TO to = new SimpleBoard01TO();
		to.setSeq(request.getParameter("seq"));
		
		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		 to = dao.boardView(to);

		request.setAttribute("to", to);
		return modelAndView;
	}


}
