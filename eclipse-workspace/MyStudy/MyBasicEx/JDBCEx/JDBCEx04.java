package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 접속 경로는 DBMS 종류마다 다르다.
		// 마지막에 붙은 employees위치에 들어가고싶은 데이터베이스 이름을 적는다.
		String url = "jdbc:mysql://192.168.0.4:3306/employees";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		
		Statement stmt = null;
		
		int result = 0;
		
		try {
			// 드라이버명은 DBMS마다 다르다.
			// DBMS에 연결하여 로그인해주기.
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
						
//			String sql = String.format("create table %s (col1 varchar(10), col2 varchar(10))",
//					"testtbl");
			
			String sql = String.format("drop table %s", "testtbl");
			
			// 문자열을 넣어주어 DB에서 실행하기
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
