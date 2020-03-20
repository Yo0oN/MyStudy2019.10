package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.SimpleBoard01DAO;
import model1.SimpleBoard01TO;

public class SimpleBoard01Writer1Ok implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Writer1Ok SubController 호출");

		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("board_write1_ok");
		
		String mail = "";
		if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
		}

		SimpleBoard01TO to = new SimpleBoard01TO();
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		to.setMail(mail);
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));
		to.setWip(request.getRemoteAddr());

		SimpleBoard01DAO dao = new SimpleBoard01DAO();

		int flag = dao.boardWriteOk(to);

		request.setAttribute("flag", flag);
		return modelAndView;
	}

}
