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
<!-- 이 페이지는 여러개의 데이터를 자동으로 넣어 테스트를 하기 위하여 만든 페이지이다. -->

<%
	request.setCharacterEncoding("utf-8");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

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

		String sql = "insert into board1 values(0, ?, ?, ?, ?, ?, 0, ?, now());";
		pstmt = conn.prepareStatement(sql);

		for (int i = 1; i <= 100; i++) {
			pstmt.setString(1, "제목" + i);
			pstmt.setString(2, "이름" + i);
			pstmt.setString(3, "test@test.com");
			pstmt.setString(4, "123");
			pstmt.setString(5, "내용" + i);
			pstmt.setString(6, "000.000.000.000");

			int result = pstmt.executeUpdate();
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