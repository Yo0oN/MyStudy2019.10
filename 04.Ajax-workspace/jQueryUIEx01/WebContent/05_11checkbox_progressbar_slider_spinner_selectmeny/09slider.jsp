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
		$('#slider').slider({
			range:true,
			min:0,
			max:255,
			values:[25,100],
			slide:function(event, ui) {
				console.log($('#slider').slider('values'));
				console.log(ui.values[0] + " / " + ui.value[1]);
				console.log(event);
				console.log(ui);
				console.log($('#slider').slider())
			}
		});
		$('#btn').click(function(){
			console.log($('#slider').slider('values'));
		})
	});
</script>
</head>
<body>
<div id="slider"></div>
<button id="btn">버튼</button>
</body>
</html>