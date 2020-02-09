package SwingZipCodeSearchEx01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipSearchEx03DAO2 {
	// ZipSearchEx03에서 호출만하여 사용하게 해준다.
	private Connection conn;

	public ZipSearchEx03DAO2() {
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

	// ArrayList<String>로 받아오자.

	public ArrayList<String> searchZip(String strDong) {
		// 우편번호 검색
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
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

				result.add(address);
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
