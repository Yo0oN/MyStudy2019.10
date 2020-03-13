<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 호출하기 -->
<!-- 서비스버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script> -->
<!-- CDN 서비스버전 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* $('h1').click(function() {
			$(this).html(function(index, html) {
				return html + '★';
			});
		}); */
		/* setInterval(function() {
			$('h1').last().trigger('click');
		}, 1000); */
		/* $('h1').click(function(event, data1, data2) {
			alert(data1 + ' : ' + data2);
		});
		$('h1').eq(1).trigger('click', [ 273, 52 ]); */
		$('h1').dblclick(function() {
			alert('1');
		})
	});
</script>
</head>
<body>
	<h1>Start :</h1>
	<h1>Start :</h1>
</body>
</html>