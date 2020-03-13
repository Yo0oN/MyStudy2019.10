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
		//$('input[type="text"]').css('background','red');
		// 속성^=값 : 부분검색-속성 안의 값이 특정값으로 시작하는 객체 선택 
		//$('input[type ^="te"]').css('background','blue');
		// 입력양식 필터 선택자
		// 요소:type - input 태그 중 type인 객체를 선택한다.
		$('input:text').css('background','yellow');
		$('input:password').css('background','green');
	});
</script>
</head>
<body>
	<input type="text" />
	<br /><br />
	<input type="password" />
</body>
</html>
