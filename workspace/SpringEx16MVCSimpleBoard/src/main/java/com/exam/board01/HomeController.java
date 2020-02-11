package com.exam.board01;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model1.BoardListTO;
import com.exam.model1.SimpleBoard01DAO;
import com.exam.model1.SimpleBoard01TO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest request) {
		System.out.println("list호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		BoardListTO boardLists = new BoardListTO();

		if (request.getParameter("cpage") != null) {
			boardLists.setCpage(Integer.parseInt(request.getParameter("cpage")));
		}

		boardLists = dao.boardList(boardLists);

		modelAndView.addObject("boardLists", boardLists);

		return modelAndView;
	}

	@RequestMapping("/view.do")
	public ModelAndView view(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));

		to = dao.boardView(to);

		modelAndView.addObject("to", to);
		modelAndView.addObject("cpage", request.getParameter("cpage"));
		
		return modelAndView;
	}

	@RequestMapping("/write.do")
	public ModelAndView write(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1");
		modelAndView.addObject("cpage", request.getParameter("cpage"));

		return modelAndView;
	}

	@RequestMapping("/write_ok.do")
	public ModelAndView write_ok(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1_ok");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		SimpleBoard01TO to = new SimpleBoard01TO();
		to.setContent(request.getParameter("content"));
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		if (request.getParameter("mail1").equals("") || request.getParameter("mail2").equals("")) {
			to.setMail("");
		} else {
			to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		}
		to.setPassword(request.getParameter("password"));
		to.setWip(request.getRemoteAddr());

		int flag = dao.boardWriteOk(to);

		modelAndView.addObject("flag", flag);
		modelAndView.addObject("cpage", request.getParameter("cpage"));

		return modelAndView;
	}

	@RequestMapping("/modify.do")
	public ModelAndView modify(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));
		to = dao.boardModify(to);

		modelAndView.addObject("to", to);
		modelAndView.addObject("cpage", request.getParameter("cpage"));

		return modelAndView;
	}

	@RequestMapping("modify_ok.do")
	public ModelAndView modify_ok(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1_ok");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		SimpleBoard01TO to = new SimpleBoard01TO();

		String seq = request.getParameter("seq");

		to.setSubject(request.getParameter("subject"));
		if (request.getParameter("mail1").equals("") || request.getParameter("mail2").equals("")) {
			to.setMail("");
		} else {
			to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		}
		to.setContent(request.getParameter("content"));
		to.setSeq(seq);
		to.setPassword(request.getParameter("password"));

		int flag = dao.boardModifyOk(to);

		modelAndView.addObject("flag", flag);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("cpage", request.getParameter("cpage"));

		return modelAndView;
	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));

		to = dao.boardDelete(to);

		modelAndView.addObject("to", to);
		modelAndView.addObject("cpage", request.getParameter("cpage"));

		return modelAndView;
	}

	@RequestMapping("/delete_ok.do")
	public ModelAndView delete_ok(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1_ok");

		SimpleBoard01DAO dao = new SimpleBoard01DAO();
		SimpleBoard01TO to = new SimpleBoard01TO();

		to.setSeq(request.getParameter("seq"));
		to.setPassword(request.getParameter("password"));

		int flag = dao.boardDeleteOk(to);

		modelAndView.addObject("flag", flag);
		modelAndView.addObject("cpage", request.getParameter("cpage"));

		return modelAndView;
	}
}
