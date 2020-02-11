package network;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx04 {

	public static void main(String[] args) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			// 인터넷상의 사진을 연결함
			URL url = new URL("https://ssl.pstatic.net/tveta/libs/1267/1267505/fc8d7abd3752fdd15c0b_20191129142759196.jpg");
			URLConnection conn = url.openConnection();
			// 읽어옴
			bis = new BufferedInputStream(conn.getInputStream());
			// 읽은것을 저장함
			bos = new BufferedOutputStream(new FileOutputStream("./down.jpg"));

			int data = 0;
			while ((data = bis.read()) != -1) {
				bos.write(data);
			}
			System.out.println("전송완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {try {bis.close();} catch (IOException e) {}}
			if (bos != null) {try {bos.close();} catch (IOException e) {}}
		}
	}

}
