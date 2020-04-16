package com.dogcatlife.pro;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAOs.LoginDAO;
import mail.MailSender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginCotroller {
	
	@RequestMapping("/join.mysql")
	public ModelAndView join() {
		System.out.println("join 컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/join");
		return modelAndView;
	}
	
	@RequestMapping("/join_mail_confirm.mysql")
	public ModelAndView joinMailConfirm(HttpServletRequest request) {
		System.out.println("join_mail_confirm 컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/join_mail_confirm");
		
		String useremail = request.getParameter("useremail");
		
		// 메일 있는지 확인 후 메일보내기
		LoginDAO loginDAO = new LoginDAO();
		String flag = loginDAO.LoginMailConfirm(useremail);
		
		System.out.println(flag);
		
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
}
