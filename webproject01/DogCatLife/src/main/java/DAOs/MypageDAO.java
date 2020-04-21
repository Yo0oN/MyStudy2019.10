package DAOs;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import TOs.BoardListsTO;
import TOs.BoardTO;
import TOs.UserTO;
import mail.MailSender;

public class MypageDAO {
	private String uploadPath = "C:\\Users\\kitcoop\\Desktop\\Git\\MyStudy2019.10\\webproject01\\DogCatLife\\src\\main\\webapp\\resources\\upload";
//	private String uploadPath = "/var/lib/tomcat8/webapps/DogCatLife202004201/resources/upload";
	private DataSource dataSource = null;
	
	public MypageDAO() {
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

	public int mypage_input_password_ok(UserTO userTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();
			
			String sql = "select nickname from user where mseq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userTO.getMseq());
			pstmt.setString(2, userTO.getPassword());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = 0;
			}
		} catch(SQLException e) {
			System.out.println("[에러] : " + e.getMessage());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
		}
	
		return flag;
	}

	public UserTO myinfo(String mseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		UserTO userTO = new UserTO();
		try {
			conn = dataSource.getConnection();

			String sql = "select email, name, nickname, phone from user where mseq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mseq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userTO.setEmail(rs.getString("email"));
				userTO.setName(rs.getString("name"));
				userTO.setNickname(rs.getString("nickname"));
				userTO.setPhone(rs.getString("phone"));
			}
		} catch(SQLException e) {
			System.out.println("[에러1] : " + e.getMessage());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
		}
	
		return userTO;
	}
	
	public int myinfo_ok(UserTO userTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int flag = 1;
		try {
			conn = dataSource.getConnection();
			
			String sql = "update user set nickname=?, phone=? where mseq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userTO.getNickname());
			pstmt.setString(2, userTO.getPhone());
			pstmt.setString(3, userTO.getMseq());
			pstmt.setString(4, userTO.getPassword());
			
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
	
	public BoardListsTO mycontents_list(BoardListsTO boardListsTO, String selected) {
		// 현재페이지
		int cpage = boardListsTO.getCpage();
		// 한 페이지에 몇개 보이는지? 10개
		int recordPerPage = boardListsTO.getRecordPerPage();
		// 한블럭에 몇개들어가는지? (5개)
		int blockPerPage = boardListsTO.getBlockPerPage();
		// 총 글 수
		int totalRecord = boardListsTO.getTotalRecord();
		// 글목록이 담길곳
		ArrayList<BoardTO> boardLists = new ArrayList();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();

			String sql = "";
			// 글 수
			if (selected == null || selected.equals("") || selected.equals("0")) {
				sql = "select count('seq') totalRecord from board where mseq=?";
			} else {
				sql = "select count('seq') totalRecord from board where mseq=? and pseq=" + selected;
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardListsTO.getMseq());
			rs = pstmt.executeQuery();
			
			rs.next();
			totalRecord = rs.getInt("totalRecord");

			boardListsTO.setTotalRecord(totalRecord);
			
			// 총 페이지 수
			boardListsTO.setTotalPage(((totalRecord - 1) / recordPerPage) + 1);

			// 페이지에서 보이는 시작 글 번호
			int skip = (cpage - 1) * recordPerPage;
			
			if (selected == null || selected.equals("") || selected.equals("0")) {
				sql = "select seq, pseq, subject, cmt, wdate_ori, hit from board where mseq=? order by seq desc limit ?, ?";
			} else {
				sql = "select seq, pseq, subject, cmt, wdate_ori, hit from board where mseq=? and pseq=" + selected + "order by seq desc limit ?, ?";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardListsTO.getMseq());
			pstmt.setInt(2, skip);
			pstmt.setInt(3, recordPerPage);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardTO boardTO = new BoardTO();
				
				boardTO.setSeq(rs.getString("seq"));
				boardTO.setPseq(rs.getString("pseq"));
				boardTO.setSubject(rs.getString("subject"));
				boardTO.setCmt(rs.getString("cmt"));
				boardTO.setWdate_ori(rs.getString("wdate_ori"));
				boardTO.setHit(rs.getString("hit"));
				
				boardLists.add(boardTO);
			}
			// 글 목록
			boardListsTO.setBoardLists(boardLists);
			// 블럭 시작번호
			boardListsTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
			// 블럭 끝번호
			boardListsTO.setEndBlock(((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage);

			if (boardListsTO.getEndBlock() >= boardListsTO.getTotalPage()) {
				boardListsTO.setEndBlock(boardListsTO.getTotalPage());
			}
		} catch(SQLException e) {
			System.out.println("[에러1] : " + e.getMessage());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if(conn != null) try { conn.close(); } catch(SQLException e) {}
			if(rs != null) try { rs.close(); } catch(SQLException e) {}
		}
	
		return boardListsTO;
	}

}