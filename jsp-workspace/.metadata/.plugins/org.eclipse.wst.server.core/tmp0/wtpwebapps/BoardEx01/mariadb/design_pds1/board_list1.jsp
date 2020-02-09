﻿<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	// 현재 페이지 cpage
	int cpage = 1;

	// cpage의 값이 제대로 들어올 경우(=페이지번호를 클릭해서 이동했을 때 cpage에 새로운 값이 들어온다.) 아래의 식이 실행된다.  
	if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
		// 이전 페이지에서 받아온 cpage값, 즉 내가 선택한 페이지를 cpage에 넣어준다.
		// 이 값을 이용하여, 아래에서 목록에 몇번부터 몇번까지의 글들이 보일지 설정해준다. 
		cpage = Integer.parseInt(request.getParameter("cpage"));
	}

	// 한 페이지당 출력 데이터 개수
	int recordPerPage = 10;
	// 전체 페이지 개수
	int totalPage = 1;
	// 전체 데이터(글) 개수
	int totalRecord = 0;
	// 페이지번호를 5개씩 끊어서 보여주게한다.
	int blockPerPage = 5;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// java 코드는 위에서 선언하고, 아래에서 출력만 해준다.
	StringBuffer sbHtml = new StringBuffer();

	try {
		Context initCtx = new InitialContext();
		// 톰캣의 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		// 커넥션 풀링에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		// 커넥션 풀링에서 커넥션을 얻음
		conn = dataSource.getConnection();

		// datediff(구분자, 시작시간, 끝나는시간) 시작시간과 끝나는 시간의 차이를 구해준다.
		// 구분자는 년,월,일,시 등등..필요한걸 넣으면 된다. 지금은 일차이를 구하고싶으니 d를 넣어준다. -> 구분자 넣으니 안된다
		String sql = "select seq, subject, writer, filename, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) diff from pds_board1 order by seq desc";

		pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		rs = pstmt.executeQuery();

		// 커서를 제일 마지막으로 옮긴 후 그곳이 몇번째 행인지 읽고, 다시 처음으로 돌아온다.
		rs.last();
		totalRecord = rs.getRow();
		rs.beforeFirst();

		// 전체 페이지수는 ((전체 글 개수-1)/10)+1 이다.
		totalPage = ((totalRecord - 1) / recordPerPage) + 1;

		// 시작번호 skip - 페이지에서 글이 보이기 시작하는 번호다.
		int skip = (cpage - 1) * recordPerPage;
		// 커서를 그쪽으로 옮겨주어서 해당페이지에 해당하는 글만 보여주게 한다.
		if (skip != 0) {
			rs.absolute(skip);
		}

		// skip번부터 recordPerPage개(10개)만큼 읽어온다
		for (int i = 0; i < recordPerPage && rs.next(); i++) {
			String seq = rs.getString("seq");
			String subject = rs.getString("subject");
			String writer = rs.getString("writer");
			String filename = rs.getString("filename");
			String wdate = rs.getString("wdate");
			String hit = rs.getString("hit");
			int diff = rs.getInt("diff");

			sbHtml.append("<tr>");
			sbHtml.append("<td>&nbsp;</td>");
			sbHtml.append("<td>" + seq + "</td>");
			// 이부분이 board_view로 넘어가는 부분이다.(제목 누르면 글을 볼수있게 해주는곳)
			// seq를 가지고가서 해당 글을 가져오게 해주자.
			// 그리고 만든지 하루가 지나면 제목 옆의 그림이 사라지게 해주자.
			//sbHtml.append("<td class='left'><a href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage + "'>"
			//		+ subject);
			sbHtml.append("<td class='left'><a href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage + "'>"
					+ subject + "</a>&nbsp;");
			if (diff <= 1) {
				sbHtml.append("</a>&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'>");
			}
			sbHtml.append("</td>");
			sbHtml.append("<td>" + writer + "</td>");
			sbHtml.append("<td>" + wdate + "</td>");
			sbHtml.append("<td>" + hit + "</td>");
			if (filename.equals("")) {
				sbHtml.append("<td></td>");
			} else {
				sbHtml.append("<td><img src='../../images/icon_file.gif' /></td>");
			}
			sbHtml.append("</tr>");
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
					<p>
						총 <span class="txt_orange"><%=totalRecord %></span>건
					</p>
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
					<%=sbHtml%>
				</table>
			</div>
			<!--//게시판-->

			<div class="align_right">
				<button type="button" class="btn_write btn_txt01"
					style="cursor: pointer;" onclick="location.href='board_write1.jsp'">쓰기</button>
			</div>

			<!--페이지넘버-->
			<div class="paginate_regular">
				<div align="absmiddle">
					<%
						// 보이는 페이지 번호의 시작부분이다.
						int startBlock = ((cpage - 1) / blockPerPage) * blockPerPage + 1;
						// 보이는 페이지 번호의 끝부분이다.
						int endBlock = ((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage;
						if (endBlock >= totalPage) {
							endBlock = totalPage;
						}

						// << 기호, 페이지 번호는 한번에 5개까지만 보여준다.
						// << 기호를 누르면 이전페이지 번호 5개를 보이게 하는 기능을 주자.
						if (startBlock == 1) {
							out.println("<span><a>&lt;&lt;<a></span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock - blockPerPage)
									+ "'>&lt;&lt;</a></span>");
						}

						// < 기호, 즉 한페이지 앞으로 가게 해주는 기호는 현재 페이지가 1페이질경우에는 아무 작동을 하지 않지만,
						// 1페이지가 아닐경우에는 한페이지 앞으로 가게 하는 기능을 준다.
						if (cpage == 1) {
							out.println("<span>&lt;</span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (cpage - 1) + "'>&lt;</a></span>");
						}

						out.println("&nbsp; &nbsp;");

						// 아무 이동도 하지 않고 이 게시판에 바로 들어왔을 때에는 주소창이 board_list1.jsp인 상태이다.
						// 하지만 아래의 페이지 번호를 누르게 된다면, 새로운 게시판 목록 창이 열리며 i가 함께 넘어간다.
						// 그렇게 넘어간 i페이지는 현재페이지를 나타내는 cpage에 할당되어 해당 페이지에서 보여야할 글 목록을 보여준다. 
						for (int i = startBlock; i <= endBlock; i++) {
							if (cpage == i) {
								out.println("<span><a><font color=blue>[" + i + "]</font></a></span>");
							} else {
								out.println("<span><a href='board_list1.jsp?cpage=" + i + "'>" + i + "</a></span>");
							}
						}

						out.println("&nbsp; &nbsp;");

						// > 기호, 즉 한페이지 뒤로 가게 해주는 기호는 현재 페이지가 마지막 페이질경우에는 아무 작동을 하지 않지만,
						// 마지막 페이지가 아닐경우에는 뒷페이지로 가게 하는 기능을 준다.
						if (cpage == totalPage) {
							out.println("<span>&gt;</span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (cpage + 1) + "'>&gt;</a></span>");
						}

						// >> 기호, 페이지 번호는 한번에 5개씩만 보여진다. >>를 누르면 다음 5개의 숫자가 보이고, 그 페이지로 이동할 수 있게 해주자.
						// 현재 페이지가 마지막 페이질경우에는 아무 작동을 하지 않지만,
						// 마지막 페이지가 아닐경우에는 마지막 페이지로 가게 하는 기능을 준다.
						if (totalPage <= endBlock) {
							out.println("<span><a>&gt;&gt;</a></span>");
						} else {
							out.println("<span><a href='board_list1.jsp?cpage=" + (startBlock + blockPerPage)
									+ "'>&gt;&gt;</a></span>");
						}
					%>
				</div>
			</div>
			<!--//페이지넘버-->
		</div>
	</div>
	<!--//하단 디자인 -->

</body>
</html>
