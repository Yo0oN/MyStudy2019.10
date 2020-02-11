package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.SimpleBoard01DAO;
import model1.SimpleBoard01TO;

public class SimpleBoard01modify1Ok implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Modify1Ok SubController 호출");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_modify1_ok");
		
		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));
		to.setSubject(request.getParameter("subject"));
		String mail = "";
		if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		} else {
			to.setMail("");
		}
		to.setPassword(request.getParameter("password"));
		to.setContent(request.getParameter("content"));

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		int flag = dao.boardModifyOk(to);

		request.setAttribute("flag", flag);
		request.setAttribute("seq", to.getSeq());
		return modelAndView;
	}


}
