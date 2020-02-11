package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.SimpleBoard01DAO;
import model1.SimpleBoard01TO;

public class SimpleBoard01list1 implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("List1 SubController 호출");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_list1");
		
		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		ArrayList<SimpleBoard01TO> boardLists = dao.boardList();

		arg0.setAttribute("boardLists", boardLists);

		return modelAndView;
	}


}
