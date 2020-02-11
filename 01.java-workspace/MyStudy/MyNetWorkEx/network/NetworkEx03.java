package network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx03 {

	public static void main(String[] args) {
		// URL을 통하여 연결이 가능하다.
		// openStrema을 사용하기 위하여 InputStream생성
		// InputStream is = null; - 한글은 깨져서 보인다.
		BufferedReader br = null;

		try {
			URL url = new URL("https://m.naver.com");
			
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String data = null;
			while ((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {if (br != null) {try {br.close();} catch (IOException e) {}}
		}
	}

}
