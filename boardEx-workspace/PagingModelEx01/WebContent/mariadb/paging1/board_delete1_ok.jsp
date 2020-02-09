<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>


<!-- 이 페이지는 삭제페이지인 board_delete1에서 넘어온 정보를
DB에서 처리하는 페이지이기 때문에 화면에 보여주지 않는 페이지이다. -->
<%
	request.setCharacterEncoding("utf-8");

	// 이전페이지에서 받은 seq와 password
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;

	int flag = 2;
	try {
		Context initCtx = new InitialContext();
		// 톰캣의 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 커넥션 풀링에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		// 커넥션 풀링에서 커넥션을 얻음
		conn = dataSource.getConnection();

		// 비밀번호는 맞는지 확인만 하고, 밖에 보이지 않게 해주어야한다.
		String sql = "delete from board1 where seq = ? and password = ?";
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