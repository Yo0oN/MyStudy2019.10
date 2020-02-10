package model1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ZipcodeDAO {
	// src\main\webapp\에 META-INF폴더를 따로 만들어서 DB연결해도된다.
	private Connection conn = null;

	public ZipcodeDAO() {
		// TODO Auto-generated constructor stub
		String url = "jdbc:mariadb://127.0.0.1:3306/employees";
		String user = "root";
		String password = "123456";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("error : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		}
	}

	public ArrayList<ZipcodeTO> search(String dong) {
		ArrayList<ZipcodeTO> toLists = new ArrayList<ZipcodeTO>();

		if (dong != null || !dong.equals("")) {

			ResultSet rs = null;
			PreparedStatement pstmt = null;

			try {
				String sql = "select * from zipcode where dong like ?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, "%" + dong + "%");

				rs = pstmt.executeQuery();

				while (rs.next()) {
					ZipcodeTO to = new ZipcodeTO();

					to.setZipcode(rs.getString("zipcode"));
					to.setSido(rs.getString("sido"));
					to.setGugun(rs.getString("gugun"));
					to.setDong(rs.getString("dong"));
					to.setRi(rs.getString("ri"));
					to.setBunji(rs.getString("bunji"));

					toLists.add(to);
				}
			} catch (SQLException e) {
				System.out.println("error : " + e.getMessage());
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
					}
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
					}
			}
		}
		return toLists;
	}
}
