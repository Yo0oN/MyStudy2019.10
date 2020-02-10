package model1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	private Connection conn;

	public BoardDAO() {
		// TODO Auto-generated constructor stub
		String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("error : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		}

	}

	public void boardList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from board1 limit 0, 5";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String data = String.format("%s [%s] %s",
						rs.getString("seq"), rs.getString("writer"), rs.getString("subject"));
				System.out.println(data);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
