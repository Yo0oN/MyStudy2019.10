<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 호출하기 -->
<!-- 서비스버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script> -->
<!-- CDN 서비스버전 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/* $('#btn1').on('click', function() {
			console.log('btn1 click');
		});
		$('#btn2').on('click', function() {
			console.log('btn2 click');
		}); */

		/* $('button').on('click', function() {
			console.log(this);
			//console.log($(this).attr('id'));

			if ($(this).attr('id') == 'btn1') {
				console.log('btn1 click');
			} else if ($(this).attr('id') == 'btn2') {
				console.log('btn2 click');
			}
		}); */
		/* $('button').on('mouseover', function() {
			console.log(this);
			//console.log($(this).attr('id'));

			if ($(this).attr('id') == 'btn1') {
				console.log('btn1 mouseover');
			} else if ($(this).attr('id') == 'btn2') {
				console.log('btn2 mouseover');
			}
		}); */
		$('h1').on('click', function(){
			$(this).html(function(index, html) {
				return html + '+';
			});
		});
	});
</script>
</head>
<body>
	<h1>click</h1>
	<button id="btn1">버튼1</button>
	<button id="btn2">버튼2</button>
</body>
</html>