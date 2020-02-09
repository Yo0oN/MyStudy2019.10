package socket03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Server 대기
		
		ServerSocket serverSocket = null;
		Socket socket = null;

		BufferedReader br = null;
		
		try {
			// ServerSocket 생성하면서 포트번호를 줘야함
			// 서버소켓을 만들어 클라이언트가 오기를 기다린다.
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			// 클라이언트를 받는다.
			socket = serverSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
			// 클라이언트가 연결되면 데이터를 받는다
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("메세지 : " + br.readLine());

			System.out.println("받기 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch(IOException e) {}
			if (socket != null) try {socket.close();} catch(IOException e) {}
			if (serverSocket != null) try {serverSocket.close();} catch(IOException e) {}
		}
	}
}
