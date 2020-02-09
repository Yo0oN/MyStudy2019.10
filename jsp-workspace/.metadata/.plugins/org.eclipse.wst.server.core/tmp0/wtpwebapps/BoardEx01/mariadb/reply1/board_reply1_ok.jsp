<%@page import="java.sql.ResultSet"%>
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
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");

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
	ResultSet rs = null;

	int flag = 1;

	try {
		Context initCtx = new InitialContext();
		// 톰캣의 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 커넥션 풀링에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		// 커넥션 풀링에서 커넥션을 얻음
		conn = dataSource.getConnection();

		// 부모글에 대한 정보를 얻어야 한다.(그래야 답글의 grp, grps, grpl을 정해줄 수 있기 때문이다.)
		String sql = "select grp, grps, grpl from rep_board1 where seq=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		int grp = 0;
		int grps = 0;
		int grpl = 0;

		if (rs.next()) {
			grp = rs.getInt("grp");
			grps = rs.getInt("grps");
			grpl = rs.getInt("grpl");
		}

		// 부모 글에 대한 grp, grps, grpl을 가져왔으면
		// 같은 그룹(부모와 grp가 같은것들)에 있고,
		// 부모글에 달린 답글들(부모글의 grps보다 큰것들, 즉 부모글보다 낮은 위치에 있는것들)을 선택하여
		// grps는 새로운 답글이 달릴 때 마다 1씩 올라가기 때문에 +1을 해준다.
		sql = "update rep_board1 set grps=grps+1 where grp=? and grps>?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, grp);
		pstmt.setInt(2, grps);

		pstmt.executeUpdate();

		// 부모 글들의 설정을 전부 바꿔주었기 때문에 답글을 넣어주자.
		sql = "insert into rep_board1 values(0, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, now());";
		pstmt = conn.prepareStatement(sql);

		// grp는 부모와 같은 그룹이므로 grp는 그대로 둔다.
		pstmt.setInt(1, grp);
		// 이 답글은 부모글 바로 다음에 올 글이기 때문에 grps는 부모의 grps+1을 해준다.
		pstmt.setInt(2, grps + 1);
		// 이 답글은 부모글보다 낮은 위치에 있기 때문에 부모의 grpl+1을 해준다.
		pstmt.setInt(3, grpl + 1);
		pstmt.setString(4, subject);
		pstmt.setString(5, writer);
		pstmt.setString(6, mail);
		pstmt.setString(7, password);
		pstmt.setString(8, content);
		pstmt.setString(9, wip);

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

	// flag가 0이면(글쓰고 DB등록 성공했으면) 
	// 알림창이 뜨고 메인페이지 아니면 알림창이 뜨고 이전페이지로
	// 알림창이 뜨게 하고싶으므로, 알림창 기능이 있는 javascript로 진행한다.
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('답글 달기 성공');");
		out.println("location.href='board_view1.jsp?cpage=" + cpage + "&seq=" + seq + "';");
	} else {
		out.println("alert('답글 달기 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>