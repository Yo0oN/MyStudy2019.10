import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.BeanConfig;
import spring.Action;

public class ApplicationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// GenericXmlApplicationContext ctx = new
		// GenericXmlApplicationContext("classpath:context.xml");

		// 어노테이션으로 작성
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

		Action action = (Action) ctx.getBean("action");

		action.execute();

		ctx.close();
	}
}
