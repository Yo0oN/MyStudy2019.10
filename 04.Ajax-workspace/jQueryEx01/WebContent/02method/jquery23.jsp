<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		document.getElementById('btn1').onclick = function() {
			// 속성값을 가져올 때는 제일 처음 있는 데이터만 볼 수 있다.
			// arrt은 속성값을 가져오는 메서드이다.
			console.log($('img').attr('src'));
			// 반복문을 이용하여 가져와야 한다.
			$('img').each(function() {
				console.log($(this).attr('src'));
			});
			$('img').attr('width', 100);
		};
		document.getElementById('btn2').onclick = function() {
			// 하지만, 속성값을 '변경' 할때는 모든 속성값을 변경할 수 있다.
			/* $('img').attr ('width', 100); */
			// 그리고, attr함수 또한 내부에서 반복문이 있기 때문에,
			// 아래처럼 함수를 이용하여 속성을 변경할 수 있다.
			/* $('img').attr('width', function(index) {
				console.log(index);
				return (index + 1) * 100;
			}) */
			/* $('img').attr({
				width : 100,
				height : 100
			}) */
			$('img').attr({
				width : function(index) {
					return (index + 1) * 100;
				},
				height : 100,
				dataIndex: 10
			})
		};
		document.getElementById('btn3').onclick = function() {
			$('img').removeAttr('height');
		}
	});
</script>
</head>
<body>
	<button id="btn1">속성 내용</button>
	<button id="btn2">속성 내용</button>
	<button id="btn3">속성 내용</button>
	<br />
	<hr />
	<br />
	<img alt="해파리" src="./images/Jellyfish.jpg" width="150" />
	<img alt="사막" src="./images/Desert.jpg" width="150" />
	<img alt="수국" src="./images/Hydrangeas.jpg" width="150" />
	<img alt="등대" src="./images/Lighthouse.jpg" width="150" />
	<img alt="펭귄" src="./images/Penguins.jpg" width="150" />
</body>
</html>