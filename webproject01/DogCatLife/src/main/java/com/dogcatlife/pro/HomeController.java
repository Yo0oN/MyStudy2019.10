package com.dogcatlife.pro;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping({"/", "/main.mysql"})
	public ModelAndView main() {
		System.out.println("main 컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	@RequestMapping({"/", "/adoption_board_view.mysql"})
	public ModelAndView adoption_board_view() {
		System.out.println("adoption_board_view 컨트롤러 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adoption_board/adoption_board_view");
		return modelAndView;
	}
}
