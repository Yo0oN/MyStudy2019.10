package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mariadb://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

//			// 값에 해당하는것에만 사용 가능. ?를 사용하여 자리만 지정하고, 당장 값을 넣지않는다.
//			String sql = "insert into dept values(?, ?, ?)";
//
//			pstmt = conn.prepareStatement(sql);
//
//			//위에서 자리만 정하고 값을 넣지 않은것에 값을 넣어준다.
//			pstmt.setString(1, "97");
//			pstmt.setString(2, "기획부");
//			pstmt.setString(3, "강릉");
//			
//			String sql = "update dept set loc=? where deptno=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "여수");
//			pstmt.setString(2, "97");
			// 97번 부서를 지우고 싶을 때.
			
//			String sql = "delete from dept where deptno=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "97");
			String sql = "delete from dept where deptno between ? and ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "50");
			pstmt.setString(2, "1000");
			int result = pstmt.executeUpdate();
			System.out.println("실행완료 " + result);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
