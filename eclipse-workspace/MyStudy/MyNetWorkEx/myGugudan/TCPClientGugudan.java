package myGugudan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClientGugudan {

	public static void main(String[] args) {
		// 서버에게 시작단/끝단을 준 후 다시 단/단/단으로 구구단을 받자.
		Socket socket = null;
		BufferedWriter bw = null;
		BufferedReader br = null;
		
		try {
			// 소켓만들어서 서버 연결완료
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버 연결완료");

			// 서버에 데이터 보내기
			int start = 3;
			int end = 5;
			String dan = start + "/" + end + "\n";
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			bw.write(dan);
			bw.flush();
			System.out.println("시작단 : " + start + " / 끝단 : " + end + " 전송 완료");
			System.out.println();
			
			// 서버한테 데이터 받기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String gugudan = br.readLine();
			String[] gugu = gugudan.split("/");
			
			System.out.println("구구단시작");
			for (int i = 0; i < gugu.length; i++) {
				System.out.println(gugu[i]);
			}
			System.out.println("구구단 완료.");
			
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
