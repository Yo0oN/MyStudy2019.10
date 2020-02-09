<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%
	request.setCharacterEncoding("utf-8");

	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");

	String subject = request.getParameter("subject");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	String mail = "";
	if (!request.getParameter("mail1").trim().equals("") && !request.getParameter("mail2").trim().equals("")) {
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	}
	String emot = request.getParameter("emot").replaceAll("emot", "");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;

	int flag = 2;

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		conn = dataSource.getConnection();

		String sql = "update emot_board1 set subject=?, content=?, mail=?, emot=? where seq=? and password=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, subject);
		pstmt.setString(2, content);
		pstmt.setString(3, mail);
		pstmt.setString(4, emot);
		pstmt.setString(5, seq);
		pstmt.setString(6, password);

		int i = pstmt.executeUpdate();

		if (i == 1) {
			flag = 0;
		} else if (i == 0) {
			flag = 1;
		}
	} catch (NamingException e) {
		System.out.println("error1 : " + e.getMessage());
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
		out.println("alert('수정 완료.');");
		out.println("location.href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호를 확인하세요.');");
		out.println("history.back();");
	} else {
		out.println("alert('수정 실패.');");
	}
	out.println("</script>");
%>