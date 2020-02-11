package annotationController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController1 {
	// list1.do로 요청이 들어오면 listview1.jsp를 보여준다.
	// @RequestMapping("/list1.do")
	// private String handleRequest1() {
	// System.out.println("handleRequest1 호출");
	// return "listview1";
	// }
	// 위와 아래는 같은말
	@RequestMapping("/list1.do")
	private ModelAndView handleRequest1() {
		System.out.println("handleRequest1 호출");
		return new ModelAndView("listview1");
	}
}
