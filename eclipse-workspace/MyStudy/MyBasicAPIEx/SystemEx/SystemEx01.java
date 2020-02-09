package SystemEx;

public class SystemEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//system클래스에서 하는것들
		String osName = System.getProperty("os.name");	//os.name은 지정된문자열이다.
		System.out.println(osName);
		String userName = System.getProperty("user.name");
		System.out.println(userName);
		String javaVersion = System.getProperty("java.runtime.name");
		System.out.println(javaVersion);
		String systemPath = System.getenv("Path");
		System.out.println(systemPath);
		
	}

}
