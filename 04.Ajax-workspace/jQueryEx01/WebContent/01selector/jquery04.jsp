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
		// $('h1').css('color', 'red');
		$('h' + '1').css('color', 'red');
		$('h2').css('color', 'yellow');
		
		var selector = 'h1';
		var attribute = 'color';
		var value = 'green';
		$(selector).css(attribute, value);
	});
</script>
</head>
<body>
	<h1>Hello jQuery h1</h1>
	<h2>Hello jQuery h2</h2>
	<h1>Hello jQuery h3</h1>
	<h2>Hello jQuery h4</h2>
</body>
</html>