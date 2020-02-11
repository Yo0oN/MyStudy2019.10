import org.springframework.context.support.GenericXmlApplicationContext;

import spring.Action;

public class ApplicationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:context.xml");
		Action action = (Action) ctx.getBean("action");

		action.execute();

		ctx.close();
	}
}
