package socket02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedReader br = null;
		
		try {
			System.out.println("서버와 연결 중입니다.");
			// 어떤 컴퓨터의 어떤포트에 접속하는지 설정해줌
			// 소켓을 생성하면 해당 포트를 가진 소켓에 연결된다.
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결 되었습니다.");
			// 서버가 전송한 데이터를 읽어옴.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("메세지 : " + br.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch(IOException e) {}
			if (socket != null) try {socket.close();} catch(IOException e) {}
		}
	}
}
