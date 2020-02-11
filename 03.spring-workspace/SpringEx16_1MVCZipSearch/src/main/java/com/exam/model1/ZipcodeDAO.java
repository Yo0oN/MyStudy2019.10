package com.exam.model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ZipcodeDAO {
	private DataSource dataSource;

	public ZipcodeDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			System.out.println("error : " + e.getMessage());
		}
	}

	public ArrayList<ZipcodeTO> searchDong(String dong) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<ZipcodeTO> zipLists = new ArrayList<ZipcodeTO>();

		try {
			conn = dataSource.getConnection();

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
				to.setSeq(rs.getString("seq"));

				zipLists.add(to);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		}
		return zipLists;
	}
}
