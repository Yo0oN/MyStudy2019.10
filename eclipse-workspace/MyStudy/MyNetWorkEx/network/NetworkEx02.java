package network;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String strURL
			= "http://www.javachobo.com:80/sample/hello.html?referer=javachobo#index1";
			// 의미 있는 요소를 분리하는 행위 = parsing
			URL url = new URL(strURL);
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			
			System.out.println(url.getPath());
			
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
