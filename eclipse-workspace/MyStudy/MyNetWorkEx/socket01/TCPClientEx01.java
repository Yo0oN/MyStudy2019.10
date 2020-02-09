package socket01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		
		try {
			System.out.println("서버와 연결 중입니다.");
			// 어떤 컴퓨터의 어떤포트에 접속하는지 설정해줌
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결 되었습니다.");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) try {socket.close();} catch(IOException e) {}
		}
	}

}
