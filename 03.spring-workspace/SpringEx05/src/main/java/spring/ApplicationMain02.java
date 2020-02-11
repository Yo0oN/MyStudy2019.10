package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.BeanConfig;

public class ApplicationMain02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BoardTO to = new BoardTO();
		// to.setSeq(1);
		// to.setSubject("제목1");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);

		BoardTO to = ctx.getBean("boardTO", BoardTO.class);
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
	}
}
