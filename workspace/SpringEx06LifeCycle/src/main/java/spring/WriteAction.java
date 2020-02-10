package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WriteAction
		implements Action, ApplicationContextAware, BeanFactoryAware, BeanNameAware, DisposableBean, InitializingBean {
	private String writer;
	private BeanFactory beanFactory;

	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println("1. 빈의 생성자 실행");
	}

	public void setWriter(String writer) {
		this.writer = writer;
		System.out.println("2. setWriter() 실행");
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("execute() 실행");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("7. afterPropertiesSet() 호출 : Property 설정 완료");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("10. destroy() 실행 : 종료");
	}

	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		System.out.println("3. setBeanName(String arg0) 실행 : 빈의 이름 설정");
		System.out.println("--> " + arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// BeanFactory는 bean을 만들어내는곳이다
		System.out.println("4. setBeanFactory(BeanFactory arg0) 실행 : 빈 팩토리");
		this.beanFactory = arg0;
		System.out.println("--> " + beanFactory);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("5. setApplicationContext(ApplicationContext arg0) 실행");
	}

	public void init_method() {
		System.out.println("8. 빈의 사용자 초기화 메소드");
	}
	
	public void destroy_method() {
		System.out.println("11. 빈의 사용자 제거 메소드");
	}
}
