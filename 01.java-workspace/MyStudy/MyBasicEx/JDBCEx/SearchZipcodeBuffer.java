package JDBCEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchZipcodeBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 동을 외부에서 입력받고 DB에서 검색하여 우편번호를 출력해주어라.

		BufferedReader br = null;
		String strDong = null;

		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("동이름 입력 : ");

			strDong = br.readLine();
			System.out.println(strDong);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}

		}

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.createStatement();

			String sql = String.format("select * from zipcode where dong like '%%%s%%'", strDong);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.printf("[%s] %3s %5s %4s %5s%n", rs.getString("zipcode"), rs.getString("sido"),
						rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		}

	}

}
