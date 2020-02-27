package ServletModelPagingModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServletPagingBoardDAO {
	private DataSource dataSource = null;

	public ServletPagingBoardDAO() {
		// TODO Auto-generated constructor stub
		// 데이터베이스 커넥션
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource) envCtx.lookup("jdbc/mariadb2");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("[에러] : " + e.getMessage());
		}
	}

	// board_write1.jsp
	public void boardWrite() {
		// 사용하지 않음

	}

	// board_write1_ok.jsp
	public int boardWriteOk(ServletPagingBoardTO to) {
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

	//
	public ServletPagingBoardListTO boardList(ServletPagingBoardListTO listTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 현재페이지
		int cpage = listTO.getCpage();
		// 총 페이지 수
		int recordPerPage = listTO.getRecordPerPage();
		// 한블럭에 몇개들어가는지 (5개)
		int blockPerPage = listTO.getBlockPerPage();

		try {
			conn = dataSource.getConnection();

			String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board1 order by seq desc";
			pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			rs = pstmt.executeQuery();

			// 총 글 수
			rs.last();
			listTO.setTotalRecord(rs.getRow());
			rs.beforeFirst();

			// 총 페이지 수
			listTO.setTotalPage(((listTO.getTotalRecord() - 1) / listTO.getRecordPerPage()) + 1);

			// 페이지에서 글이 보이기 시작하는 번호
			int skip = (cpage - 1) * recordPerPage;
			// 커서를 시작하는 번호쪽으로 옮긴다.
			if (skip != 0) {
				rs.absolute(skip);
			}

			// DB에서 나온 값을 저장해주는 ArrayList
			// 한마디로 보여지는 목록들이 저장된다.
			ArrayList<ServletPagingBoardTO> boardLists = new ArrayList<ServletPagingBoardTO>();

			// 한 페이지에 보여질 글 10개까지만 boardLists에 담아준다.
			for (int i = 0; i < recordPerPage && rs.next(); i++) {
				// to에 값을 하나씩 넣고,
				ServletPagingBoardTO to = new ServletPagingBoardTO();

				to.setSeq(rs.getString("seq"));
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setWdate(rs.getString("wdate"));
				to.setHit(rs.getString("hit"));
				to.setWgap(rs.getInt("wgap"));
				// to객체 하나씩 boardLists 배열에 저장한다.
				boardLists.add(to);
			}

			// 한 페이지에 보여질 글 10개를 BoardListTO의 BoardLists변수에 담는다
			listTO.setBoardLists(boardLists);
			// 블럭 시작번호
			listTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
			// 블럭 끝번호
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

	public ServletPagingBoardTO boardView(ServletPagingBoardTO to) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String sql = "update board1 set hit=hit+1 where seq = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());

			pstmt.executeUpdate();

			sql = "select subject, writer, mail, wip, wdate, hit, content from board1 where seq = ?";
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

	public ServletPagingBoardTO boardModify(ServletPagingBoardTO to) {
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

	public int boardModifyOk(ServletPagingBoardTO to) {
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

	public ServletPagingBoardTO boardDelete(ServletPagingBoardTO to) {
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

	public int boardDeleteOk(ServletPagingBoardTO to) {
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
