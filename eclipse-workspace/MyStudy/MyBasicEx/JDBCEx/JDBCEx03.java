package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx03 {

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
		// java.sql의 Statement. 일반적으로 stm으로 이름을 붙인다.
		Statement stmt = null;

		try {

			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			stmt = conn.createStatement();

			String deptno = "70";
			String dname = "연구부";
			String loc = "울산";
			
//			int result = stmt.executeUpdate("insert into dept value (" + deptno + ", '" + dname + "', '" + loc + "')");
			String sql = String.format("insert into dept values (%s, '%s', '%s')", deptno, dname, loc);
			int result = stmt.executeUpdate(sql);
			System.out.println("입력 성공 : " + result);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		} finally { if (conn != null) try { conn.close(); } catch (SQLException e) { }
					if (stmt != null) try { stmt.close(); } catch (SQLException e) { }
		}
	}

}
