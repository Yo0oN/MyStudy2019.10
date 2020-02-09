<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");

	String url = "jdbc:mysql://127.0.0.1:3306/project";
	String user = "project";
	String pass = "123456";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer sb = new StringBuffer();
	int i = 0;
	
	try {
		Class.forName("org.mariadb.jdbc.Driver");

		conn = DriverManager.getConnection(url, user, pass);

		String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') date, hit from board2 order by seq desc";

		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			int seq = rs.getInt("seq");
			String subject = rs.getString("subject");
			String writer = rs.getString("writer");
			String date = rs.getString("date");
			int hit =  rs.getInt("hit");
			
			
			
			sb.append("<tr>");
			sb.append("<td></td>");
			sb.append("<td>" + seq + "</td>");
			sb.append("<td><a href='board_view1.jsp?seq=" + seq + "'>" + subject + "</a></td>");
			sb.append("<td>" + writer + "</td>");
			sb.append("<td>" + date + "</td>");
			sb.append("<td>" + hit + "</td>");
			sb.append("</tr>");
		}
		
		i = rs.getRow() -1;
	} catch (ClassNotFoundException e) {
		System.out.println("error1 : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println("error2 : " + e.getMessage());
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
					총 <span class="txt_orange"><%=i%></span>건
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
					<%=sb%>
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
				</table>
			</div>
			<div class="align_right">
				<button type="button" class="btn_write btn_txt01"
					style="cursor: pointer;" onclick="location.href='board_write1.jsp'">쓰기</button>
			</div>
			<!--//게시판-->
		</div>
	</div>
	<!--//하단 디자인 -->

</body>
</html>
