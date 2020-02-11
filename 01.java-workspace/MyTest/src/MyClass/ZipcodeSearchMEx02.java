package MyClass;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ZipcodeSearchMEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// zipcode의 내용을 DB에서 불러온 후 scanner로 입력하면 동이름일부를 입력하면 [우편번호] 시도 구군 동 리 가 나오게 작성하라

		// 스캐너로 열기
		Scanner sc = new Scanner(System.in);
		// URL ID 암호
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// DBMS 접속함
			Class.forName("org.mariadb.jdbc.Driver");
			// 커넥션OK
			conn = DriverManager.getConnection(url, user, password);
			// Statement 생성완료
			stmt = conn.createStatement();
			// 안내문구
			System.out.print("동을 입력하세요 : ");
			// 동입력받아 쿼리에 넣기
			String sql = String.format("select zipcode, sido, gugun, dong, ri from zipcode where dong like '%%%s%%'",
					sc.next());
			// DBMS에 명령하기
			rs = stmt.executeQuery(sql);
			// 읽어오기
			while (rs.next()) {
				System.out.printf("[%s] %3s %4s %5s %10s%n", rs.getString("zipcode"), rs.getString("sido"),
						rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외1] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외2] : " + e.getMessage());
		} finally { sc.close();
			if (stmt != null) { try { stmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
			if (rs != null) { try { rs.close(); } catch (SQLException e) { } }
		}
		
		System.out.println("끝");
	}
}
