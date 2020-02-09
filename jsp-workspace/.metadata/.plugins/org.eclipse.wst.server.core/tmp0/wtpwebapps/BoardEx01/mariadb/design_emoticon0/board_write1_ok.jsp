<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");

	String writer = request.getParameter("writer");
	String subject = request.getParameter("subject");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	String mail = "";
	if (!request.getParameter("mail1").trim().equals("") && !request.getParameter("mail2").trim().equals("")) {
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	}
	String emot = request.getParameter("emot");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;

	int flag = 1;
	
	try {
		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);
		
		String sql = "insert into board2 value(0, ?, ?, ?, ?, ?, 0, ?, now(), ?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, subject);
		pstmt.setString(2, writer);
		pstmt.setString(3, mail);
		pstmt.setString(4, password);
		pstmt.setString(5, content);
		pstmt.setString(6, request.getRemoteAddr());
		pstmt.setString(7, emot);
		
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
		out.println("alert('등록 완료.');");
		out.println("location.href='board_list1.jsp';");
	} else {
		out.println("alert('등록 실패.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>