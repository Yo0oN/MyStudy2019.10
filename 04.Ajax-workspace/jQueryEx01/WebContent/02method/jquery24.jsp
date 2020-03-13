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
			/* var result = document.getElementById('result');

			console.log(result);
			console.log(typeof(result));
			console.log(result.innerHTML); */
			console.log($('#result').html());
			$('#result').html('hello');
		}
		
		document.getElementById('btn2').onclick = function() {
			//$('#result').html('<b>Hello jQuery</b>');
			//$('#result').text('<b>Hello jQuery</b>');
			//$('div').html('<b>Hello jQuery</b>');
			/* $('div').html(function(index){
				return '<b>Hello jQuery </b>' + index;
			}); */
			$('div').text(function(index){
				return '<b>Hello jQuery </b>' + index;
			});
		}
	});
</script>
</head>
<body>
	<button id="btn1">내용</button>
	<button id="btn2">내용</button>
	<br />
	<hr />
	<br />
	<div id="result">출력 내용</div>
	<div>출력 내용</div>
	<div>출력 내용</div>
</body>
</html>