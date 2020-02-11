package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx06 {

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
			
			String sql = String.format("select empno, ename, sal, sal*12+ifnull(comm,0), hiredate from emp");
			
			
			// 여태동안 했던 executeUpdate대신 Query로 바뀐다.
			// result = stmt.executeUpdate(sql);
			rs = stmt.executeQuery(sql);
			// 커서가첫번째 행의 위에 있기 때문에
			// 꼭 시작할 때 next()를 먼저 한 후
			// 첫번째 행으로 커서를 옮긴 후 읽어주자.
			/*
			rs.next();
			
			// 첫번째 행 읽기
			System.out.println(rs.getString("deptno"));
			System.out.println(rs.getString("dname"));
			System.out.println(rs.getString("loc"));
			
			// 두번째 행 읽기
			// 읽기 전에 꼭 커서를 다음 행으로 옮겨주자.
			rs.next();
			System.out.println(rs.getString("deptno"));
			System.out.println(rs.getString("dname"));
			System.out.println(rs.getString("loc"));
			*/
			while (rs.next()) {
//				System.out.print(rs.getString("deptno"));
//				System.out.print(rs.getString("dname"));
//				System.out.print(rs.getString("loc"));
				System.out.printf("%-10s%-10s%-10s%-10s%-10s",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
