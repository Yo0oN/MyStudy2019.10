package HashMapEx;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System 클래스 환경정보
		Properties props = System.getProperties();
		Enumeration e = props.propertyNames();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			System.out.print(key);
			System.out.println(" : " + props.getProperty(key));
		}
	}
}
