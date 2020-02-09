package chatexit;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class ChatClient
{
	public static void main(String args[])
	{
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("USAGE: java ChatClient 대화명");
			System.exit(0);
		}
		try {
			Socket socket = new Socket("192.168.0.18", 7777); 
			// 클라이언트가 접속원하는 서버포트(클라이언트 포트가 아님 : 클라이언트 포트는 내부에서 남은 포트를 알아서 지정) 
			System.out.println("서버에 연결되었습니다.");
			
			Thread sender = new Thread(new ChatClient().new ClientSender(socket, args[0]));//내부 인스턴스 클래스
			Thread receiver = new Thread(new ClientReceiver(socket));//내부 스테틱 클래스
			sender.start();
			receiver.start();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class ClientSender extends Thread
	{
		private Socket socket;
		private DataOutputStream out;
		private String name;

		public ClientSender(Socket socket, String name)
		{
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run()
		{
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				if (out != null) {
					out.writeUTF(name);
				}
				//메세지 입력
				while (out != null) {
					out.writeUTF("[" + name + "]" + br.readLine());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

				if( br != null ) try { br.close(); } catch( IOException e ) {}
				if( out != null ) try { out.close(); } catch( IOException e ) {}
				
				if( socket != null ) try { socket.close(); } catch( IOException e ) {}
			}
		}
	}

	static class ClientReceiver extends Thread
	{
		private Socket socket;
		private DataInputStream in;

		public ClientReceiver(Socket socket)
		{
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void run()
		{
			while (in != null) {
				try {
					System.out.println(in.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if( in != null ) try { in.close(); } catch( IOException e ) {}
					
					if( socket != null ) try { socket.close(); } catch( IOException e ) {}
				}
			}
		}
	}
}