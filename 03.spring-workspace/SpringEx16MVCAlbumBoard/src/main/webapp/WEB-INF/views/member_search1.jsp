<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		document.getElementById('submit1').onclick = function() {
			if (document.searchid.name.value.trim() == '') {
				alert('이름을 적어주세요!');
				return flase;
			}
			if (document.searchid.mail1.value.trim() == ''
					|| document.searchid.mail2.value.trim() == '') {
				alert('메일을 적어주세요!');
				return flase;
			}
			document.searchid.submit();
		};
		
		document.getElementById('submit2').onclick = function() {
			if (document.searchpassword.id.value.trim() == '') {
				alert('아이디를 적어주세요!');
				return flase;
			}
			if (document.searchpassword.mail1.value.trim() == ''
					|| document.searchpassword.mail2.value.trim() == '') {
				alert('메일을 적어주세요!');
				return flase;
			}
			document.searchpassword.submit();
		};
	};
</script>
</head>

<body>
	<!-- 상단 디자인 -->
	<div class="contents1">
		<!-- 아이디찾기 -->
		아이디 찾기
		<form action="./search_id_ok.do" method="post" name="searchid">
			<div class="contents_sub">
				<div class="board_write">
					<table>
						<tr>
							<th class="top">이름</th>
							<td class="top" colspan="3"><input type="text" name="name"
								value="" class="board_write_input_100" maxlength="5" /></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td colspan="3"><input type="text" name="mail1" value=""
								class="board_write_input_100" /> @ <input type="text"
								name="mail2" value="" class="board_write_input_100" /></td>
						</tr>
					</table>
				</div>

				<div class="btn_area">
					<div class="align_right">
						<input type="button" id="submit1" value="찿기"
							class="btn_list btn_txt02" style="cursor: pointer;" /> <input
							type="button" value="닫기" class="btn_write btn_txt01"
							style="cursor: pointer;" onclick="self.close()" />
					</div>
				</div>
				<!-- // 아이디찾기 -->
			</div>
		</form>

		<div class="contents1">
			비밀번호 찾기
			<!-- 비밀번호 찾기 -->
			<form action="search_password_ok.do" method="post" name="searchpassword">
				<div class="contents_sub">
					<div class="board_write">
						<table>
							<tr>
								<th class="top">아이디</th>
								<td class="top" colspan="3"><input type="text" name="id"
									value="" class="board_write_input_100" maxlength="5" /></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td colspan="3"><input type="text" name="mail1" value=""
									class="board_write_input_100" /> @ <input type="text"
									name="mail2" value="" class="board_write_input_100" /></td>
							</tr>
						</table>
					</div>

					<div class="btn_area">
						<div class="align_right">
							<input type="button" id="submit2" value="찿기"
								class="btn_list btn_txt02" style="cursor: pointer;" /> <input
								type="button" value="닫기" class="btn_write btn_txt01"
								style="cursor: pointer;" onclick="self.close()" />
						</div>
					</div>
					<!-- //비밀번호 찾기 -->
				</div>
			</form>
		</div>
	</div>
</body>
</html>
