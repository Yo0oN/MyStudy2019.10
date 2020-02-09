package echo02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			// 소켓만들어서 서버 연결완료
			socket = new Socket("192.168.0.24", 7777);
			System.out.println("서버 연결완료");
			
			// 서버에 데이터 보내기
			String msg1 = "헬로우~서버~\n";
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			bw.write(msg1);
			bw.flush();
			System.out.println("전송 완료");
			System.out.println();
			
			// 서버한테 데이터 받기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String msg2 = br.readLine();
			System.out.println("메세지 : " + msg2);
			System.out.println("받기 완료");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {try {bw.close();} catch (IOException e) {}}
			if (br != null) {try {br.close();} catch (IOException e) {}}
			if (socket != null) {try {socket.close();} catch (IOException e) {}}
			System.out.println("서버연결 종료");
		}
	}
}
