package JDBCEx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();

			String sql = "insert into emp values(값,값)";
			stmt.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
