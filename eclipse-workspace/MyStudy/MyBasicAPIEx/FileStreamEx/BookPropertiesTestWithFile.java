package FileStreamEx;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class BookPropertiesTestWithFile {
	private final static String PROP_FILE_PATH = "./config.properties";
	
	private static void saveToFile() {
		Properties props = new Properties();
		props.setProperty("id", "andy");
		props.setProperty("pass", "1234");
		props.setProperty("addr", "192.168.0.2");
		props.setProperty("이름", "홍길동");
		System.out.println("속성 확인 : " + props);
		try {
			FileWriter output = new FileWriter(PROP_FILE_PATH);
			props.store(output, "System Config");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void loadFromFile() {
		Properties props = new Properties();
		try {
			FileReader input = new FileReader(PROP_FILE_PATH);
			props.load(input);
			Set<String> keys = props.stringPropertyNames();
			for(String key : keys) {
				System.out.println(key + " : " + props.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		saveToFile();
		loadFromFile();
	}
}
