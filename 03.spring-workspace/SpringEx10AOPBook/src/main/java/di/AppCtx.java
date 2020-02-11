package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.Calculator;
import spring.ExeTimeAspect;
import spring.ImpeCalculator;
import spring.RecCalculator;

// DI 빈 객체 생성
@Configuration
@EnableAspectJAutoProxy
public class AppCtx {

	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	@Bean
	public Calculator recCalculator() {
		return new RecCalculator();
	}
	
	@Bean
	public Calculator impeCalculator() {
		return new ImpeCalculator();
	}
}
