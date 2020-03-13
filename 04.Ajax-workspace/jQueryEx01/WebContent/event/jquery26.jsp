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
<!-- CDN 서비스버전 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		document.getElementById('btn1').onclick = function() {
			$('div').remove();
		}
		document.getElementById('btn2').onclick = function() {
			$('div').empty();
		}
	});
</script>
</head>
<body>
	<button id="btn1">제거</button>
	<button id="btn2">제거</button>
	<div>
		<h2>Header - 0</h2>
		<h2>Header - 1</h2>
		<h2>Header - 2</h2>
	</div>
</body>
</html>