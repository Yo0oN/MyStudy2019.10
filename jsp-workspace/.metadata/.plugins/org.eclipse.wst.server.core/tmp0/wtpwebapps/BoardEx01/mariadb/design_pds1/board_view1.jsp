<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("utf-8");
	String cpage = request.getParameter("cpage");

	// list 페이지에서 seq를 가져온다.
	String seq = request.getParameter("seq");

	String subject = "";
	String writer = "";
	String mail = "";
	String wip = "";
	String wdate = "";
	String hit = "";
	String content = "";
	String filename = "";
	String filesize = "";

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
		String sql = "update pds_board1 set hit=hit+1 where seq = ?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);

		pstmt.executeQuery();

		sql = "select subject, writer, mail, wip, wdate, hit, content, filename, filesize from pds_board1 where seq = ?";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			subject = rs.getString("subject");
			writer = rs.getString("writer");
			mail = rs.getString("mail");
			wip = rs.getString("wip");
			wdate = rs.getString("wdate");
			hit = rs.getString("hit");
			// 이곳은 HTML문서 안이기 때문에 사용자가 줄바꿈을 하여 글을 입력하여도,
			// 불러올때는 \n을 인식하지 못하기 때문에 <br>로 바꿔주어야 HTML이 인식할 수 있다.
			content = rs.getString("content") == null ? "" : rs.getString("content").replaceAll("\n", "</br>");

			if (rs.getString("filesize") == "") {
				filesize = "0";
			} else {
				filesize = rs.getString("filesize");
			}

			// 파일을 누르면 다운받을 수 있게 해주자.
			if (filesize != "0") {
				//filename = "<a href='../../upload/" + rs.getString("filename") + "'>" + rs.getString("filename") + " 다운로드</a> ";
				filename = "<a href='download.jsp?filename=" + rs.getString("filename") + "'>"
						+ rs.getString("filename") + " 다운로드</a> ";
			} else {
				filename = rs.getString("filename");
			}
			// img나 txt처러 브라우저가 내용을 해석할 수 있는것들은 링크를 눌렀을 때 내용이 보인다.
			// 하지만 읽을 수 없는 경우에는 다운로드해준다.
		}
	} catch (NamingException e) {
		System.out.println("error1 : " + e.getMessage());
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
<link rel="stylesheet" type="text/css" href="../../css/board_view.css">
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
						<th>첨부 파일</th>
						<td><%=filename%>(<%=filesize%>Kbyte)</td>
						<th></th>
						<td></td>
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
						onclick="location.href='board_list1.jsp?seq=<%=seq%>&cpage=<%=cpage%>'">목록</button>
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
	</div>
	<!-- 하단 디자인 -->

</body>
</html>