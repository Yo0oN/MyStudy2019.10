<%@page import="com.exam.model1.SimpleBoard01TO"%>
<%@page import="com.exam.model1.SimpleBoard01DAO"%>
<%@page import="com.exam.model1.BoardListTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%
	request.setCharacterEncoding("utf-8");

	BoardListTO listTO = (BoardListTO) request.getAttribute("boardLists");

	int cpage = listTO.getCpage();
	int startBlock = listTO.getStartBlock();
	int endBlock = listTO.getEndBlock();
	int totalRecord = listTO.getTotalRecord();
	int totalPage = listTO.getTotalPage();
	int blockPerPage = listTO.getBlockPerPage();

	ArrayList<SimpleBoard01TO> boardlists = listTO.getBoardLists();

	StringBuffer sbHtml = new StringBuffer();

	for (SimpleBoard01TO to : boardlists) {
		String seq = to.getSeq();
		String subject = to.getSubject();
		String writer = to.getWriter();
		String wdate = to.getWdate();
		String hit = to.getHit();
		int wgap = to.getWgap();

		sbHtml.append("<tr>");
		sbHtml.append("<td>&nbsp;</td>");
		sbHtml.append("<td>" + seq + "</td>");
		sbHtml.append(
				"<td class='left'><a href='./view.do?seq=" + seq + "&cpage=" + cpage + "'>" + subject);
		if (wgap < 1) {
			sbHtml.append("</a>&nbsp;<img src='../../images/icon_hot.gif' alt='HOT'>");
		}
		sbHtml.append("</td>");
		sbHtml.append("<td>" + writer + "</td>");
		sbHtml.append("<td>" + wdate + "</td>");
		sbHtml.append("<td>" + hit + "</td>");
		sbHtml.append("<td>&nbsp;</td>");
		sbHtml.append("</tr>");
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
<link rel="stylesheet" type="text/css" href="./css/board_list.css">
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
					총 <span class="txt_orange"><%=totalRecord%></span>건
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
					<!-- 게시판 글 끝 -->
				</table>
			</div>
			<!--//게시판-->

			<!--페이지넘버-->
			<div class="paginate_regular">
				<div align="absmiddle">

					<%
						if (endBlock >= totalPage) {
							endBlock = totalPage;
						}

						// << 기호, 페이지 번호는 한번에 5개까지만 보여준다.
						// << 기호를 누르면 이전페이지 번호 5개를 보이게 하는 기능을 주자.
						if (startBlock == 1) {
							out.println("<span><a>&lt;&lt;<a></span>");
						} else {
							out.println("<span><a href='./list.do?cpage=" + (startBlock - blockPerPage)
									+ "'>&lt;&lt;</a></span>");
						}

						// < 기호, 즉 한페이지 앞으로 가게 해주는 기호는 현재 페이지가 1페이질경우에는 아무 작동을 하지 않지만,
						// 1페이지가 아닐경우에는 한페이지 앞으로 가게 하는 기능을 준다.
						if (cpage == 1) {
							out.println("<span>&lt;</span>");
						} else {
							out.println("<span><a href='./list.do?cpage=" + (cpage - 1) + "'>&lt;</a></span>");
						}

						out.println("&nbsp; &nbsp;");

						// 아무 이동도 하지 않고 이 게시판에 바로 들어왔을 때에는 주소창이 board_list1.jsp인 상태이다.
						// 하지만 아래의 페이지 번호를 누르게 된다면, 새로운 게시판 목록 창이 열리며 i가 함께 넘어간다.
						// 그렇게 넘어간 i페이지는 현재페이지를 나타내는 cpage에 할당되어 해당 페이지에서 보여야할 글 목록을 보여준다. 
						for (int i = startBlock; i <= endBlock; i++) {
							if (cpage == i) {
								out.println("<span><a><font color=blue>[" + i + "]</font></a></span>");
							} else {
								out.println("<span><a href='./list.do?cpage=" + i + "'>" + i + "</a></span>");
							}
						}

						out.println("&nbsp; &nbsp;");

						// > 기호, 즉 한페이지 뒤로 가게 해주는 기호는 현재 페이지가 마지막 페이질경우에는 아무 작동을 하지 않지만,
						// 마지막 페이지가 아닐경우에는 뒷페이지로 가게 하는 기능을 준다.
						if (cpage == totalPage) {
							out.println("<span>&gt;</span>");
						} else {
							out.println("<span><a href='./list.do?cpage=" + (cpage + 1) + "'>&gt;</a></span>");
						}

						// >> 기호, 페이지 번호는 한번에 5개씩만 보여진다. >>를 누르면 다음 5개의 숫자가 보이고, 그 페이지로 이동할 수 있게 해주자.
						// 현재 페이지가 마지막 페이질경우에는 아무 작동을 하지 않지만,
						// 마지막 페이지가 아닐경우에는 마지막 페이지로 가게 하는 기능을 준다.
						if (totalPage <= endBlock) {
							out.println("<span><a>&gt;&gt;</a></span>");
						} else {
							out.println("<span><a href='./list.do?cpage=" + (startBlock + blockPerPage)
									+ "'>&gt;&gt;</a></span>");
						}
					%>

				</div>
			</div>
			<!--//페이지넘버-->

			<div class="align_right">
				<!-- cpage를 다음 페이지로 넘기면, 이후에 글을 쓰다가 중단하고 목록버튼을눌렀을 때,
					원래 보던 목록으로 돌아올 수 있게 해준다. -->
				<button type="button" class="btn_write btn_txt01"
					style="cursor: pointer;"
					onclick="location.href='board_write1.jsp?cpage=<%=cpage%>'">쓰기</button>
			</div>
		</div>
	</div>
	<!--//하단 디자인 -->

</body>
</html>
