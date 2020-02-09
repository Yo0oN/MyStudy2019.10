<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.io.File"%>

<%
	request.setCharacterEncoding("utf-8");

	String seq = request.getParameter("seq");
	String password = request.getParameter("password");

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	int flag = 2;
	try {
		Context initCtx = new InitialContext();
		// 톰캣의 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 커넥션 풀링에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		// 커넥션 풀링에서 커넥션을 얻음
		conn = dataSource.getConnection();

		String sql = "select filename from pds_board1 where seq = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		String filename = null;
		if (rs.next()) {
			filename = rs.getString("filename");
		}

		// 비밀번호는 맞는지 확인만 하고, 밖에 보이지 않게 해주어야한다.
		sql = "delete from pds_board1 where seq = ? and password = ?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);
		pstmt.setString(2, password);

		int result = pstmt.executeUpdate();
		// 글삭제에 성공하면 flag값이 0, 비밀번호가 틀리면 1,
		// 위의 어딘가에서 잘못되었다면 여기까지 못오기때문에 2가 된다.
		// 이것을 이용해 다음 페이지로 넘어갈것이다.
		if (result == 0) {
			flag = 1;
		} else if (result == 1) {
			flag = 0;
			if (filename != null) {
				// 특정 파일의 File객체 생성(글 작성자가 올린 파일)
				File file = new File(
						"C:/java/OneDrive/Java/eclipse/jsp-workspace/BoardEx01/WebContent/upload/" + filename);
				// 파일 삭제
				file.delete();
			}
		}

	} catch (NamingException e) {
		System.out.println("[error1] : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println("error2 : " + e.getMessage());
	} finally {
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글삭제에 성공하였습니다.');");
		out.println("location.href='board_list1.jsp';");
	} else if (flag == 1) {
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글삭제에 실패하였습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>