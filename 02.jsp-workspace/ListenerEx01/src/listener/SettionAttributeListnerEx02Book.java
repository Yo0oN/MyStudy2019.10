package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SettionAttributeListnerEx02Book implements HttpSessionAttributeListener {
	public SettionAttributeListnerEx02Book() {
		System.out.println("SessionAttributesListener 객체 생성");
	}

	public void attributeAdded(HttpSessionBindingEvent e) {
		System.out.println("세션 객체에 속성 추가");
	}
	
	public void attributeRemoved(HttpSessionBindingEvent e) {
		System.out.println("세션 객체에 추가된 속성 삭제");
		}

	public void attributeReplaced(HttpSessionBindingEvent e) {
		System.out.println("세션 객체에 추가된 속성 대체");
	}
}
