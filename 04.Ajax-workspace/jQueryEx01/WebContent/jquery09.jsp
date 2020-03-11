<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.js"></script> -->
<!-- 서비스버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script> -->
<!-- CDN 서비스버전 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		document.getElementById('btn').onclick = function() {
			// alert('click');
			var text = $('select > option:selected').text();
			alert(text);
		}
	});
</script>
</head>
<body>
	<select id="sel">
		<option value="1">사과</option>
		<option value="2">수박</option>
		<option value="3">딸기</option>
		<option value="4">참외</option>
	</select>
	<form name="frm">
		<select id="sel" name="sel">
			<option value="1">사과</option>
			<option value="2">수박</option>
			<option value="3">딸기</option>
			<option value="4">참외</option>
		</select>
	</form>
	<br />
	<br />
	<input type="button" id="btn" value="선택" />
</body>
</html>
