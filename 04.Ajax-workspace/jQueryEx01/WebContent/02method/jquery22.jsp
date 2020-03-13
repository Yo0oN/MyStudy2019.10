<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.high-light {
	background-color: yellow;
}

.high-light-0 {
	background-color: yellow;
}

.high-light-1 {
	background-color: orange;
}

.high-light-2 {
	background-color: blue;
}
</style>
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* document.getElementById('btn1').onclick = function() {
			$('h2').addClass('high-light');
		};
		document.getElementById('btn2').onclick = function() {
			$('h2').removeClass('high-light');
		};
		document.getElementById('btn3').onclick = function() {
			$('h2').toggleClass('high-light');
		}; */
		document.getElementById('btn1').onclick = function() {
			/* $('h2').each(function(index, item) {
				$(this).addClass('high-light-' + index);
			}); */
			// 함수 중심 프로그램(제어문이 함수 내부에 들어가 함수를 제어한다.)
			$('h2').addClass(function(index) {
				console.log(index);
				return ('high-light-' + index);
			});
		}
	});
</script>
</head>
<body>
	<button id="btn1">클래스 추가</button>
	<button id="btn2">클래스 제거</button>
	<button id="btn3">클래스 토글</button>
	<br />
	<hr />
	<br />
	<h2>item - 0</h2>
	<h2>item - 1</h2>
	<h2>item - 2</h2>
</body>
</html>