package com.exam.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class HomeController {

	@RequestMapping("/write.do")
	private String handleRequest1() {
		System.out.println("handleRequest1 write 호출");
		return "write";
	}

	@RequestMapping("/write_ok.do")
	private String handleRequest2() {
		System.out.println("handleRequest2 write_ok 호출");
		return "write_ok";
	}
}
