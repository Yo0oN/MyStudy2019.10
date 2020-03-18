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
		$('#btn1').button({
			icon: 'ui-icon-gear',
			iconPosition: 'end'
		});
		$('#btn2').button({
			icon: 'ui-icon-flag',
			iconPosition: false
		});
	});
</script>
</head>
<body>
<button id="btn1">버튼</button><br>
<button id="btn2">버튼</button><br>
</body>
</html>