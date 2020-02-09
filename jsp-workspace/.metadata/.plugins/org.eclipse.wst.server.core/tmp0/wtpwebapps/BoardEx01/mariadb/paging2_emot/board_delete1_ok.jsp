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

	String password = request.getParameter("password");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;

	int flag = 1;

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		conn = dataSource.getConnection();

		String sql = "delete from emot_board1 where seq=? and password=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);
		pstmt.setString(2, password);

		int i = pstmt.executeUpdate();

		if (i == 1) {
			flag = 0;
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
		out.println("alert('삭제 완료.');");
		out.println("location.href='board_list1.jsp';");
	} else {
		out.println("alert('비밀번호를 다시 확인하세요.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>