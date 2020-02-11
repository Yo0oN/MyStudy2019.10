package networkZipcodeSearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TCPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		BufferedWriter bw = null;
		BufferedReader br = null;

		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			// port 설정
			serverSocket = new ServerSocket(7777);

			while (true) {
				try {
					System.out.println("서버가 준비되었습니다.");
					// client 연결
					socket = serverSocket.accept();
					System.out.println("클라이언트와 연결되었습니다.");

					bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
					br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

					// 동이름 받아옴
					String dong = br.readLine();
					System.out.println("입력된 동이름 : " + dong);

					// DB에서 데이터 찾아오기.
					Class.forName("org.mariadb.jdbc.Driver");
					// DB 연결 완료
					conn = DriverManager.getConnection(url, user, password);
					// sql
					String sql = String.format(
							"select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like '%%%s%%'", dong);
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();

					// 받아온것 읽기
					StringBuffer sb = new StringBuffer();
					String zipcodeFormat = "[%s] %s %s %s %s %s:";
					
					while (rs.next()) {
						sb.append(String.format(zipcodeFormat, rs.getString("zipcode"), rs.getString("sido"),
								rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"),
								rs.getString("bunji")));
					}
					sb.append("\n");

					// Client에게 넘기기
					bw.write(sb.toString());
					bw.flush();

					System.out.println("클라이언트와 연결이 종료되었습니다.\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (bw != null) {
						try {
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
						}
					}
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
