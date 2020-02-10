package di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.BoardTO;
import spring.HelloAnnotationEx01;

// @configuration은 context.xml과 같은 역할을 한다는뜻..
@Configuration
@Scope("singleton")
public class BeanConfig {
	// 어노테이션으로 DI(의존성 주입)사용.
	// @Bean을 사용하면 context.xml에서 사용했던것처럼 빈(객체)를 만들어준다.
	// 메소드명이 context.xml에서의 name 또는 id와 같다.
	@Bean
	public HelloAnnotationEx01 hello01() {
		return new HelloAnnotationEx01();
	}

	// 어노테이션 + setter
	@Bean
	public BoardTO boardTO() {
		BoardTO to = new BoardTO();
		to.setSeq(1);
		to.setSubject("제목1");
		return to;
	}
}
