import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result;
	private boolean next;
	private String results;

	public OutDAO() {
		// DB 접속
		String url = "jdbc:mysql://192.168.0.23:3306/account_book";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String checkPassword(int m_num) {
		try {
			String sql = "select m_password from Member_info where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("m_password");
			}
		} catch (SQLException e) {
		} finally {
			if (rs != null) { try { rs.close(); } catch (SQLException e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}
		return results;
	}

	public void deleteData(int m_num) {
		try {
			String sql = "delete from Use_Money where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			result = pstmt.executeUpdate();
			
			sql = "delete from Get_Money where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			result = pstmt.executeUpdate();
			
			sql = "delete from Member_info where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if (rs != null) { try { rs.close(); } catch (SQLException e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}
	}
}
