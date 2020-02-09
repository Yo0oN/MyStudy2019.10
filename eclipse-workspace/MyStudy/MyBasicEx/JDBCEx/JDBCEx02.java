package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 드라이버 로딩
		// 2. 데이터베이스와 연결
		// 연결을 위해 필요한것 -> 연결url, id/password
		// java.sql.*
		String url = "jdbc:mysql://localhost:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;

		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { if (conn != null) try { conn.close(); } catch (SQLException e) { }
		}
	}

}
