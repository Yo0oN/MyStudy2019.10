<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
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
		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);

		String sql = "delete from board2 where seq=? and password=?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);
		pstmt.setString(2, password);

		int i = pstmt.executeUpdate();

		if (i == 1) {
			flag = 0;
		}
	} catch (ClassNotFoundException e) {
		System.out.println("error1 : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println("error2 : " + e.getMessage());
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