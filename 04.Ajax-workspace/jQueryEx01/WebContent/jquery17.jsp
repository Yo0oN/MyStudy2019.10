<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* $('h3:even').css({
			backgroundColor : 'black',
			color : 'white'
		});
		
		$('h3').filter(':even').css({
			backgroundColor : 'black',
			color : 'white'
		}); */
		// true, false를이용하여, 새로운 조건을 줄 수도 있다.
		/* $('h3').filter(function(index, item) {
			console.log(item);
			return index % 2 == 0;
		}).css('backgroundColor', 'yellow'); */
		// 조건을 객체로 제공해 줄수도 있다.
		// 대신 문자열로 설정하는것이 아니기 때문에,
		// -기호를 쓸 수 없다. 그러므로 문자연결은 대문자를 이용한다.
		$('h3').filter(function(index, item) {
			console.log(item);
			return index % 2 == 0;
		}).css({
			backgroundColor : 'blue',
			color : 'white'
		});
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