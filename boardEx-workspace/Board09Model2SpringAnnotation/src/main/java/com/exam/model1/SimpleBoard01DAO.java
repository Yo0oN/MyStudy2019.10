package com.exam.model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SimpleBoard01DAO {
	private DataSource dataSource = null;

	public SimpleBoard01DAO() {
		String resource = "myBatisConfig.xml";

		InputStream is = null;

		try {
			Context initCtx = new InitialContext();

			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("error : " + e.getMessage());
		}

	}

	public void boardWrite() {
	}

	public int boardWriteOk(SimpleBoard01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();

			String sql = "insert into board1 values (0, ?, ?, ?, ?, ?, 0, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSubject());
			pstmt.setString(2, to.getWriter());
			pstmt.setString(3, to.getMail());
			pstmt.setString(4, to.getPassword());
			pstmt.setString(5, to.getContent());
			pstmt.setString(6, to.getWip());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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

	public BoardListTO boardList(BoardListTO listTO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 현재페이지
		int cpage = listTO.getCpage();
		// 한 페이지에 몇개 보이는지? 10개
		int recordPerPage = listTO.getRecordPerPage();
		// 한블럭에 몇개들어가는지? (5개)
		int blockPerPage = listTO.getBlockPerPage();
		// 총 글 수
		int totalRecord = listTO.getTotalRecord();

		try {
			conn = dataSource.getConnection();
			// DB에서 글 수 가져옴
			String sql = "select count('seq') count from board1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			totalRecord = Integer.parseInt(rs.getString("count"));
			listTO.setTotalRecord(totalRecord);

			// 총 페이지 수 설정
			listTO.setTotalPage(((totalRecord - 1) / recordPerPage) + 1);

			// 페이지에서 글이 보이기 시작하는 번호
			int skip = (cpage - 1) * recordPerPage;
			

			// DB에서 페이지에 맞게 글 10개씩 가져옴
			sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board1 order by seq desc limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, skip);
			pstmt.setInt(2, recordPerPage);
			rs = pstmt.executeQuery();

			ArrayList<SimpleBoard01TO> boardLists = new ArrayList<SimpleBoard01TO>();

			while (rs.next()) {
				SimpleBoard01TO to = new SimpleBoard01TO();

				to.setSeq(rs.getString("seq"));
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setWdate(rs.getString("wdate"));
				to.setHit(rs.getString("hit"));
				to.setWgap(rs.getInt("wgap"));

				boardLists.add(to);
			}

			// 한페이지에 보일 글 목록 담기
			listTO.setBoardLists(boardLists);
			// 현재 페이지에서 보일 블럭 시작번호
			listTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
			// 현재 페이지에서 보일 블럭 끝번호
			listTO.setEndBlock(((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage);

			if (listTO.getEndBlock() >= listTO.getTotalPage()) {
				listTO.setEndBlock(listTO.getTotalPage());
			}

		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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
		return listTO;
	}

	public SimpleBoard01TO boardView(SimpleBoard01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String sql = "update board1 set hit=hit+1 where seq = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());

			pstmt.executeUpdate();

			sql = "select seq, subject, writer, mail, wip, wdate, hit, content from board1 where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setMail(rs.getString("mail"));
				to.setWip(rs.getString("wip"));
				to.setWdate(rs.getString("wdate"));
				to.setHit(rs.getString("hit"));
				to.setContent(
						rs.getString("content") == null ? "" : rs.getString("content").replaceAll("\n", "<br />"));
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		return to;
	}

	public SimpleBoard01TO boardModify(SimpleBoard01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String sql = "select subject, writer, mail, content from board1 where seq = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setMail(rs.getString("mail"));
				to.setContent(rs.getString("content"));
			}

		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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
		return to;
	}

	public int boardModifyOk(SimpleBoard01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 2;

		try {
			conn = dataSource.getConnection();

			String sql = "update board1 set subject= ?, mail= ?, content = ? where seq = ? and password = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSubject());
			pstmt.setString(2, to.getMail());
			pstmt.setString(3, to.getContent());
			pstmt.setString(4, to.getSeq());
			pstmt.setString(5, to.getPassword());

			int result = pstmt.executeUpdate();

			if (result == 0) {
				flag = 1;
			} else if (result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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

	public SimpleBoard01TO boardDelete(SimpleBoard01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String sql = "select subject, writer from board1 where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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
		return to;
	}

	public int boardDeleteOk(SimpleBoard01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 2;
		try {
			conn = dataSource.getConnection();

			String sql = "delete from board1 where seq = ? and password = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());
			pstmt.setString(2, to.getPassword());

			int result = pstmt.executeUpdate();

			if (result == 0) {
				flag = 1;
			} else if (result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
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
}
