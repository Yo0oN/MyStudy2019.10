package com.exam.album01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model1.Design_albumMemberDAO;
import com.exam.model1.Design_albumMemberTO;

@Controller
public class MemberController {

	@RequestMapping("/login_ok.do")
	public ModelAndView member_login1_ok() {
		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName("member_login1_ok");

		return modelAndView;
	}

	@RequestMapping("/search.do")
	public ModelAndView member_search1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_search1");

		return modelAndView;
	}

	// 회원가입
	@RequestMapping("/join.do")
	public ModelAndView member_write1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_write1");

		return modelAndView;
	}

	// 회원가입
	@RequestMapping("/join_ok.do")
	public ModelAndView member_write1_ok(Design_albumMemberTO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_write1_ok");

		String cpage = to.getCpage();

		Design_albumMemberDAO dao = new Design_albumMemberDAO();

		to.setMail(to.getMail1() + "@" + to.getMail2());
		int flag = dao.join(to);

		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
}
