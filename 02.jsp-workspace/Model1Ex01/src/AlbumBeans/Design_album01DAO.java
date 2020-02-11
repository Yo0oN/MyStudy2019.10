package AlbumBeans;

import java.io.EOFException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Design_album01DAO {
	private DataSource dataSource = null;

	public Design_album01DAO() {
		// DB 연결
		try {
			Context initCtx = new InitialContext();

			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			System.out.println("error : " + e.getMessage());
		}
	}

	public ArrayList<Design_album01TO> board_list1(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Design_album01TO> toLists = new ArrayList<Design_album01TO>();
		try {
			conn = dataSource.getConnection();

			String sql = "select seq, subject, writer, date_format(wdate, '%Y.%m.%d') date, hit, filename_ch from album_board1";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				to.setSeq(rs.getString("seq"));
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setWdate(rs.getString("date"));
				to.setHit(rs.getString("hit"));
				to.setFilename_ch(rs.getString("filename_ch"));

				toLists.add(to);
			}
		} catch (SQLException e) {
			System.out.println("error " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
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
		return toLists;
	}

	public void board_view1() {

	}

	public void board_write1() {

	}

	public int board_write1_ok(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			conn = dataSource.getConnection();
			String sql = "insert into album_board1 values(0, ?, ?, ?, ?, ?, ?, ?, 0, ?, now())";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getWriter());
			pstmt.setString(2, to.getSubject());
			pstmt.setString(3, to.getMail());
			pstmt.setString(4, to.getPassword());
			pstmt.setString(5, to.getContent());
			pstmt.setString(6, to.getFilename_ori());
			pstmt.setString(7, to.getFilename_ch());
			pstmt.setString(8, to.getWip());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				flag = 1;
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

	public void board_delete1() {

	}

	public void board_delete1_ok() {

	}

	public void board_modify1() {

	}

	public void board_modify1_ok() {

	}

}
