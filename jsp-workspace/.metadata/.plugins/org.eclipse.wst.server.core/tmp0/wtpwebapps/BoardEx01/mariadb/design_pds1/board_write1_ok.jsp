<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String uploadPath = "C:/java/OneDrive/Java/eclipse/jsp-workspace/BoardEx01/WebContent/upload";
	int maxFileSize = 1024 * 1024 * 2;
	String encType = "utf-8";

	MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encType,
			new DefaultFileRenamePolicy());

	// File file = multi.getFile("upload");

	String writer = multi.getParameter("writer");
	String subject = multi.getParameter("subject");
	String password = multi.getParameter("password");
	String content = multi.getParameter("content");
	String mail = "";
	if (!multi.getParameter("mail1").trim().equals("") || !multi.getParameter("mail2").trim().equals("")) {
		mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");
	}
	String filename = "";
	int filesize = 0;
	if (multi.getFilesystemName("upload") != null) {
		filename = multi.getFilesystemName("upload");
		//filesize = (int) file.length();
		filesize = (int) multi.getFile("upload").length();
	}

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

		String sql = "insert into pds_board1 values(0, ?, ?, ?, ?, ?, ?, ?, 0, ?, now());";
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, subject);
		pstmt.setString(2, writer);
		pstmt.setString(3, mail);
		pstmt.setString(4, password);
		pstmt.setString(5, content);
		pstmt.setString(6, filename);
		pstmt.setInt(7, filesize);
		pstmt.setString(8, request.getRemoteAddr());

		int result = pstmt.executeUpdate();

		if (result == 1) {
			// 글쓰기를 성공하면 flag값이 0이된다.
			// 이것을 이용해 다음 페이지로 넘어갈것이다.
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
		out.println("alert('글쓰기 성공');");
		out.println("location.href='board_list1.jsp';");
	} else {
		out.println("alert('글쓰기 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>