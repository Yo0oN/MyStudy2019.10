import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInDialogDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private boolean result;
	private int m_num;

	public LogInDialogDAO() {
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

	public boolean login(String m_ID, String m_pass) {
		try {
			String sql = "select m_num, m_ID, m_password from Member_info where m_ID = ? and m_password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_ID);
			pstmt.setString(2, m_pass);
			rs = pstmt.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int M_num(String m_ID) {
		try {
			String sql = "select m_num from Member_info where m_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_ID);
			rs = pstmt.executeQuery();
			rs.next();
			m_num = Integer.parseInt(rs.getString("m_num"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m_num;
	}
}
