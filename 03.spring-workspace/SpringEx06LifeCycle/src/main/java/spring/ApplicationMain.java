package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
		// xml
		// GenericXmlApplicationContext ctx = new
		// GenericXmlApplicationContext("classpath:spring/context.xml");

		// WriteAction action = ctx.getBean("action", WriteAction.class);

		// annotation
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		WriteAction action = ctx.getBean("writeAction", WriteAction.class);
		action.execute();

		ctx.close();
	}
}
