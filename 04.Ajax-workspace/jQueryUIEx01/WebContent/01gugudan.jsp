<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#start').spinner({
			min : 1
		});
		$('#end').spinner({
			min : 2
		});

		$('#btn').button().on('click', function() {
			// 이전에 내용이 있다면 먼저 비우기
			$('#accordion').empty();
			// 시작단 끝단 값 가져오기
			var start = $('#start').spinner('value');
			var end = $('#end').spinner('value');
			
			// 시작단이 크면 알림창
			if (start > end) {
				alert('시작단은 끝단보다 작아야합니다!');
			} else {
				// 시작단이 더작으면 구구단시작
				for (var i = start; i <= end; i++) {
					var gugudan = '<h3>' + i + ' 단<h3>';

					gugudan += '<div>';
					gugudan += '<ul>';
					for (var j = 1; j < 10; j++) {
						gugudan += '<li>';
						gugudan += i + 'x' + j + '=' + i * j;
						gugudan += '</li>';
					}
					gugudan += '</ul>';
					gugudan += '</div>';
					// accordion 만들고 구구단 넣고 새로고침
					$('#accordion').accordion();
					$('#accordion').append(gugudan);
					$('#accordion').accordion('refresh');
				}
			}
		});
		$('#btn2').button().on('click', function() {
			// 초기화 누르면 내용 비우기
			$('#accordion').empty();
		})
	})
</script>
</head>
<body>
	시작단 :
	<input type="text" id="start" value="1" /> 끝단 :
	<input type="text" id="end" value="2" />
	<input type="button" id="btn" value="구구단">
	<input type="button" id="btn2" value="초기화">
	<hr>
	<div id="accordion"></div>
</body>
</html>