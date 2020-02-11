package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.SimpleBoard01DAO;
import model1.SimpleBoard01TO;

public class SimpleBoard01Delete1Ok implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("Delete1Ok SubController 호출");

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("board_delete1_ok");

		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(arg0.getParameter("seq"));
		to.setPassword(arg0.getParameter("password"));

		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		int flag = dao.boardDeleteOk(to);

		arg0.setAttribute("flag", flag);

		return modelAndView;
	}

}
