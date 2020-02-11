package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aop.LogginAdvice01;
import spring.WriteAction;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeanConfig {

	/*	
	<bean id="action" class="spring.WriteAction">
		<property name="writer">
			<value>박문수</value>
		</property>
	</bean>

	<!-- 어노테이션으로 적용한 AOP 객체 생성 -->
	<bean id="logginAdvice" class="aop.LogginAdvice01" />

	<aop:aspectj-autoproxy />
	context.xml에서의 부분(= DI)을 여기서 어노테이션을 이용하여 만들어준다.
	*/

	@Bean
	public WriteAction action() {
		WriteAction action = new WriteAction();
		action.setWriter("박문수");
		return action;
	}

	@Bean
	public LogginAdvice01 basicAdvice() {
		return new LogginAdvice01();
	}
}
