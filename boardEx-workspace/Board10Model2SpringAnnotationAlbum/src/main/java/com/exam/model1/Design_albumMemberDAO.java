package com.exam.model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.ui.ModelMap;

import com.exam.mail01.MailSender;

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
	public int logIn(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 3;
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

					flag = 0;
				} else {
					flag = 1;
				}

			} else {
				flag = 2;
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

		return flag;
	}

	public void logOut() {

	}

	// 아이디 + 비밀번호 찾기
	public int searchInfo(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		try {
			conn = dataSource.getConnection();
			// 이름, 메일 확인
			String sql = "select id, password from login where name=? and mail=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getName());
			pstmt.setString(2, to.getMail1() + "@" + to.getMail2());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = 0;
				// 메일 보내주기
				MailSender mailSender = new MailSender();
				mailSender.setContent(rs.getString("id"), rs.getString("password"));
				mailSender.sendMail(to.getMail1() + "@" + to.getMail2(), to.getName());

			} else {
				flag = 1;
				to.setFlag(flag);
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
		return flag;
	}

	public Design_albumMemberTO memberModify(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Design_albumMemberTO to = new Design_albumMemberTO();

		try {
			conn = dataSource.getConnection();
			// id를 통하여 정보 뽑아오기
			String sql = "select id, mail, name from login where id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				to.setId(rs.getString("id"));
				to.setMail(rs.getString("mail"));
				to.setName(rs.getString("name"));
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
		return to;
	}

	public int memberModify_ok(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();
			// 수정
			String sql = "update login set name=?, mail=?, password=? where id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getName());
			pstmt.setString(2, to.getMail1() + "@" + to.getMail2());
			pstmt.setString(3, to.getLoginPassword());
			pstmt.setString(4, to.getId());

			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
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
		return flag;
	}
}
