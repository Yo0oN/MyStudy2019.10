package JDBCEx;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mariadb://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			// MetaData : 속성정보. 다른 데이터를 설명해 주는 데이터
			// 현재 연결중인 DBMS에 관한 정보를 알려준다.
			DatabaseMetaData dmd = conn.getMetaData();

			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDatabaseProductVersion());

			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());

			System.out.println(dmd.getURL());
			System.out.println(dmd.getUserName());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
