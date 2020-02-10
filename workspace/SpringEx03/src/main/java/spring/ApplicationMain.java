package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
		// BoardTO to = new BoardTO();
		// to.setSeq(1);
		// to.setSubject("제목"); 아래와 같은말
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");

		// BoardTO to = (BoardTO) ctx.getBean("to"); 아래와 같은말임
		BoardTO to = ctx.getBean("to", BoardTO.class);

		System.out.println(to.getSeq());
		System.out.println(to.getSubject());

		WriteAction writeAction = ctx.getBean("writeAction", WriteAction.class);

		System.out.println(writeAction);
		System.out.println(writeAction.getTo().getSeq());
		System.out.println(writeAction.getTo().getSubject());

		GenericXmlApplicationContext ctx2 = new GenericXmlApplicationContext("classpath:spring/context2.xml");

		BoardTO to2 = ctx2.getBean("to", BoardTO.class);

		System.out.println(to2.getSeq());
		System.out.println(to2.getSubject());

		ctx.close();
	}

}
