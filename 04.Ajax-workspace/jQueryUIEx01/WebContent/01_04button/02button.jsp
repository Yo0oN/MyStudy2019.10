<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/cupertino/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn1').button().on('click', function() {
			alert('click');
		});
		$('input[type="submit"]').button().on('click', function(e) {
			alert('click');
			// submit 기능을 제거하는 메서드
			e.preventDefault();
		});
		$('a').button().on('click', function(e) {
			alert('click');
		});
	});
</script>
<style type="text/css">
	.btn3 { font-size: 80%; <!-- 크기조절-- > }
</style>
</head>
<body>
	<form action="test.jsp" method="get">
		<!-- 전송기능 + form 기능이 함께있다. -->
		<button id="btn1">버튼</button>
		<br> <input type="submit" value="버튼">
	</form>
	<a href="https://www.naver.com">네이버</a>
</body>
</html>