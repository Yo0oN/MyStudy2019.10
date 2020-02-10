package spring;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain02 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context3.xml");
		BoardListTO listTO = ctx.getBean("listTO", BoardListTO.class);

		for (BoardTO to : listTO.getBoardLists()) {
			System.out.println(to.getSeq());
			System.out.println(to.getSubject());
		}
	}
}
