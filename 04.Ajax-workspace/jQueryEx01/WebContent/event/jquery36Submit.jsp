<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 호출하기 -->
<!-- 서비스버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script> -->
<!-- 개발버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.js"></script> -->
<!-- CDN 서비스버전 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#my-form').submit(function(event) {
			var name = $('name').val();
			var password = $('#password').val();

			alert(name + ' : ' + password);

			event.preventDefault();
		})
	})
</script>
</head>
<body>
	<form id="my-form">
		<table>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
		</table>
		<input type="submit" value="제출" />
	</form>
</body>
</html>