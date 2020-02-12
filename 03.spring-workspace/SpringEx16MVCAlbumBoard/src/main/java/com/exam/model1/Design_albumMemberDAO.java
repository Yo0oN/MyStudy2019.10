package com.exam.model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Design_albumMemberDAO {
	private DataSource dataSource;

	public Design_albumMemberDAO() {
		// DB 연결

		try {
			Context initCtx = new InitialContext();

			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			System.out.println("error : " + e.getMessage());
		}
	}

	// 회원가입
	public int join(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 3;
		try {
			conn = dataSource.getConnection();

			// 아이디 중복 확인
			String sql = "select id from login where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = 2;
				return flag;
			} else {
				// 이메일 중복 확인
				sql = "select mail from login where mail = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, to.getMail());
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					flag = 1;
					return flag;
				} else {
					sql = "insert into login value(0, ?, ?, ?, ?)";

					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, to.getId());
					pstmt.setString(2, to.getLoginPassword());
					pstmt.setString(3, to.getName());
					pstmt.setString(4, to.getMail());

					int result = pstmt.executeUpdate();

					if (result == 1) {
						flag = 0;
						return 0;
					}
				}
			}

		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
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
		return flag;
	}

	public void logIn() {

	}

	public void logOut() {

	}

	public void findId() {

	}

	public void findPassword() {

	}
}
