package com.exam.jdbc01zipsearch;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private TestMapper testMapper;

	@RequestMapping("/zipsearch.do")
	public String zipsearch(HttpServletRequest request) {

		if (request.getParameter("dong") != null) {
			System.out.println(request.getParameter("dong"));
			ZipcodeTO zipcodeTO = testMapper.selectZipcode(request.getParameter("dong"));
			System.out.println(1);
			if (zipcodeTO != null) {
				System.out.println(2);
				System.out.println(zipcodeTO.getZipcode());
			}
			
		}
		return "zipsearch";
	}
}
