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
import TOs.UserTO;
import mail.CreateConfirmNumber;
import mail.MailSender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MypageCotroller {
	@RequestMapping("/input_password.mysql")
	public ModelAndView mypage_input_password() {
		System.out.println("mypage_input_password컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mypage/input_password");
		return modelAndView;
	}
	
	@RequestMapping("/input_password_ok.mysql")
	public ModelAndView mypage_input_password_ok() {
		System.out.println("mypage_input_password_ok컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mypage/input_password_ok");
		return modelAndView;
	}
	@RequestMapping("/myinfo.mysql")
	public ModelAndView myinfo() {
		System.out.println("myinfo 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mypage/myinfo");
		return modelAndView;
	}
	@RequestMapping("/mycomment_list.mysql")
	public ModelAndView mycomment_list() {
		System.out.println("mycomment_list 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mypage/mycomment_list");
		
		return modelAndView;
	}
	@RequestMapping("/mycontents_list.mysql")
	public ModelAndView mycontents_list() {
		System.out.println("mycomment_list 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mypage/mycontents_list");
		
		return modelAndView;
	}
}
