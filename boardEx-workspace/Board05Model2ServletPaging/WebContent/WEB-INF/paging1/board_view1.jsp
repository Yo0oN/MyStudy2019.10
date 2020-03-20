<%@page import="ServletModelPagingModel.ServletPagingBoardTO"%>
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
	String cpage = request.getParameter("cpage");

	ServletPagingBoardTO to = (ServletPagingBoardTO) request.getAttribute("to");

	String seq = to.getSeq();
	String subject = to.getSubject();
	String writer = to.getWriter();
	String mail = to.getMail();
	String wip = to.getWip();
	String wdate = to.getWdate();
	String hit = to.getHit();
	String content = to.getContent();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_view.css">
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
			<!--게시판-->
			<div class="board_view">
				<table>
					<tr>
						<th width="10%">제목</th>
						<td width="60%"><%=subject%></td>
						<th width="10%">등록일</th>
						<td width="20%"><%=wdate%></td>
					</tr>
					<tr>
						<th>글쓴이</th>
						<td><%=writer%>(<%=mail%>)</td>
						<th>조회</th>
						<td><%=hit%></td>
					</tr>
					<tr>
						<td colspan="4" height="200" valign="top"
							style="padding: 20px; line-height: 160%"><%=content%></td>
					</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">
					<button type="button" class="btn_list btn_txt02"
						style="cursor: pointer;"
						onclick="location.href='./pagingController?action=list&cpage=<%=cpage%>'">목록</button>
				</div>
				<div class="align_right">
					<!-- 수정과 삭제를 할 때 seq를 이용하여 해당 글의 수정, 삭제를 할 수 있게 해준다. -->
					<button type="button" class="btn_list btn_txt02"
						style="cursor: pointer;"
						onclick="location.href='./pagingController?action=modify&seq=<%=seq%>&cpage=<%=cpage%>'">수정</button>
					<button type="button" class="btn_list btn_txt02"
						style="cursor: pointer;"
						onclick="location.href='./pagingController?action=delete&seq=<%=seq%>&cpage=<%=cpage%>'">삭제</button>
					<button type="button" class="btn_write btn_txt01"
						style="cursor: pointer;"
						onclick="location.href='./pagingController?action=write&cpage=<%=cpage%>'">쓰기</button>
				</div>
			</div>
			<!--//게시판-->
		</div>
	</div>
	<!-- 하단 디자인 -->

</body>
</html>
