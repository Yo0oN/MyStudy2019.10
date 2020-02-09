import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChagePasswordDialogDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int resulti;
	private boolean resultr;
	private ChagePasswordDialog cpd;

	public ChagePasswordDialogDAO() {
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


	public int ChagePassword(int m_num, String changePasswordField) {
		try {
			String sql = "update Member_info set m_password = ? where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changePasswordField);
			pstmt.setString(2, m_num + "");
			
			resulti = pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}
		return resulti;
	}

	public boolean CheckPassword(int m_num, String nowPasswordField) {
		try {
			String sql = "select m_num, m_Password from Member_info where m_num = ? and m_Password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, nowPasswordField);
			rs = pstmt.executeQuery();
			
			resultr = rs.next();
		} catch (SQLException e) {
		} finally {
			if (rs != null) { try { rs.close(); } catch (SQLException e) { } }
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}

		return resultr;
	}
}
