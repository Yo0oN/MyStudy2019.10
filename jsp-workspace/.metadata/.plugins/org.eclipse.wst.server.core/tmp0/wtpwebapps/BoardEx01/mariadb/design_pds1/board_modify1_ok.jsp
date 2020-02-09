<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>

<%
	request.setCharacterEncoding("utf-8");
	String uploadPath = "C:/java/OneDrive/Java/eclipse/jsp-workspace/BoardEx01/WebContent/upload";
	int maxFileSize = 1024 * 1024 * 2;
	String encType = "utf-8";

	MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encType,
			new DefaultFileRenamePolicy());

	String cpage = multi.getParameter("cpage");
	String seq = multi.getParameter("seq");

	String writer = multi.getParameter("writer");
	String subject = multi.getParameter("subject");
	String password = multi.getParameter("password");
	String content = multi.getParameter("content");
	String mail = "";
	if (!multi.getParameter("mail1").trim().equals("") || !multi.getParameter("mail2").trim().equals("")) {
		mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");
	}
	
	// 파일업로드시에는 4가지 경우의 수가 있다.
	// 1. 원래 첨부파일이 없었고, 수정시에도 없음.
	// 2. 기존 첨부파일이 있었고, 수정시에 그대로임.
	// 3. 기존 첨부파일이 없었고, 수정시에는 새 첨부파일이 있음.
	// 4. 기존 첨부파일이 있었고, 수정시에 새 첨부파일로 바꿈.
	String newFilename = "";
	long newFilesize = 0;
	// 파일을 새로 업로드 했다면 newFilename에 이름을 적어준다.
	// 새로업로드하지 않았다면 아래if문은 지나친다.
	if (multi.getFile("upload") != null) {
		newFilename = multi.getFilesystemName("upload");
		newFilesize = multi.getFile("upload").length();
	}

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

		// 수정시 파일도 수정했거나 새로운 파일을 올렸거나, 그대로일 수도 있으니
		// 이전 파일 이름을 받아온다.
		String sql = "select filename from pds_board1 where seq=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		String oldFilename = "";

		if (rs.next()) {
			oldFilename = rs.getString("filename");
		}

		pstmt = conn.prepareStatement(sql);

		// 수정시 아무 파일도 올리지 않았다면, 파일 이름부분은 바꾸지 않는다.
		// 위의 가정 중에 1번과 2번에 해당
		if (newFilename.equals("")) {
			sql = "update pds_board1 set subject=?, mail=?, content=? where seq=? and password=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, seq);
			pstmt.setString(5, password);
		} else {
			// 하지만 파일을 새로 올리거나, 수정했다면 파일이름이 바꼈을테니 DB에서도 바꿔준다.
			// 위의 가정 중 3번과 4번에 해당
			sql = "update pds_board1 set subject=?, mail=?, content=?, filename=?, filesize=? where seq=? and password=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, newFilename);
			pstmt.setString(5, newFilesize + "");
			pstmt.setString(6, seq);
			pstmt.setString(7, password);
		}

		int result = pstmt.executeUpdate();

		if (result == 0) {
			flag = 1;
		} else if (result == 1) {
			flag = 0;
			// 글 수정 성공했는데, 만약 새로 올린 파일이름이 공백이아니고,
			// 이전 파일이름이 빈칸이 아니면
			// (위의 뜻은 파일을 기존첨부파일이 있었을 때 이전파일대신 새로운 파일을올렸다는뜻임.)
			// 아무튼 새로운 파일을 올리게 된다면 이전 파일을 삭제한다.
			// 애초에 파일을 올리지 않은 사람이거나, 수정시에 새로 파일을 올리게 되는사람은
			// 삭제할 파일이 없으니 아래문구와는 상관없다.
			// 위의 가정 중 4번일 경우 이전 파일을 삭제해 주어야 하니 아래의 삭제가 실행된다.
			if (!newFilename.equals("") && !oldFilename.equals("")) {
				File file = new File("C:/java/OneDrive/Java/eclipse/jsp-workspace/BoardEx01/WebContent/upload/" + oldFilename);
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
		out.println("alert('수정 완료');");
		out.println("location.href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호를 다시 확인해주세요');");
		out.println("history.back();");
	} else {
		out.println("alert('수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>
