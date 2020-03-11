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
		$('tr:eq(0)').css('background', '#000000').css('color', 'white');
		$('td:nth-child(3n+1)').css('background', '#565656');
		$('td:nth-child(3n+2)').css('background', '#A9A9A9');
		$('td:nth-child(3n)').css('background', '#f9f9f9');
	});
</script>
</head>
<body>
	<table>
		<tr><th>이름</th><th>혈액형</th><th>지역</th></tr>
		<tr><td>강민수</td><td>AB</td><td>서울시 송파구</td></tr>
		<tr><td>구지연</td><td>B</td><td>미국 캘리포니아</td></tr>
		<tr><td>김미화</td><td>AB</td><td>미국 메사추세츠</td></tr>
		<tr><td>김선화</td><td>O</td><td>서울 강서구</td></tr>
		<tr><td>남기주</td><td>A</td><td>서울 노량진구</td></tr>
		<tr><td>윤하린</td><td>B</td><td>서울 용산구</td></tr>
	</table>
</body>
</html>