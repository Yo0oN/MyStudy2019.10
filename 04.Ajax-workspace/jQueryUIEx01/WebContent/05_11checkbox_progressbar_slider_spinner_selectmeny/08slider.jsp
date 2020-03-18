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
		$('#slider').slider();
		$('#btn').on('click', function(){
			console.log($('#slider').slider('value'));
		})
		$('#slider').slider({
			//orientation: 'vertical',
			value:50,
			min: 0,
			max: 100,
			// 변화가 끝나면 알려준다.
			/* change: function() {
				console.log($('#slider').slider('value'));
			}, */
			// 변화 중에도 알려준다.
			/* slide: function(){
				console.log($('#slider').slider('value'));
			} */
			/* slide: function(e, ui){
				console.log(e);
				console.log(ui);
				console.log(ui.value);
			} */
		});
	});
</script>
</head>
<body>
<div id="slider"></div>
<button id="btn"></button>
</body>
</html>