package model2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model1.BoardDAO;

public class ApplicationMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:model2/context.xml");
		ListAction listAction = ctx.getBean("listAction", ListAction.class);
		
		listAction.execute();
		
		// 어노테이션 방식
		AnnotationConfigApplicationContext ctxA = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		BoardAction listActionA = ctxA.getBean("listAll", BoardAction.class) ;
		listActionA.execute();
		
		ctx.close();
		ctxA.close();
	}
}
