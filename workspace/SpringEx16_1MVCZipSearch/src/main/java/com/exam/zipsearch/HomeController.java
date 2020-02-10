package com.exam.zipsearch;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model1.ZipcodeDAO;
import model1.ZipcodeTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping("/zipSearch.do")
	public String zipSearch(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("zipSearch 호출");

		if (request.getParameter("dong") != null && !request.getParameter("dong").equals("")) {
			ZipcodeDAO dao = new ZipcodeDAO();
			ArrayList<ZipcodeTO> dongLists = dao.searchDong(request.getParameter("dong"));

			request.setAttribute("dongLists", dongLists);
		}

		return "zipSearch";
	}
}
