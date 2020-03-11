<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		// h3객체의 배경을 주황색으로 준 후, 홀수번째의 색은 빨강으로 한다.
		$('h3').css('background-color', 'orange').filter(':even').css(
				'color', 'red');
		// 아래는 모두 같은말
		$('h3').css('background-color', 'orange');
		$('h3').filter(':even').css('color', 'red');
		$('h3').filter(':odd').css('color', 'white');
		
		$('h3').css({backgroundColor: 'orange', color:'red'}).filter(':odd').css('color', 'white');

		$('h3').css('background-color', 'orange')
			.filter(':even').css('color', 'red').end()
			.filter(':odd').css('color', 'white');
		});
</script>
</head>
<body>
	<h3>Header-0</h3>
	<h3>Header-1</h3>
	<h3>Header-2</h3>
	<h3>Header-3</h3>
	<h3>Header-4</h3>
	<h3>Header-5</h3>
</body>
</html>