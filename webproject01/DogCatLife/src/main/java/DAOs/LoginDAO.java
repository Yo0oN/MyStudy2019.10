package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import TOs.UserTO;
import mail.MailSender;

public class LoginDAO {
	private DataSource dataSource = null;
	
	public LoginDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource)envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		}
	}
	
	public int joinUsedMail(String useremail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();

			String sql = "select email from user where email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, useremail);
			rs = pstmt.executeQuery();

			// 중복되는 메일확인
			if (!rs.next()) {
				flag = 0;
			}
		} catch(SQLException e) {
			System.out.println("[에러1] : " + e.getMessage());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
	
		System.out.println(flag);
		return flag;
	}
	
	/*
	 * public String LoginMailConfirm(String useremail) { Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * String flag = 3 + ""; try { conn = dataSource.getConnection();
	 * 
	 * String sql = "select email from user where email=?"; pstmt =
	 * conn.prepareStatement(sql); pstmt.setString(1, useremail); rs =
	 * pstmt.executeQuery();
	 * 
	 * // 중복되는 메일이 없다면 인증번호 전송 if (!rs.next()) { MailSender mailSender = new
	 * MailSender(); String[] flag_confirmNumber = mailSender.sendMail(useremail);
	 * 
	 * // 메일이 성공적으로 보내졌다면 flag == 인증번호 아니라면 1,2,3중 하나가 간다. if (flag_confirmNumber[0]
	 * == "0" || flag_confirmNumber[0].equals("0")) { flag
	 * =flag_confirmNumber[1].trim(); } else { flag = "1"; } } else { flag = "2"; }
	 * } catch(SQLException e) { System.out.println("[에러1] : " + e.getMessage()); }
	 * finally { if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
	 * if(conn != null) try { conn.close(); } catch(SQLException e) {} }
	 * 
	 * System.out.println(flag); return flag; }
	 */
	public int LoginIDConfirm(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();

			String sql = "select id from user where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			// 중복되는 id가 없다면 flag == 0
			if (!rs.next()) {
				flag = 0;
			}
		} catch(SQLException e) {
			System.out.println("[에러1] : " + e.getMessage());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
	
		System.out.println(flag);
		return flag;
	}

	public int userJoinOk(UserTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "insert into user values (0,?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getId());
			pstmt.setString(2, to.getNickname());
			pstmt.setString(3, to.getPassword());
			pstmt.setString(4, to.getName());
			pstmt.setString(5, to.getPhone());
			pstmt.setString(6, to.getEmail());
			
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				flag = 0;
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
		}
	
		return flag;
	}
}