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
		/* $('<h2>Hello jQuery</h2>').appendTo('body'); */
		/* $('<h2></h2>').html('Hello jQuery').appendTo('body');
		$('<h2></h2>').text('Hello jQuery').appendTo('body'); */
		/* document.getElementById('btn').onclick = function() {
			$('<h2></h2>').html('Hello jQuery').appendTo('div');
			$('<img />').attr('src', './images/Koala.jpg').appendTo('div');
			$('<img />').attr('src', './images/Koala.jpg')
				.attr('width', '100').appendTo('div');
			$('<img />').attr({
				src:'./images/Koala.jpg',
				width:'100'
			}).appendTo('div');
		} */
		/* var h1 = '<h1>Header1</h1>';
		var h2 = '<h2>Header1</h2>';
		$('body').append(h1, h2, h1, h2); */
		/* // 아래의 경우는 안된다.
		$(h1, h2, h1, h2).appendTo('body'); */
		// 책 75쪽
		var content = [ {
			name : '윤인성',
			region : '강서구'
		}, {
			name : '윤하린',
			region : '광진구'
		}, {
			name : '윤인아',
			region : 'CA'
		} ];
		$('div').append(function(index) {
			var item = content[index];
			var output = '';
			output += '<h1>' + item.name + '</h1>';
			output += '<h2>' + item.region + '</h2>';

			return output;
		});

	});
</script>
</head>
<body>
	<!-- <button id="btn">태그 추가</button>
	<hr> -->
	<div></div>
	<div></div>
	<div></div>
</body>
</html>