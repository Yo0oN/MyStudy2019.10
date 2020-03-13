<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#canvas {
	border: 1px solid black;
}
</style>
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#canvas').on('click', function(e) {
			console.log(e.pageX + ' / ' + e.pageY);
		})
		// canvas API
		var canvas = document.getElementById('canvas');
		var context = canvas.getContext('2d');

		$('#canvas').on({
			mousedown : function(e) {
				var x = e.pageX;
				var y = e.pageY;
				
				context.beginPath();
				context.moveTo(x, y);
			},
			mouseup: function(e) {
				var x = e.pageX;
				var y = e.pageY;
				
				context.lineTo(x,y);
				context.stroke();
			}
		});
	});
</script>

</head>
<body>
	<canvas id="canvas" width="700" height="400"></canvas>
</body>
</html>