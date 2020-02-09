<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>

<%
	request.setCharacterEncoding("utf-8");

	String seq = request.getParameter("seq");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	String subject = request.getParameter("subject");

	String mail = "";
	if (!request.getParameter("mail1").trim().equals("") && !request.getParameter("mail2").trim().equals("")) {
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	}

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;

	int flag = 2;

	try {

		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);

		// 비밀번호는 맞는지 확인만 하고, 밖에 보이지 않게 해주어야한다.
		String sql = "update board1 set content=?, subject=?, mail=? where seq = ? and password = ?";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, content);
		pstmt.setString(2, subject);
		pstmt.setString(3, mail);
		pstmt.setString(4, seq);
		pstmt.setString(5, password);

		int result = pstmt.executeUpdate();

		// 글수정에 성공하면 flag값이 0, 비밀번호가 틀리면 1,
		// 위의 어딘가에서 잘못되었다면 여기까지 못오기때문에 2가 된다.
		// 이것을 이용해 다음 페이지로 넘어갈것이다.
		if (result == 0) {
			flag = 1;
		} else if (result == 1) {
			flag = 0;
		}

	} catch (ClassNotFoundException e) {
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
		out.println("alert('수정 완료');");
		out.println("location.href='board_view1.jsp?seq=" + seq + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호를 다시 확인해주세요');");
		out.println("history.back();");
	} else {
		out.println("alert('수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>
