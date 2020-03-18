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
		$('#dialog').dialog({
			autoOpen : false, // dialog를 만들지만 자동으로 열리지 않는다.
			modal : true, // dialog가 열린동안 다른것은 클릭 못함
			height : 150,
			// 열릴 때 애니메이션
			show: {
				effect: 'blind',
				duration: 1000 //밀리초
			},
			// 닫을 때 애니메이션
			hide: {
				effect: 'explode',
				duration: 1000
			},
			// 버튼 추가하기
			buttons: {
				// 버튼 클릭에 대한 이벤트
				'취소' : function() {
					alert('취소');
				},
				'확인' : function() {
					alert('확인');
					// 창 닫기
					$(this).dialog('close');
				}
			}
		});
		$('#btn1').button().on('click', function(){
			// 버튼을 눌러야만 열린다.
			// 반대로 close도 있으나 modal기능을 사용하면
			// close버튼을 따로 만드는의미가 없다.
			$('#dialog').dialog('open');
		});
	});
</script>
</head>
<body>
	<button id="btn1">열기</button>
	<hr>
	<div id="dialog" title="jQuery Dialog">
		<h1>Hello jQuery</h1>
	</div>
</body>
</html>