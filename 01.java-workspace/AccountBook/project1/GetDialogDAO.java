import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class GetDialogDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;

	public GetDialogDAO() {
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

	public int setGetDialog(int m_num, String date, String bigWhere, String smallWhere, String getMoney) {
		try {
			String sql = "insert into get_money values(?, ?, ?, ?, ?, '')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, date);
			pstmt.setString(3, bigWhere);
			pstmt.setString(4, smallWhere);
			pstmt.setString(5, getMoney);
			result = pstmt.executeUpdate();

			sql = "update Member_info set m_money = m_money + ?, m_getmoney = m_getmoney + ? where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, getMoney + "");
			pstmt.setString(2, getMoney);
			pstmt.setString(3, m_num + "");
			pstmt.executeUpdate();
		} catch (SQLException e) {
		} catch (NumberFormatException e) {
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}
		return result;
	}
}
