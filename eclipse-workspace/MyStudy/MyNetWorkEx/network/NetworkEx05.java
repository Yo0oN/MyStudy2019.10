package network;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class NetworkEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String original = "java 홍길동";
			
			String encodieStr = URLEncoder.encode(original,"utf-8");
			String decodeStr = URLDecoder.decode(encodieStr, "utf-8");

			System.out.println(original);
			System.out.println(encodieStr);
			System.out.println(decodeStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
