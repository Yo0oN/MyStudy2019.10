package com.exam.album01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model1.Design_albumMemberDAO;
import com.exam.model1.Design_albumMemberTO;

@Controller
public class MemberController {

	// 로그인
	@RequestMapping("/login_ok.do")
	public ModelAndView member_login1_ok(Design_albumMemberTO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_login1_ok");

		String id = to.getId();
		Design_albumMemberDAO dao = new Design_albumMemberDAO();
		int flag = dao.logIn(to);

		modelAndView.addObject("flag", flag);
		modelAndView.addObject("id", id);
		
		return modelAndView;
	}

	// 로그아웃
	@RequestMapping("/logout_ok.do")
	public ModelAndView member_logout1_ok(Design_albumMemberTO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_logout1_ok");

		modelAndView.addObject("to", to);
		return modelAndView;
	}

	// 찾기
	@RequestMapping("/search.do")
	public ModelAndView member_search1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_search1");

		return modelAndView;
	}

	// 아이디 + 비밀번호 찾기
	@RequestMapping("/search_ok.do")
	public ModelAndView member_search1_ok(Design_albumMemberTO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_search1_ok");

		Design_albumMemberDAO dao = new Design_albumMemberDAO();
		int flag = dao.searchInfo(to);

		modelAndView.addObject("flag", flag);
		return modelAndView;
	}

	// 찾기 결과
	@RequestMapping("/search_result.do")
	public ModelAndView member_search1_id() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member_search1_result");

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
