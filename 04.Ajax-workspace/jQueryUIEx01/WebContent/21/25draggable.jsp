<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{font-size:80%;}
	#draggable{width:150px;height:150px;padding:0.5em;}
</style>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#draggable').draggable({
			create: function(){
				console.log('create');
			},
			start: function(){
				console.log('start');
			},
			drag: function(){
				console.log('drag');
			},
			stop: function(){
				console.log('stop');
			}
		});
	});
</script>
</head>
<body>
	<div id="draggable" class="ui-widget-content">
		<p>드래그 영역</p>
	</div>
</body>
</html>