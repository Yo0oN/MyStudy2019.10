package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 접속 경로는 DBMS 종류마다 다르다.
		String url = "jdbc:mysql://192.168.0.4:3306/employees"; //접속경로
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// int result = 0;
			
		try {
			// 드라이버명은 DBMS마다 다르다.
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			stmt = conn.createStatement();
			
			// 사원테이블에서 사원번호, 사원명, 급여, 연봉, 입사일을 출력해보자.
			
			String sql = String.format("select empno , ename, sal, sal*12+ifnull(comm,0) annual, date_format(hiredate, '%%y-%%m-%%d') date from emp");
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				System.out.printf("%-10s%-10s%-10s%-10s%-10s",
						rs.getString("empno"), rs.getString("ename"),
						rs.getString("sal"), rs.getString("annual"), rs.getString("date"));
				System.out.println();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외] : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("[예외] : " + e.getMessage());
		} finally {
			if (stmt != null) {try { stmt.close(); } catch (SQLException e) {}}
			if (conn != null) {try { conn.close(); } catch (SQLException e) {}}
			if (rs != null) {try { rs.close(); } catch (SQLException e) {}}
		}
	}

}
