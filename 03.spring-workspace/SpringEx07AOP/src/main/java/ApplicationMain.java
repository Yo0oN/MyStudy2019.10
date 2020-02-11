import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Action;
import spring.WriteAction;

public class ApplicationMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:context.xml");
		// 공통기능을 사용하지 않을 때
		// Action action = ctx.getBean("action", Action.class);

		// 공통기능을 사용할 때. AOP가 적용된것을 호출한다.
		Action action = ctx.getBean("proxy", Action.class);

		action.execute1();

		ctx.close();
	}
}
