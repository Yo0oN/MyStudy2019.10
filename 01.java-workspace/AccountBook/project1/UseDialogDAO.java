import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseDialogDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private int result;

	public UseDialogDAO() {
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

	public int setUseDialog(int m_num, String date, String bigWhere, String smallWhere, String useMoney, String card) {
		try {
			// 데이터 넣기
			String sql = "insert into Use_Money values(?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_num + "");
			pstmt.setString(2, date);
			pstmt.setString(3, bigWhere);
			pstmt.setString(4, smallWhere);
			pstmt.setString(5, useMoney);
			pstmt.setString(6, card);
			
			result = pstmt.executeUpdate();
			
			sql = "update Member_info set m_money = m_money - ?, m_usemoney = m_usemoney + ? where m_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, useMoney + "");
			pstmt.setString(2, useMoney);
			pstmt.setString(3, m_num + "");
			pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { } }
		}
		return result;
	}
}
