package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.BeanConfig;

public class ApplicationMain01 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext(BeanConfig.class);

		HelloAnnotationEx01 helloAnnotationEx01
			= ctx.getBean("hello01", HelloAnnotationEx01.class);

		helloAnnotationEx01.sayHello("홍길동");
		
		ctx.close();
	}
}
