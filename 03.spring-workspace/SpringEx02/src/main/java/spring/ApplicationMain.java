package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");

		HelloBean helloBean11 = (HelloBean) ctx.getBean("helloBean01");
		HelloBean helloBean12 = (HelloBean) ctx.getBean("helloBean01");
		// 공유객체(static)
		// 한번 생성 한 후 프로그램 종료시까지 계속 사용
		System.out.println(helloBean11);
		System.out.println(helloBean12);

		HelloBean helloBean21 = (HelloBean) ctx.getBean("helloBean02");
		HelloBean helloBean22 = (HelloBean) ctx.getBean("helloBean02");
		// 필요시마다 계속 객체 생성
		System.out.println(helloBean21);
		System.out.println(helloBean22);

		HelloBean helloBean31 = (HelloBean) ctx.getBean("helloBean03");
		HelloBean helloBean32 = (HelloBean) ctx.getBean("helloBean03");
		// 공유객체(static)
		// 한번 생성 한 후 프로그램 종료시까지 계속 사용
		System.out.println(helloBean31);
		System.out.println(helloBean32);

		ctx.close();
	}
}
