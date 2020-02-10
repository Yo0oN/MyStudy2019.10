package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteOKAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// request.setCharacterEncoding("utf-8"); -> filter를 사용하여 다국어처리해주자
		
		System.out.println("WriteOKAction 호출");
		
		System.out.println("data : " + request.getParameter("data") + " / " + request.getMethod() + "방식");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write_ok");
		
		// View페이지=write_ok.jsp 로 데이터 전송
		// request.setAttribute("data", request.getParameter("data"));
		// 위와 같은 표현
		modelAndView.addObject("data", request.getParameter("data"));

		return modelAndView;
	}
}
