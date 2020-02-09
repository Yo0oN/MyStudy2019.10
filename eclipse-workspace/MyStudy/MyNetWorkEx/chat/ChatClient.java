package chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class ChatClient {
	public static void main(String args[]) {
// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("USAGE: java ChatClient 대화명");
			System.exit(0);
		}
		try {
			// 채팅 서버에 연결
			Socket socket = new Socket("192.168.0.24", 7777);
			System.out.println("서버에 연결되었습니다.");

			// ClientSender클래스에서 socket과 사용자 아이디(아래에서는 name)를 받는다.
			Thread sender = new Thread(new ClientSender(socket, args[0]));
			Thread receiver = new Thread(new ClientReceiver(socket));
			sender.start();
			receiver.start();
		} catch (ConnectException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class ClientSender extends Thread {
		private Socket socket;
		private DataOutputStream out;
		private String name;

		// socket과 name을 받아와
		public ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// null이 아니면 name(사용자아이디)을 보내준다.
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				if (out != null) {
					out.writeUTF(name);
				}
				// 메세지 입력
				while (out != null) {
					out.writeUTF("[" + name + "]" + br.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (IOException e) {
					}
			}
		}
	}

	// 받는쪽 스레드
	static class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream in;

		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			// 받는쪽에서 계속 데이터를 받아서 화면에 보여짐?
			while (in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
