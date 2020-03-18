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
		$('#progressbar').progressbar({
			value: 40
		});
		$('#btn1').button().on('click', function(){
			$('#progressbar').progressbar({
				value: $('#progressbar').progressbar('value') -5
			})
		});
		$('#btn1').button().on('click', function(){
			var value = $('#progressbar').progressbar('value');
			$('#progressbar').progressbar('value', value -5);
		});
		$('#btn2').button().on('click', function(){
			$('#progressbar').progressbar({
				value: $('#progressbar').progressbar('value') + 5
			})
		});
	});
</script>
</head>
<body>
	<div id="progressbar"></div> <br>
	<div id="btn1">감소 -5</div>
	<div id="btn2">증가 +5</div>
</body>
</html>