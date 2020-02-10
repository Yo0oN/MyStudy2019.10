package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
// 공통경로
@RequestMapping("/board")
public class ConfigController {
	
	@RequestMapping("/write.do")
	public ModelAndView Write() {
		System.out.println("Write 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write");
		return modelAndView;
	}

	@RequestMapping("/write_ok.do")
	public String Write_ok(@RequestParam("data") String pdata, Model model) {
		System.out.println("Write_ok 호출 : " + pdata);
		model.addAttribute("data", pdata);
		return "write_ok";
	}
	
	@GetMapping("/naver.do")
	public String RedirectNaver() {
		System.out.println("RedirectNaver 호출");
		return "redirect:https://www.naver.com";
	}
}
