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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// jQuery : DOM에 접근을 도와주는 라이브러리 (CSS의 selector와 비슷하다.)
		// 모든 태그(*)의 css color를 red로 변경
		$('*').css('color', 'red');
	});
</script>
</head>
<body>
	<h1>Hello jQuery h1</h1>
	<h2>Hello jQuery h2</h2>
</body>
</html>