<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#draggable1, #draggable2 {
	width: 100px;
	height: 100px;
	padding: 0.5em;
	float: left;
	margin: 10px 10px 10px 0;
}

#droppable {
	width: 150px;
	height: 150px;
	padding: 0.5em;
	float: left;
	margin: 10px;
}
</style>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// revert : valid draggable을 끌어온 후 멈췄을 때 멈춘 자리에 있는다.
		// 하지만 invalid를 하면 doppable 공간으로 가지않는이상
		// 원래 자신의 자리로 돌아간다.
		$('#draggable1').draggable({revert:'valid'});
		$('#draggable2').draggable({revert:'invalid'});
		// droppable공간을 만든다.
		$('#droppable').droppable({
			// 무언가가 droppable에 drop된다면
			drop:function(event, ui){
				// droppable태그에 클래스를 추가해서
				// 해당 클래스에 해당하는 style을 추가하고,
				// p를 찾아 그 내용을 Dropped!로 바꿔준다.
				$(this).addClass('ui-state-highlight').find('p').html('Dropped!');
			}
		});
	});
</script>
</head>
<body>
	<!-- 영역안에 들어가지 않으면 drop되지 않음 -->
	<div id="draggable1" class="ui-widget-content">
		<p>Drag me to my target</p>
	</div>
	
	<div id="draggable2" class="ui-widget-content">
		<p>Drag me to my target</p>
	</div>
	
	<div id="droppable" class="ui-widget-header">
		<p>Drop here</p>
	</div>
</body>
</html>