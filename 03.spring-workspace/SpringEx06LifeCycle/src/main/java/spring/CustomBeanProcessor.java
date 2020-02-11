package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// initialization 후
		System.out.println("9. 초기화 후 빈에 대한 처리");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// initialization 전
		System.out.println("6. 초기화 전 빈에 대한 처리");
		return bean;
	}
}
