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
		$('.c1').css('color', 'red');
		$('.c1.c2').css('color', 'orange');
	});
</script>
</head>
<body>
<h1 class="c1">Hello jQuery 1</h1>
<h2 class="c1 c2">Hello jQuery 2</h2>
<h1 class="c2">Hello jQuery 3</h1>
<h2 class="c3">Hello jQuery 4</h2>

</body>
</html>