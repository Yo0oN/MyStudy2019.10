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
		MailSender mailSender = new MailSender();
		String[] flag_confirmNumber = mailSender.sendMail(useremail);
		
		String flag = "";
		
		// 메일이 성공적으로 보내졌다면 flag == 인증번호 아니라면 1,2,3중 하나가 간다.
		if (flag_confirmNumber[0] == "0" || flag_confirmNumber[0].equals("0")) {
			flag =flag_confirmNumber[1].trim();
		} else {
			flag = "1";
		}
		
		System.out.println(flag);
		
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
	
	@RequestMapping("/join_used_mail.mysql")
	public ModelAndView joinUsedMail(HttpServletRequest request) {
		System.out.println("join_used_mail 컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/join_used_mail");
		
		String useremail = request.getParameter("useremail");
		
		int flag = new LoginDAO().joinUsedMail(useremail);
		
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
	
	@RequestMapping("/join_id_confirm.mysql")
	public ModelAndView joinIDConfirm(HttpServletRequest request) {
		System.out.println("join_id_confirm 컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login/join_id_confirm");
		
		String userid = request.getParameter("userid");
		
		int flag = new LoginDAO().LoginIDConfirm(userid);
		
		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
}
