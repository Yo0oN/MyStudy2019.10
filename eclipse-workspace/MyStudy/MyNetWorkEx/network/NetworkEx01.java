package network;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inetAddress = InetAddress.getByName("www.naver.com");
			// 도메인을 알려준다.
			System.out.println(inetAddress.getHostName());
			// IP를 알려준다.
			System.out.println(inetAddress.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
