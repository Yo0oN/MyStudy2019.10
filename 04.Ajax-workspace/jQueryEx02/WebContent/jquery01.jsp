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
<!-- 개발버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.js"></script> -->
<!-- CDN 서비스버전 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn').on('click', function() {
			$.ajax({
				// get방식이므로 url뒤에 데이터를 보내주거나,
				// 데이터를 따로 전송해준다.
				// 다국어를 전송할 경우 encoding해주기
				url : './data/param.jsp',
				// post방식일 경우 이렇게 사용한다. (get도 사용가능하긴함)
				data : {
					data : 'hello'
				},
				type : 'get', // 전송타입
				dataType : 'text',
				success : function(data) {
					// 응답데이터 처리 위치
					// 성공시. data:응답으로 받아온 데이터
					console.log('성공 : ' + data);
				},
				error : function(error) {
					// 실패시
					console.log('실패 : ' + error.status);
				}
			});
		})
	});
	/* $(document).ready(function() {
		$('#btn').on('click', function() {
			$.ajax({
				// get방식이므로 url뒤에 데이터를 보내준다.
				// 다국어를 전송할 경우 encoding해주기
				url : './data/param.jsp?data=hello',
				type : 'get', // 전송타입
				dataType : 'text',
				success : function(data) {
					// 응답데이터 처리 위치
					// 성공시. data:응답으로 받아온 데이터
					console.log('성공 : ' + data);
				},
				error : function(error) {
					// 실패시
					console.log('실패');
					console.log('status : ' + error.status);
					console.log('responseText : ' + error.resonseText);
				}
			});
		})
	}); */
</script>
</head>
<body>
	<button id="btn">요청</button>
</body>
</html>