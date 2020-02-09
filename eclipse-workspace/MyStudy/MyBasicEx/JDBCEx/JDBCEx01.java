package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 드라이버 로딩
		// 2. 데이터베이스와 연결
		// 연결을 위해 필요한것 -> 연결url, id/password
		// java.sql.*
		System.out.println("시작");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		}

		// 아래 문장은 외워야함
		String url = "jdbc:mysql://localhost:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;

		try {
			System.out.println("연결 성공");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}

		System.out.println("끝");
	}

}
