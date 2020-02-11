package networkZipcodeSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		Scanner sc = new Scanner(System.in);

		BufferedWriter bw = null;
		BufferedReader br = null;

		try {
			// server 연결
			socket = new Socket("localhost", 7777);
			System.out.println("서버와 연결되었습니다.");

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 동이름 보내기
			System.out.print("동을 입력해주세요. ");
			String dong = sc.nextLine();

			bw.write(dong + "\n");
			bw.flush();

			// server에게 우편번호 받기
			String zipcode = br.readLine();
			String[] zip = zipcode.split(":");

			for (String z : zip) {
				System.out.println(z);
			}

			System.out.println("연결 종료");
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
		}

	}

}
