<%@page import="com.exam.model1.Design_albumMemberTO"%>
<%@page import="com.exam.model1.Design_album01TO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Design_albumMemberTO to = (Design_albumMemberTO) request.getAttribute("to");

	String cpage = to.getCpage();
	String id = "";
	String[] mail = new String[2];
	//로그인 처리
	// 로그인 설정시 사용할 flag
	int loginflag = 1;

	if (session.getAttribute("id") == null) {
		// 로그인 세션이 없으면 로그인화면을 보여준다.
		mail[0] = mail[1] = "";
	} else if (session.getAttribute("id") != null) {
		// 로그인세션이 있다면 아래로
		loginflag = 0;
		id = to.getId();
		mail = to.getMail().split("@");
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
<link rel="stylesheet" type="text/css" href="./css/board_write.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('write1').onclick = function() {
			if (document.frm.info.checked == false) {
				alert('개인정보 수집 및 이용을 동의해 주세요.');
				return false;
			}
			if (document.frm.writer.value.trim() == '') {
				alert('작성자를 적어주세요.');
				return false;
			}
			if (document.frm.subject.value.trim() == '') {
				alert('제목을 적어주세요.');
				return false;
			}
			if (document.frm.password.value == '') {
				alert('비밀번호를 적어 주세요.');
				return false;
			}
			document.frm.submit();
		}
<%if (loginflag == 1) {%>
	<jsp:include page="loginJS.jsp"></jsp:include>
<%} else {
			}%>
	}
</script>
</head>

<body>
	<!-- 상단 디자인 -->
	<div class="contents1">
		<div class="con_title">
			<p style="margin: 0px; text-align: right">
				<img style="vertical-align: middle" alt=""
					src="./images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
			</p>
		</div>
		<!-- 로그인 시작 -->
		<%
			if (loginflag == 1) {
		%>
		<jsp:include page='loginform.jsp' />
		<%
			} else {
				// 로그인이 되어있다면 환영폼보여줌
		%>
		<jsp:include page='afterloginform.jsp'>
			<jsp:param value="<%=id%>" name="id" />
		</jsp:include>
		<%
			}
		%>
		<!-- 로그인 끝 -->
		
		<form action="./write_ok.do" method="post" name="frm"
			enctype="multipart/form-data">
			<div class="contents_sub">
				<!--게시판-->
				<div class="board_write">
					<table>
						<tr>
							<th class="top">글쓴이</th>
							<td class="top" colspan="3"><input type="text" name="writer"
								value="<%=id%>" class="board_view_input_mail" maxlength="5"
								<%if (loginflag == 0) {
				out.println("readonly ");
			}%> />
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" name="subject" value=""
								class="board_view_input" /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td colspan="3"><input type="password" name="password"
								value="" class="board_view_input_mail" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3"><textarea name="content"
									class="board_editor_area"></textarea></td>
						</tr>
						<tr>
							<th>파일첨부</th>
							<td colspan="3"><input type="file" name="upload" value=""
								class="board_view_input" accept="image/*" /></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td colspan="3"><input type="text" name="mail1"
								value="<%=mail[0]%>" class="board_view_input_mail"
								<%if (loginflag == 0) {
				out.println("readonly ");
			}%> />
								@ <input type="text" name="mail2" value="<%=mail[1]%>"
								class="board_view_input_mail"
								<%if (loginflag == 0) {
				out.println("readonly ");
			}%> /></td>
						</tr>
					</table>

					<table>
						<tr>
							<br />
							<td
								style="text-align: left; border: 1px solid #e0e0e0; background-color: f9f9f9; padding: 5px">
								<div
									style="padding-top: 7px; padding-bottom: 5px; font-weight: bold; padding-left: 7px; font-family: Gulim, Tahoma, verdana;">※
									개인정보 수집 및 이용에 관한 안내</div>
								<div style="padding-left: 10px;">
									<div
										style="width: 97%; height: 95px; font-size: 11px; letter-spacing: -0.1em; border: 1px solid #c5c5c5; background-color: #fff; padding-left: 14px; padding-top: 7px;">
										1. 수집 개인정보 항목 : 회사명, 담당자명, 메일 주소, 전화번호, 홈페이지 주소, 팩스번호, 주소 <br />
										2. 개인정보의 수집 및 이용목적 : 제휴신청에 따른 본인확인 및 원활한 의사소통 경로 확보 <br /> 3.
										개인정보의 이용기간 : 모든 검토가 완료된 후 3개월간 이용자의 조회를 위하여 보관하며, 이후 해당정보를 지체
										없이 파기합니다. <br /> 4. 그 밖의 사항은 개인정보취급방침을 준수합니다.
									</div>
								</div>
								<div
									style="padding-top: 7px; padding-left: 5px; padding-bottom: 7px; font-family: Gulim, Tahoma, verdana;">
									<input type="checkbox" name="info" value="1"
										class="input_radio"> 개인정보 수집 및 이용에 대해 동의합니다.
								</div>
							</td>
						</tr>
					</table>
				</div>

				<div class="btn_area">
					<div class="align_left">
						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='./list.do?cpage=<%=cpage%>'">목록</button>
					</div>
					<div class="align_right">
						<button type="button" id="write1" class="btn_write btn_txt01"
							style="cursor: pointer;">등록</button>
					</div>
				</div>
				<!--//게시판-->
			</div>
		</form>
	</div>
	<!-- 하단 디자인 -->

</body>
</html>
