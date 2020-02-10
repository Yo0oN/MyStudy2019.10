package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {
	@RequestMapping("/write.do")
	public ModelAndView Write() {
		System.out.println("Write 호출");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write");
		return modelAndView;
	}

	// @RequestMapping(value="/write_ok.do", method=RequestMethod.GET)
	// public ModelAndView Write_ok_GET() {
	// System.out.println("Write_ok GET 호출");
	// ModelAndView modelAndView = new ModelAndView();
	//
	// modelAndView.setViewName("write_ok");
	//
	// modelAndView.addObject("data");
	//
	// return modelAndView;
	// }
	//
	// @RequestMapping(value="/write_ok.do", method=RequestMethod.POST)
	// public ModelAndView Write_ok_POST() {
	// System.out.println("Write_ok POST 호출");
	// ModelAndView modelAndView = new ModelAndView();
	//
	// modelAndView.setViewName("write_ok");
	//
	// modelAndView.addObject("data");
	//
	// return modelAndView;
	// }

	// 이렇게 들어오는데이터를 다른 변수에 담아서 사용할 경우, 다른 처리를 추가로 해줄 수 있다.
	// @RequestMapping("write_ok.do")
	// public ModelAndView Write_ok(@RequestParam("data") String pdata) {
	// System.out.println("Write_ok 호출 : " + pdata);
	// ModelAndView modelAndView = new ModelAndView();
	//
	// modelAndView.setViewName("write_ok");
	//
	// modelAndView.addObject("data", pdata);
	//
	// return modelAndView;
	// }
	
	// @RequestMapping("write_ok.do")
	// public String Write_ok(HttpServletRequest request, HttpServletResponse
	// response) {
	//
	// System.out.println("Write_ok 호출 : " + request.getParameter("data"));
	// request.setAttribute("data", request.getParameter("data"));
	//
	// return "write_ok";
	// }
	
	@RequestMapping("write_ok.do")
	public String Write_ok(@RequestParam("data") String pdata, Model model) {
		System.out.println("Write_ok 호출 : " + pdata);
		model.addAttribute("data", pdata);
		return "write_ok";
	}
}
