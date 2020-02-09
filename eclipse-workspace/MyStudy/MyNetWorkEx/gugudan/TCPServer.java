package gugudan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
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
					// 클라이언트 연결 알림과 동시에 연결된곳의 주소를 받아온다.
					System.out.println("클라이언트가 연결되었습니다. : " + socket.getInetAddress());

					br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));

					// 클라이언트에게서 오는 데이터 받기
					String startDan = br.readLine();
					String endDan = br.readLine();

					String line = "";

					// 구구단
					for (int dan = Integer.parseInt(startDan); dan <= Integer.parseInt(endDan); dan++) {
						for (int i = 1; i <= 9; i++) {
							line += dan + " X " + i + " = " + (dan * i) + "\t";
						}
						line += "\n";
					}

					// 클라이언트에게 다시 보내기
					bw.write(line);
					bw.flush();

					System.out.println("전송 완료");
					System.out.println();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
