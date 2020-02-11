package SwingZipCodeSearchEx01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipSearchEx03DAO {
	// ZipSearchEx03에서 호출만하여 사용하게 해준다.
	private Connection conn;

	public ZipSearchEx03DAO() {
		// 데이터 베이스 접속 설정
		String url = "jdbc:mysql://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("[에러] : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		}
	}

	// 나중에는 ArrayList<String> 또는 ArrayList<XXXTO>로 만들어보자.

	public StringBuffer searchZip(String strDong) {
		// 우편번호 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer result = new StringBuffer();
		try {
			String sql = "select * from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + strDong + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String zipcode = rs.getString("zipcode");
				String sido = rs.getString("sido");
				String gugun = rs.getString("gugun");
				String dong = rs.getString("dong");
				String ri = rs.getString("ri");
				String bunji = rs.getString("bunji");

				String address = String.format("[%s] %s %s %s %s %s%n", zipcode, sido, gugun, dong, ri, bunji);

				result.append(address);
			}
		} catch (SQLException e) {
			System.out.println("[에러1] : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		}
		return result;
	}

}
