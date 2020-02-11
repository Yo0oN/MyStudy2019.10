package socket04;

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
		BufferedWriter bw = null;
		
		try {
			// ServerSocket 생성하면서 포트번호를 줘야함
			// 서버소켓을 만들어 클라이언트가 오기를 기다린다.
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");
			// 클라이언트를 받는다.
			socket = serverSocket.accept();
			System.out.println("클라이언트와 연결되었습니다.");
			
			// 클라이언트가 연결되면 데이터를 받기위해 객체생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			// 데이터를 보낸기위해 객체 생성
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			
			// 데이터를 받아서 읽는다.
			String msg = br.readLine();
			System.out.println("전송받은 메세지 : " + msg);

			System.out.println("받기 완료");
			
			// 데이터를 보낸다.
			bw.write(msg + "\n");
			// 글을 다 쓰고 더 이상 출력할 데이터가 없다면
			// 마지막으로 flush()메소드를 호출하여 잔류한 모든 데이터가 출력되도록 해야한다.
			bw.flush();
			System.out.println("전송완료");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) try {br.close();} catch(IOException e) {}
			if (bw != null) try {bw.close();} catch(IOException e) {}
			if (socket != null) try {socket.close();} catch(IOException e) {}
			if (serverSocket != null) try {serverSocket.close();} catch(IOException e) {}
		}
	}
}
