package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerEx01 implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// context가 시작할 때 실행
		System.out.println("contextInitialized 호출");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// context가 끝날 때 실행
		System.out.println("contextDestroyed 호출");
	}
}
