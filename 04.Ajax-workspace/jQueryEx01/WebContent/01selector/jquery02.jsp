<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.js"></script> -->
<!-- 서비스버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script> -->
<!-- CDN 서비스버전 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	// $ jquery의 특수 기호
	// 이벤트
	// $(document).ready() == window.onload
	// 자바스크립트에서는 window.onload를 한번만 사용 가능하였으나,
	// jQuery를 이용하면 여러번 사용 가능하며, 순서대로 진행된다.
	// (하지만 시작점으로 구분되기 때문에 문서에서 1번만 나오는것이 좋다.)
	$(document).ready(function() {
		console.log('Hello jQuery 1');
	});
	// $는 식별자로, jQuery를 나타낸다. 그래서 $대신 jQuery라 직접적으로 써도 된다.
	jQuery(document).ready(function() {
		console.log('Hello jQuery 2');
	});
	// $(document).ready()를 줄여서 $()로만 사용도 가능하다.
	$(function() {
		console.log('Hello jQuery 3');
	})
</script>
</head>
<body>

</body>
</html>