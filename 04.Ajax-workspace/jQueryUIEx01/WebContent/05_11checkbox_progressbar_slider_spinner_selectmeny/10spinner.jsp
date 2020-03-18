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
		$('#spinner').spinner({
			min:4,
			max:10,
			step:2,
			spin:function(event, ui) {
				console.log(ui.value);
			}
		});
		$('#btn1').button().on('click', function(){
			$('#spinner').spinner('value', 8)
		})
		$('#btn2').button().on('click', function(){
			alert($('#spinner').spinner('value'))
		})
	});
</script>
</head>
<body>
<button id="btn1">set</button>
<button id="btn2">set</button><br>
<!-- spinner는 여기서 기본값을 지정해준다. -->
<input type="text" id="spinner" value="5" />
</body>
</html>