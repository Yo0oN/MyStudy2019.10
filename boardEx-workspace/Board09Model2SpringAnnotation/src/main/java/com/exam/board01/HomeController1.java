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
public class HomeController1 {
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

}
