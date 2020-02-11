package annotationController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController2 {
	@RequestMapping("/list2.do")
	private String handleRequest2() {
		System.out.println("handleRequest2 호출");
		return "listview2";
	}
}
