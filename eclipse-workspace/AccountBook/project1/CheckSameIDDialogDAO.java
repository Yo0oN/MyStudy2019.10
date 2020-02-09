import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckSameIDDialogDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private boolean next;

	public CheckSameIDDialogDAO() {
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
	
	public boolean checkID(String m_ID) {
		try {
			String sql = "select m_ID from Member_info where m_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_ID);
			rs = pstmt.executeQuery();
			next = rs.next();
		} catch (SQLException e) {
		} finally {
			if (rs != null) { try { rs.close(); } catch (SQLException e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}
		return next;
	}
}
