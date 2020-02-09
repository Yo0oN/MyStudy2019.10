<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<!-- 이 페이지는 쓰기페이지인 board_writ1에서 넘어온 정보를
DB에 저장해주는 페이지이기 때문에 화면에 보여주지 않는페이지이다.
그래서HTML서식은 필요없다. -->

<%
	request.setCharacterEncoding("utf-8");

	String subject = request.getParameter("subject");
	String writer = request.getParameter("writer");
	String mail = "";
	// 만약 mail1과 mail2가 둘다 들어올경우엔 이메일을 저장하고, 아니면 저장하지 않는다.
	if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	}
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	String wip = request.getRemoteAddr();

	Connection conn = null;
	PreparedStatement pstmt = null;

	int flag = 1;

	try {
		Context initCtx = new InitialContext();
		// 톰캣의 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 커넥션 풀링에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		// 커넥션 풀링에서 커넥션을 얻음
		conn = dataSource.getConnection();

		String sql = "insert into rep_board1 values(0, last_insert_id() + 1, 0, 0, ?, ?, ?, ?, ?, 0, ?, now());";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, subject);
		pstmt.setString(2, writer);
		pstmt.setString(3, mail);
		pstmt.setString(4, password);
		pstmt.setString(5, content);
		pstmt.setString(6, wip);

		int result = pstmt.executeUpdate();

		if (result == 1) {
			// 글쓰기를 성공하면 flag값이 0이된다.
			// 이것을 이용해 다음 페이지로 넘어갈것이다.
			flag = 0;
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
	/*
	// flag가 0이면(글쓰고 DB등록 성공했으면) 메인페이지 아니면 다시 글쓰기창
	if (flag == 0) {
		response.sendRedirect("board_list1.jsp");
	} else {
		response.sendRedirect("board_write1.jsp");
	}
	*/

	// flag가 0이면(글쓰고 DB등록 성공했으면) 
	// 알림창이 뜨고 메인페이지 아니면 알림창이 뜨고 이전페이지로
	// 알림창이 뜨게 하고싶으므로, 알림창 기능이 있는 javascript로 진행한다.
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기 성공');");
		out.println("location.href='board_list1.jsp';");
	} else {
		out.println("alert('글쓰기 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>