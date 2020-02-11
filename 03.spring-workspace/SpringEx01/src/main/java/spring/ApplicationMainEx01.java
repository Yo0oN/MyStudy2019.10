package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMainEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");

		Hello helloSpring01 = (Hello) ctx.getBean("helloSpring01");
		helloSpring01.sayHello("김춘배");

		Hello helloSpring02 = (Hello) ctx.getBean("helloSpring02");
		helloSpring02.sayHello("김냥냥");

		// Hello hello03_01 = (Hello) ctx.getBean("helloSpring03_01");

		// HelloSpringEx03은 1,2와는 다르게 implements가아닌 그냥 만들었음
		HelloSpringEx03 hello03_02 = (HelloSpringEx03) ctx.getBean("helloSpring03_02");
		hello03_02.sayHello();

		ctx.close();
	}
}
