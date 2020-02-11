package gugudan;

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
			socket = new Socket("localhost", 7777);
			System.out.println("서버 연결완료");

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 서버에 데이터 보내기

			String startDan = "1";
			String endDan = "2";

			bw.write(startDan + "\n");
			bw.write(endDan + "\n");
			bw.flush();
			System.out.println("전송 완료");
			System.out.println();

			// 서버한테 데이터 받기
			String msg = null;
			while ((msg = br.readLine()) != null) {
				System.out.println(msg);
			}
			System.out.println("받기 완료");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
			System.out.println("서버연결 종료");
		}
	}
}
