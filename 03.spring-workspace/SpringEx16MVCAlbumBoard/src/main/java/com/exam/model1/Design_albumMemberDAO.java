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
					sql = "insert into login value(0, ?, ?, ?, ?, 0)";

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

	// 로그인
	public int[] logIn(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int[] flag_idno = new int[2];
		flag_idno[0] = 3;
		try {
			conn = dataSource.getConnection();
			// id 확인
			String sql = "select idno from login where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getId());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// 비밀번호 확인
				sql = "select idno from login where id=? and password=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, to.getId());
				pstmt.setString(2, to.getLoginPassword());
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					// 방문횟수 증가
					int idno = rs.getInt("idno");
					sql = "update login set visit=visit+1 where idno=?";
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, idno);
					rs = pstmt.executeQuery();
					
					flag_idno[0] = 0;
					flag_idno[1] = idno;					 
				} else {
					flag_idno[0] = 1;
				}
				
			} else {
				flag_idno[0] = 2;
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

		return flag_idno;
	}

	public void logOut() {

	}

	public void findId() {

	}

	public void findPassword() {

	}
}
