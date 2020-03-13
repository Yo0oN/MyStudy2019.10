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
		var object = {
			name : '홍길동'
		}
		console.log(object);
		// 객체에 내용추가하는 기존방식
		object.region1 = '서울시 종로구';
		object.part1 = '리터';
		console.log(object);
		
		$.extend(object, {region2 : '서울 강남구', part2 : '베이스'});
		console.log(object);
	});
</script>
</head>
<body>
</body>
</html>