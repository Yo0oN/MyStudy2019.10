package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListnerEx01Book implements HttpSessionListener {
	public SessionListnerEx01Book() {
		System.out.println("SessionListnerEx01Book 객체 생성");
	}
	
	public void sessionCreated(HttpSessionEvent e) {
		System.out.println("세션 객체 생성");
	}
	
	public void sessionDestroyed(HttpSessionEvent e) {
		System.out.println("세션 객체 해제 ");
	}
}
