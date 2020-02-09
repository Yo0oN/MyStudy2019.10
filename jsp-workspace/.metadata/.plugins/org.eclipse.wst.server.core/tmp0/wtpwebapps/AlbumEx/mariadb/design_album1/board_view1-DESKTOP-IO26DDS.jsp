﻿<%@page import="java.util.ArrayList"%>
<%@page import="AlbumBeans.Design_album01DAO"%>
<%@page import="AlbumBeans.Design_album01TO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");

	Design_album01TO to = new Design_album01TO();
	to.setSeq(seq);

	Design_album01DAO dao = new Design_album01DAO();

	ArrayList<Design_album01TO> toLists = new ArrayList<Design_album01TO>();
	toLists = dao.board_view1(seq);

	String subject = toLists.get(0).getSubject();
	String writer = toLists.get(0).getWriter();
	String content = toLists.get(0).getContent();
	String[] mail = new String[2];
	if (!toLists.get(0).getMail().equals("")) {
		mail = toLists.get(0).getMail().split("@");
	} else {
		mail[0] = "";
		mail[1] = "";
	}
	String filename_ch = "";
	if (!toLists.get(0).getFilename_ch().equals("")) {
		filename_ch = "<img src='../../upload/" + toLists.get(0).getFilename_ch()
				+ "' width='900' onerror='' /><br/>";
	}
	String hit = toLists.get(0).getHit();
	String wdate = toLists.get(0).getWdate();

	String com_writer = "";
	String com_comment = "";
	String com_date = "";

	StringBuffer sbHTML = new StringBuffer();

	for (int i = 1; i < toLists.size(); i++) {
		com_writer = toLists.get(i).getCom_writer();
		com_comment = toLists.get(i).getCom_comment();
		com_date = toLists.get(i).getCom_date();

		sbHTML.append("<tr>");
		sbHTML.append("<td class='coment_re' width='20%'><strong>" + com_writer + "</strong>");
		sbHTML.append(" (" + com_date + ")");
		sbHTML.append("<div class='coment_re_txt'>" + com_comment + "</div></td>");
		sbHTML.append("</tr>");
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
<link rel="stylesheet" type="text/css" href="../../css/board_view.css">
<script type="text/javascript">
	window.onload = function() {
		document.cfrm.cbutton.onclick = function() {
			if (document.cfrm.cwriter.value.trim() == '') {
				alert('글쓴이를 입력해 주세요.')
				return false;
			}
			if (document.cfrm.cpassword.value.trim() == '') {
				alert('글쓴이를 입력해 주세요.')
				return false;
			}
			document.cfrm.submit();
		}
	}
</script>
</head>

<body>
	<!-- 상단 디자인 -->
	<div class="contents1">
		<div class="con_title">
			<p style="margin: 0px; text-align: right">
				<img style="vertical-align: middle" alt=""
					src="../../images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
			</p>
		</div>

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
						<td><%=writer%></td>
						<th>조회</th>
						<td><%=hit%></td>
					</tr>
					<tr>
						<td colspan="4" height="200" valign="top"
							style="padding: 20px; line-height: 160%">
							<div id="bbs_file_wrap">
								<div>
									<%=filename_ch%><br />
								</div>
							</div> <%=content%>
						</td>
					</tr>
				</table>

				<table>
					<%=sbHTML%>
					<!-- <tr>
						<td class="coment_re" width="20%"><strong>54545</strong>
							(2016.09.19 02:00)
							<div class="coment_re_txt">Test</div></td>
					</tr>
					<tr>
						<td class="coment_re" width="20%"><strong>하오리</strong>
							(2016.09.19 07:54)
							<div class="coment_re_txt">우리는 민족 중흥의 역사적 사명을 띄고 이 땅에 태어났다.
								조상의 빛난 얼을 오늘에 되살려</div></td>
					</tr> -->
				</table>

				<form action="board_view1_ok.jsp" method="post" name="cfrm">
					<input type="hidden" value="<%=seq%>" name="seq">
					<input type="hidden" value="<%= cpage %>" name="cpage">
					<table>
						<tr>
							<td width="94%" class="coment_re">글쓴이 <input type="text"
								name="cwriter" maxlength="5" class="coment_input" />&nbsp;&nbsp;
								비밀번호 <input type="password" name="cpassword"
								class="coment_input pR10" />&nbsp;&nbsp;
							</td>
							<td width="6%" class="bg01"></td>
						</tr>
						<tr>
							<td class="bg01"><textarea name="ccontent" cols="" rows=""
									class="coment_input_text"></textarea></td>
							<td align="right" class="bg01">
								<button id="cbutton" type="button" class="btn_re btn_txt01">댓글등록</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="btn_area">
				<div class="align_left">
					<button type="button" class="btn_list btn_txt02"
						style="cursor: pointer;" onclick="location.href='board_list1.jsp?cpage=<%=cpage%>'">목록</button>
				</div>
				<div class="align_right">
					<button type="button" class="btn_list btn_txt02"
						style="cursor: pointer;"
						onclick="location.href='board_modify1.jsp?seq=<%=seq%>&cpage=<%=cpage%>'">수정</button>
					<button type="button" class="btn_list btn_txt02"
						style="cursor: pointer;"
						onclick="location.href='board_delete1.jsp?seq=<%=seq%>&cpage=<%=cpage%>'">삭제</button>
					<button type="button" class="btn_write btn_txt01"
						style="cursor: pointer;"
						onclick="location.href='board_write1.jsp?seq=<%=seq%>&cpage=<%=cpage%>'">쓰기</button>
				</div>
			</div>
			<!--//게시판-->
		</div>
		<!-- 하단 디자인 -->
	</div>

</body>
</html>