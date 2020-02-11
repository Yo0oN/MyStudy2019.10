<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%
	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
%>
<%
	// java 코드는 위에서 선언하고, 아래에서 출력만 해준다.
	StringBuffer sbHtml = new StringBuffer();
	int result = 0;
	try {
		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);

		String sql = "select seq, subject, writer, wdate, hit from board1 order by seq desc";

		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();

		while (rs.next()) {
			String seq = rs.getString("seq");
			String subject = rs.getString("subject");
			String writer = rs.getString("writer");
			String wdate = rs.getString("wdate");
			String hit = rs.getString("hit");

			sbHtml.append("<tr>");
			sbHtml.append("<td>&nbsp;</td>");
			sbHtml.append("<td>" + seq + "</td>");
			sbHtml.append("<td class='left'><a href='board_view1.jsp'>" + subject
					+ "</a>&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'></td>");
			sbHtml.append("<td>" + writer + "</td>");
			sbHtml.append("<td>" + wdate + "</td>");
			sbHtml.append("<td>" + hit + "</td>");
			sbHtml.append("<td>&nbsp;</td>");
			sbHtml.append("</tr>");
			if (rs.isLast()) {
				result = rs.getRow();
			}
		}

	} catch (ClassNotFoundException e) {
		System.out.println("error1 : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println("error2 : " + e.getMessage());
	} finally {
		if (rs != null) { rs.close(); }
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
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
<link rel="stylesheet" type="text/css" href="../../css/board_list.css">
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
		<div class="contents_sub">
			<div class="board_top">
				<div class="bold">
					<!-- 게시글 수 -->
					총 <span class="txt_orange"><%= result %></span>건
				</div>
			</div>

			<!--게시판-->
			<div class="board">
				<table>
					<tr>
						<th width="3%">&nbsp;</th>
						<th width="5%">번호</th>
						<th>제목</th>
						<th width="10%">글쓴이</th>
						<th width="17%">등록일</th>
						<th width="5%">조회</th>
						<th width="3%">&nbsp;</th>
					</tr>
					<!-- 게시판 글 시작.DB에서 가져온 글목록을 이곳에 넣어주어야한다. -->
					<!-- 위에 있는 DB에서 빼온 글목록을 이곳에서 출력한다. -->
					<%=sbHtml%>

					<!-- 
			<tr>
				<td>&nbsp;</td>
				<td>1</td>
				<td class="left"><a href="board_view1.jsp">adfas</a>&nbsp;<img src="../../images/icon_hot.gif" alt="HOT"></td>
				<td>asdfa</td>
				<td>2017-01-31</td>
				<td>6</td>
				<td>&nbsp;</td>
			</tr>
			 -->
					<!-- 게시판 글 끝 -->
				</table>
			</div>
			<!--//게시판-->

			<div class="align_right">
				<button type="button" class="btn_write btn_txt01"
					style="cursor: pointer;" onclick="location.href='board_write1.jsp'">쓰기</button>
			</div>
		</div>
	</div>
	<!--//하단 디자인 -->

</body>
</html>
