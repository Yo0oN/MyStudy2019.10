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
	String cpage = request.getParameter("cpage");

	// view1 페이지에서 seq를 가져온다.
	String seq = request.getParameter("seq");

	String subject = "";
	String writer = "";

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		Context initCtx = new InitialContext();
		// 톰캣의 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 커넥션 풀링에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		// 커넥션 풀링에서 커넥션을 얻음
		conn = dataSource.getConnection();

		// 이 페이지에 들어올때마다 조회수가 1씩 오른다.
		// 실력이 생긴다면 IP별로 하루에 한번씩만 조회수를 올릴 수 있게 설정해주자.

		String sql = "select subject, writer from board1 where seq = ?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			subject = rs.getString("subject");
			writer = rs.getString("writer");
		}
	} catch (NamingException e) {
		System.out.println("[error1] : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println("error2 : " + e.getMessage());
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_write.css">

<script type="text/javascript">
	window.onload = function() {
		// 버튼을 눌렀을 때 비밀번호가 비어있으면 입력 알림창을,
		// 비밀번호가 틀려도 알림창을,
		// 조건을 다 충족하면 다음페이지로 넘어가게 해준다.
		document.getElementById('submit1').onclick = function() {
			if (document.frm.password.value.trim() == '') {
				alert('비밀번호를 입력해주세요.');
				return false;
			}
			document.frm.submit();
		}
	}
</script>
</head>

<body>
	<!-- 상단 디자인 -->
	<div class="con_title">
		<h3>게시판</h3>
		<p>
			HOME &gt; 게시판 &gt; <strong>게시판</strong>
		</p>
	</div>
	<div class="con_txt">
		<form action="board_delete1_ok.jsp" method="post" name="frm">
			<!-- 겉으로는 보이지않지만 다음페이지로 seq를 가져가야 하기 때문에
			hidden타입을 이용하여 seq를 form 안에 넣어주어 다음페이지로 가져갈 수 있게 해준다. -->
			<input type="hidden" name="seq" value="<%=seq%>">
			<div class="contents_sub">
				<!--게시판-->
				<div class="board_write">
					<table>
						<tr>
							<th class="top">글쓴이</th>
							<td class="top" colspan="3"><input type="text" name="writer"
								value="<%=writer%>" class="board_view_input_mail"
								maxlength="5" readonly /></td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" name="subject"
								value="<%=subject%>" class="board_view_input" readonly /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td colspan="3"><input type="password" name="password"
								value="" class="board_view_input_mail" /></td>
						</tr>
					</table>
				</div>

				<div class="btn_area">
					<div class="align_left">

						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='board_list1.jsp?cpage=<%=cpage%>'">목록</button>
						<!-- 보기버튼을 누르면 글로 다시 돌아간다. -->
						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='board_view1.jsp?seq=<%=seq%>&cpage=<%=cpage%>'">보기</button>
					</div>
					<div class="align_right">
						<button type="button" id="submit1" class="btn_write btn_txt01"
							style="cursor: pointer;">삭제</button>
					</div>
				</div>
				<!--//게시판-->
			</div>
		</form>
	</div>
	<!-- 하단 디자인 -->

</body>
</html>
