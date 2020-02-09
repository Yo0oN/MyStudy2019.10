package socket01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Server 대기
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			// ServerSocket 생성하면서 포트번호를 줘야함
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			
			socket = serverSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) try {socket.close();} catch(IOException e) {}
			if (serverSocket != null) try {serverSocket.close();} catch(IOException e) {}
		}
	}
}
