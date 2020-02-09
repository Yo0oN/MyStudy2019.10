package socket03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;

		// 서버에 접속하면 데이터를 넘겨줄것임.
		BufferedWriter bw = null;
		try {
			System.out.println("서버와 연결 중입니다.");
			// 어떤 컴퓨터의 어떤포트에 접속하는지 설정해줌
			// 소켓을 생성하면 해당 포트를 가진 소켓에 연결된다.
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결 되었습니다.");
			
			// 서버에 연결되면 글을 써준다.(전송한다.)
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// 마지막에 엔터까지 입력하면 전송
			bw.write("Hello Server" + "\n");
			System.out.println("전송 완료");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) try {bw.close();} catch(IOException e) {}
			if (socket != null) try {socket.close();} catch(IOException e) {}
		}
	}
}
