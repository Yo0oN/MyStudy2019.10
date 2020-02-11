package model1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:model1/context.xml");
		// WriteAction의 객체 호출(기본생성자를 호출하는 writeAction1 객체 호출)
		WriteAction writeAction1 = (WriteAction) ctx.getBean("writeAction1");
		writeAction1.execute();
		// WriteAction의 객체 호출(파라미터를 받는 생성자를 호출하는 writeAction1 객체 호출)
		// 아래는 WriteAction writeAction2 = new WriteAction(new BoardTO());와 같은 뜻이다.
		WriteAction writeAction2 = (WriteAction) ctx.getBean("writeAction2");
		writeAction2.execute();

		WriteAction writeAction3 = (WriteAction) ctx.getBean("writeAction3");
		writeAction3.execute();
	}
}
