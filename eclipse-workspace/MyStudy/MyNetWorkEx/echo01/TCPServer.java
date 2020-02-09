package echo01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			// 서버소켓 객체생성하여 서버 열기
			serverSocket = new ServerSocket(7777);
			
			// 서버를 계속 열고 클라이언트와의 연결이 끊기지 않게 계속 반복
			// 서버를 닫는것은 안에있는것이 끝나야 닫히고 종료된다.
			// 그런데 안에있는 클라이언트연결, 종료고..
			// while에 false가 올일이없으니까 서버는 닫히지 않는다.
			while (true) {
				try {
					System.out.println("서버가 준비되었습니다");
					// 클라이언트 오기 대기중
					socket = serverSocket.accept();
					System.out.println("클라이언트가 연결되었습니다.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (socket != null) {try {socket.close();} catch (IOException e) {}}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {try {serverSocket.close();} catch (IOException e) {}}
		}
	}
}
