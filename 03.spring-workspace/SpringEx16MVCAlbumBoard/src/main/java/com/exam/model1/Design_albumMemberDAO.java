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

	// 아이디 찾기
	public Design_albumMemberTO searchId(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		try {
			conn = dataSource.getConnection();
			// 이름, 메일 확인
			String sql = "select name, id from login where name=? and mail=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getName());
			pstmt.setString(2, to.getMail1() + "@" + to.getMail2());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = 0;
				to.setFlag(flag);
				to.setName(rs.getString("name"));
				to.setId(rs.getString("id"));
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
		return to;
	}

	// 비밀번호 찾기
	public int searchPassword(Design_albumMemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		try {
			conn = dataSource.getConnection();
			// id, 메일 확인
			String sql = "select idno from login where id=? and mail=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getId());
			pstmt.setString(2, to.getMail1() + "@" + to.getMail2());

			rs = pstmt.executeQuery();
			// 결과가 있다면 임시비밀번호 발급
			if (rs.next()) {
				Random r = new Random();

				String p1 = String.format("%c%d%c%d%c%d", (r.nextInt(25) + 97), r.nextInt(50), (r.nextInt(25) + 97),
						r.nextInt(50), (r.nextInt(25) + 97), r.nextInt(50));

				sql = "update login set password=? where id=? and mail=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, p1);
				pstmt.setString(2, to.getId());
				pstmt.setString(3, to.getMail1() + "@" + to.getMail2());

				int result = pstmt.executeUpdate();

				if (result == 1) {
					// 비밀번호변경성공시0, 아니면 그대로2
					flag = 0;
					// 메일 보내주기
					MailSender mailSender = new MailSender();
					mailSender.setChangePassword(p1);
					mailSender.sendMail(to.getMail1() + "@" + to.getMail2(), to.getName());
				}
			} else {
				// 결과가 없다면 해당 아이디, 메일에 맞는 것이 없음
				flag = 1;
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
}
