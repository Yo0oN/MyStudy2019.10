package chatexit;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MyChatServer {
	// 클라이언트 닉네임, OutputStream을 HashMap으로 받아둠
	private HashMap<String, OutputStream> clients;

	public static void main(String args[]) {
		new MyChatServer().start();
	}

	public MyChatServer() {
		clients = new HashMap<String, OutputStream>();
		// Collections.synchronizedMap(clients)
	}

	public void start() {
		// 소켓을 열었음
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			while (true) {
				// 클라이언트와 연결
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + "에서접속하였습니다.");

				// 접속된 클라이언트를 스레드로 따로 빼둠
				ServerReceiver thread = new ServerReceiver(socket);
				// 스레드가 된것을 start메소드로 시작시킴
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 접속중인 클라이언트 전체에게 메세지를 전송하는 메소드
	public void sendToAll(String msg) {
		// 전체 클라이언트의 아이디를 가져오고, 아이디를 통해 hashmap에서 OutputStream을 가져온다.
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 서버 스레드 생성
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream in;
		private DataOutputStream out;

		// 생성자에서 소켓을 받은후
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			// Input Output생성
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void run() {
			// run메소드, 작동시키는곳에서 사용자이름을 받음
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다.");
				
				// 현재 접속한 클라이언트를 HashMap(접속상태)에 등록시킨다. 
				clients.put(name, out);
				
				System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
				while (in != null) {
					sendToAll(in.readUTF());
					if (in.readUTF().contains("exit")) {
						return;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// 클라이언트 접속 종료
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]" + " 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 " + clients.size() + " 입니다.");
			}
		}
	}
}