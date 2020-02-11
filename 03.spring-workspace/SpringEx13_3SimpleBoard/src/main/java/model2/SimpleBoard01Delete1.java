package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.SimpleBoard01DAO;
import model1.SimpleBoard01TO;

public class SimpleBoard01Delete1 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Delete1 SubController 호출");
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_delete1");
		
		SimpleBoard01TO to = new SimpleBoard01TO();
		to.setSeq(arg0.getParameter("seq"));

		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		to = dao.boardDelete(to);
		
		arg0.setAttribute("to", to);
		
		return modelAndView;
	}

}
