<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "root";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String writer = "";
	String subject = "";
	String content = "";
	String[] mail = new String[2];

	try {
		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);

		String sql = "select writer, subject, content, mail from board1 where seq = ?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			writer = rs.getString("writer");
			subject = rs.getString("subject");
			content = rs.getString("content");
			if (rs.getString("mail").equals("")) {
				mail[0] = "";
				mail[1] = "";
			} else {
				mail = rs.getString("mail").split("@");
			}
		}

	} catch (ClassNotFoundException e) {

	} catch (SQLException e) {

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
		document.getElementById('button1').onclick = function() {
			if (document.frm.password.value.trim() == "") {
				alert('비밀번호를 입력해주세요');
				return false;
			}
			document.frm.submit();
		};
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
		<form action="board_modify1_ok.jsp" method="post"
			name="frm">
			<input type="hidden" name="seq" value="<%= seq %>">
			<div class="contents_sub">
				<!--게시판-->
				<div class="board_write">
					<table>
						<tr>
							<th class="top">글쓴이</th>
							<td class="top" colspan="3"><input type="text" name="writer"
								value="<%=writer%>" class="board_view_input_mail" maxlength="5"
								readonly /></td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" name="subject"
								value="<%=subject%>" class="board_view_input" /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td colspan="3"><input type="password" name="password"
								value="" class="board_view_input_mail" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3"><textarea name="content"
									class="board_editor_area"><%=content%></textarea></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td colspan="3"><input type="text" name="mail1"
								value="<%=mail[0]%>" class="board_view_input_mail" /> @ <input
								type="text" name="mail2" value="<%=mail[1]%>"
								class="board_view_input_mail" /></td>
						</tr>
					</table>
				</div>

				<div class="btn_area">
					<div class="align_left">
						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='board_list1.jsp'">목록</button>
						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='board_view1.jsp?seq=<%= seq %>">보기</button>
					</div>
					<div class="align_right">
						<button type="button" id="button1" class="btn_write btn_txt01"
							style="cursor: pointer;">수정</button>
					</div>
				</div>
				<!--//게시판-->
			</div>
		</form>
	</div>
	<!-- 하단 디자인 -->

</body>
</html>
