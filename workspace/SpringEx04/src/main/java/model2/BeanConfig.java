package model2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model1.BoardDAO;

@Configuration
public class BeanConfig {

	@Bean
	public BoardDAO boardDAO() {
		return new BoardDAO();
	}

	// name="이름" 객체의 이름을 따로 지정해준다.
	@Bean(name = "listAll")
	public ListAction listAction() {
		// BoardDAO dao = new BoardDAO();
		// return new ListAction(dao);
		// 위에서 빈을 따로 만들지 않고, 이곳에서 생성해서 넣어도 된다.
		return new ListAction(boardDAO());
	}
}
