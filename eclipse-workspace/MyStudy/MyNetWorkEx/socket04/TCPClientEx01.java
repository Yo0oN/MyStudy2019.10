package socket04;

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
		BufferedReader br = null;
		try {
			System.out.println("서버와 연결 중입니다.");
			// 어떤 컴퓨터의 어떤포트에 접속하는지 설정해줌
			// 소켓을 생성하면 해당 포트를 가진 소켓에 연결된다.
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결 되었습니다.");
			
			// 서버에게 데이터를 보내기 위해 객체 생성
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			// 서버에서 받기위해 객체 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 마지막에 엔터까지 입력하면 전송
			bw.write("안녕~~" + "\n");
			// 글을 다 쓰고 더 이상 출력할 데이터가 없다면
			// 마지막으로 flush()메소드를 호출하여 잔류한 모든 데이터가 출력되도록 해야한다.
			bw.flush();
			System.out.println("전송 완료");
			
			String msg = br.readLine();
			System.out.println("전송받은 메세지 : " + msg);
			System.out.println("받기 완료");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) try {bw.close();} catch(IOException e) {}
			if (br != null) try {br.close();} catch(IOException e) {}
			if (socket != null) try {socket.close();} catch(IOException e) {}
		}
	}
}
