package spring;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.transaction.BeforeTransaction;

@Configuration
@Scope("singleton")
public class BeanConfig {
	@Bean(initMethod = "init_method", destroyMethod = "destroy_method")
	public WriteAction writeAction() {
		WriteAction writeAction = new WriteAction();
		writeAction.setWriter("Hello Writer");
		return writeAction;
	}
}
