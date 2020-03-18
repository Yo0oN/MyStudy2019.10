package HashMapEx;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.setProperty("timeout", "30");
		props.setProperty("language", "kr");
		props.setProperty("size", "10");
		
		System.out.println(props.getProperty("size"));
		System.out.println(props.getProperty("language"));
		//key값만 가져올수도있다.
		Enumeration e = props.propertyNames();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
