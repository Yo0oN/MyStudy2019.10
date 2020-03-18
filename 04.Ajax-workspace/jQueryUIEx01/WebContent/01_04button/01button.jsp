<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn1').button();
		$('input[type="submit"]').button();
		$('a').button();
		$('.btn3').button();
	});
</script>
<style type="text/css">
	.btn3 {font-size: 80%;}	<!--크기조절-->
</style>
</head>
<body>
<button>버튼</button><br>
<button id="btn1">버튼</button><br>
<input type="submit" value="버튼" /><br>
<a href="#">버튼</a><br>
<div class="btn3">버튼</div>
</body>
</html>