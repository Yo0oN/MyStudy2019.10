package com.exam.model1;

import java.io.EOFException;
import java.io.File;
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

import org.springframework.web.bind.annotation.RequestMapping;

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

	public Design_album01ListTO board_list1(Design_album01ListTO listTO) {
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
		// 글목록이 담길곳
		ArrayList<Design_album01TO> toLists = new ArrayList<Design_album01TO>();

		try {
			conn = dataSource.getConnection();

			// 총 글 수 totalRecord
			String sql = "select count('seq') totalRecord from album_board1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRecord = rs.getInt("totalRecord");
			listTO.setTotalRecord(totalRecord);

			// 총 페이지 수
			listTO.setTotalPage(((totalRecord - 1) / recordPerPage) + 1);

			// 페이지에서 보이는 시작 글 번호
			int skip = (cpage - 1) * recordPerPage;

			// 글 목록
			sql = "select b.seq, subject, writer, date_format(wdate, '%Y.%m.%d') date, hit, filename_ch, ifnull(ccomment,'0') countcomment"
					+ " from album_board1 b left outer join (select seq, count(seq) ccomment from album_board1_com group by seq) c"
					+ " on (b.seq = c.seq) order by seq desc limit ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, skip);
			pstmt.setInt(2, recordPerPage);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Design_album01TO dto = new Design_album01TO();

				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setWdate(rs.getString("date"));
				dto.setHit(rs.getString("hit"));
				dto.setFilename_ch(rs.getString("filename_ch"));
				dto.setCom_count(rs.getString("countcomment"));

				toLists.add(dto);
			}
			// 글 목록
			listTO.setBoardLists(toLists);
			// 블럭 시작번호
			listTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
			// 블럭 끝번호
			listTO.setEndBlock(((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage);

			if (listTO.getEndBlock() >= listTO.getTotalPage()) {
				listTO.setEndBlock(listTO.getTotalPage());
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
		return listTO;
	}

	public ArrayList<Design_album01TO> board_view1(String seq) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		ArrayList<Design_album01TO> toLists = new ArrayList<Design_album01TO>();

		try {
			conn = dataSource.getConnection();

			String sql = "update album_board1 set hit = hit + 1 where seq=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, seq);

			pstmt.executeUpdate();

			sql = "select seq, subject, writer, content, date_format(wdate,'%Y.%m.%d %H:%i') date, hit, filename_ch, mail from album_board1  where seq = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				Design_album01TO dto = new Design_album01TO();

				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setWdate(rs.getString("date"));
				dto.setHit(rs.getString("hit"));
				dto.setFilename_ch(rs.getString("filename_ch"));
				dto.setMail(rs.getString("mail"));
				dto.setSeq(rs.getString("seq"));

				toLists.add(dto);
			}

			sql = "select writer, content, date_format(wdate,'%Y.%m.%d %H:%i') date, cseq from album_board1_com where seq=? order by cseq";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, seq);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Design_album01TO dto = new Design_album01TO();

				dto.setCwriter(rs.getString("writer"));
				dto.setCcontent(rs.getString("content"));
				dto.setCom_date(rs.getString("date"));
				dto.setCseq(rs.getString("cseq"));

				toLists.add(dto);
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

	public int board_reply_ok(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 0;
		try {
			conn = dataSource.getConnection();

			String sql = "insert into album_board1_com values(0, ?, ?, ?, ?, now())";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());
			pstmt.setString(2, to.getCwriter());
			pstmt.setString(3, to.getCpassword());
			pstmt.setString(4, to.getCcontent());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				flag = 1;
			}

		} catch (SQLException e) {
			System.out.println("error1 : " + e.getMessage());
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

	public int board_reply_delete_ok(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		try {
			conn = dataSource.getConnection();

			String sql = "delete from album_board1_com where seq=? and cseq=? and password=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());
			pstmt.setString(2, to.getCseq());
			pstmt.setString(3, to.getCpassword());

			int result = pstmt.executeUpdate();

			// 삭제성공했으면 flag는 1, 아니면 0
			if (result == 1) {
				flag = 1;
			} else if (result == 0) {
				flag = 0;
			}
		} catch (

		SQLException e) {
			System.out.println("error : " + e.getMessage());
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
		return flag;
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

	public Design_album01TO board_delete1(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();

			String sql = "select writer, subject from album_board1 where seq=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				to.setWriter(rs.getString("writer"));
				to.setSubject(rs.getString("subject"));
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

	public int board_delete1_ok(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		try {
			conn = dataSource.getConnection();

			String sql = "select filename_ch from album_board1 where seq =? and password=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());
			pstmt.setString(2, to.getPassword());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				to.setFilename_ch(rs.getString("filename_ch"));

				// 여기까지 넘어오면 비번은 맞았음. 댓글먼저 삭제
				sql = "delete from album_board1_com where seq=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, to.getSeq());

				pstmt.executeUpdate();

				// 글 삭제
				sql = "delete from album_board1 where seq=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, to.getSeq());

				int result = pstmt.executeUpdate();

				// 삭제성공했으면 flag는 1, 아니면 0
				if (result == 1) {
					flag = 1;
					// 파일 삭제
					File file = new File(
							"C:/Users/kitcoop/Desktop/Git/MyStudy2019.10/03.spring-workspace/SpringEx16MVCAlbumBoard/src/main/webapp/upload/"
									+ to.getFilename_ch());
					file.delete();
				} else if (result == 0) {
					flag = 0;
				}

			} else if (!rs.next()) {
				// 사진이름을 얻어오지못했다면 비밀번호가 틀린것. 비번틀렸으면 여기서 끝냄.
				flag = 0;
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

	public Design_album01TO board_modify1(Design_album01TO to) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();

			String sql = "select seq, writer, subject, mail, content, filename_ori from album_board1 where seq = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				to.setWriter(rs.getString("writer"));
				to.setSubject(rs.getString("subject"));
				to.setContent(rs.getString("content"));
				to.setMail(rs.getString("mail"));
				to.setFilename_ori(rs.getString("filename_ori"));
				to.setSeq(rs.getString("seq"));
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

	public int board_modify1_ok(Design_album01TO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 2;
		String oldfilename = "";

		try {
			conn = dataSource.getConnection();

			String sql = "select filename_ch from album_board1 where seq=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, to.getSeq());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				oldfilename = rs.getString("filename_ch");
			}

			if (to.getFilename_ori().equals("")) {
				sql = "update album_board1 set subject=?, mail=?, content=? where seq=? and password=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, to.getSubject());
				pstmt.setString(2, to.getMail());
				pstmt.setString(3, to.getContent());
				pstmt.setString(4, to.getSeq());
				pstmt.setString(5, to.getPassword());

			} else {
				sql = "update album_board1 set subject=?, mail=?, content=?, filename_ori=?, filename_ch=? where seq=? and password=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, to.getSubject());
				pstmt.setString(2, to.getMail());
				pstmt.setString(3, to.getContent());
				pstmt.setString(4, to.getFilename_ori());
				pstmt.setString(5, to.getFilename_ch());
				pstmt.setString(6, to.getSeq());
				pstmt.setString(7, to.getPassword());
			}
			int result = pstmt.executeUpdate();

			if (result == 1) {
				flag = 1;
				if (!to.getFilename_ori().equals("") && !oldfilename.equals("")) {
					File file = new File(
							"C:/Users/kitcoop/Desktop/Git/MyStudy2019.10/03.spring-workspace/SpringEx16MVCAlbumBoard/src/main/webapp/upload/"
									+ oldfilename);
					file.delete();
				}
			} else {
				flag = 0;
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
