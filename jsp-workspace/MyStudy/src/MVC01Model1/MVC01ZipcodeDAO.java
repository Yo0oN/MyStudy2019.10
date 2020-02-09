package MVC01Model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MVC01ZipcodeDAO {
	private DataSource dataSource;

	public MVC01ZipcodeDAO() {
		// TODO Auto-generated constructor stub
		// DB 연결
		try {
			Context initCtx = new InitialContext();

			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			System.out.println("error : " + e.getMessage());
		}
	}

	public ArrayList<MVC01ZipcodeTO> zipcodeList(String strDong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MVC01ZipcodeTO> zipcodeList = new ArrayList<>();

		try {
			conn = dataSource.getConnection();

			String sql = "select * from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + strDong + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MVC01ZipcodeTO to = new MVC01ZipcodeTO();

				to.setSeq(rs.getString("seq"));
				to.setZipcode(rs.getString("zipcode"));
				to.setSido(rs.getString("sido"));
				to.setGugun(rs.getString("gugun"));
				to.setDong(rs.getString("dong"));
				to.setRi(rs.getString("ri"));
				to.setBunji(rs.getString("bunji"));

				zipcodeList.add(to);
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
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return zipcodeList;
	}
}
