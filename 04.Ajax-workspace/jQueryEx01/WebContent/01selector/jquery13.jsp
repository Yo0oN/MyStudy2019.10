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
		var array = [ {
			name : 'daum', link : 'https://www.daum.net'
		}, {
			name : 'naver', link : 'https://www.naver.com'
		}, {
			name : 'google', link : 'https://www.google.com'
		} ];

		// 기존방식
		for (var i = 0; i < array.length; i++) {
			console.log(array[i].name + ' : ' + array[i].link);
		}
		for ( var i in array) {
			console.log(array[i].name + ' : ' + array[i].link);
		}
		array.forEach(function(item) {
			console.log(item.name + ' : ' + item.link);
		});
		// jQuery 배열이나에 사용할 수 있다.
		$.each(array, function(index, item) {
			console.log(item.name + ' : ' + item.link);
		});
		var object = {
			name : '홍길동',
			region : '서울시 강남구',
			part : '베이스'
		};
		$.each(object, function(key, item) {
			console.log(key + ' : ' + item);
		});
		$('h2').each(function(index, item) {
			console.log(item);
		});
		$('h2').each(function(index, item) {
			console.log(typeof (item));
			console.log(item.innerHTML);
			item.innerHTML = 'Hello';
		});
		$('h2').each(function() {
			console.log(this.innerHTML);
		});
	});
</script>
</head>
<body>
	<h2>item - 0</h2>
	<h2>item - 1</h2>
	<h2>item - 2</h2>
	<h2>item - 3</h2>
	<h2>item - 4</h2>
</body>
</html>