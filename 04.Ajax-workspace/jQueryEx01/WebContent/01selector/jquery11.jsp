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
		$('table').css('width', '800');
		// odd : 홀수번째 객체 선택
		//$('tr:odd').css('background-color', '#f9f9f9')
		// 2n+1번째 위치하는 객체 선택(1, 3, 5, ...)
		$('tr:nth-child(2n+1)').css('background-color', '#f9f9f9')
		// even : 짝수번째 선택
		$('tr:even').css('background-color', '#9f9f9f')
		// 여러조건을 이어서 붙일 수 있다. 순차적으로 적용된다.
		$('tr:first').css('background-color', '#000000').css('color', '#ffffff')
		// $('tr:first').css('color', '#ffffff')
	});
</script>
</head>
<body>
	<table>
		<tr><th>이름</th><th>혈액형</th><th>지역</th></tr>
		<tr><th>강민수</th><th>AB</th><th>서울시 송파구</th></tr>
		<tr><th>구지연</th><th>B</th><th>미국 캘리포니아</th></tr>
		<tr><th>김미화</th><th>AB</th><th>미국 메사추세츠</th></tr>
		<tr><th>김선화</th><th>O</th><th>서울 강서구</th></tr>
		<tr><th>남기주</th><th>A</th><th>서울 노량진구</th></tr>
		<tr><th>윤하린</th><th>B</th><th>서울 용산구</th></tr>
	</table>
</body>
</html>