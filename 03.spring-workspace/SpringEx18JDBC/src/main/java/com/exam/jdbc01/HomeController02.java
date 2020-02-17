package com.exam.jdbc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController02 {
	@Autowired
	private TestMapper testMapper;

	@RequestMapping("/jdbc02.do")
	public String jdbc02() {
		String result = testMapper.selectNow();
		System.out.println(result);
		return "jdbc02";
	}
}
