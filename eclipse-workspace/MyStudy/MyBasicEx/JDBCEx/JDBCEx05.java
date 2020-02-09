package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 접속 경로는 DBMS 종류마다 다르다.
		String url = "jdbc:mysql://192.168.0.4:3306/employees"; //접속경로
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
		int result = 0;
		
		try {
//			드라이버명은 DBMS마다 다르다.
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			String sql = String.format("insert into dept values(%s, '%s', '%s')",
					"70", "연구부", "울산");
//			String sql = String.format("delete from dept where deptno=%s", 80);
			result = stmt.executeUpdate(sql);
			
			System.out.println("실행완료 : " + result);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외] : " + e.getMessage());
		} finally {
			if (stmt != null) {try { stmt.close(); } catch (SQLException e) {}}
			if (conn != null) {try { conn.close(); } catch (SQLException e) {}}
		}
	}

}
