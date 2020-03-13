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
				url : './data/json3.jsp',
				type : 'get',
				dataType : 'json',
				success : function(data) {
					/* console.log('성공 : ' + typeof(data));
					console.log(data); */
					$.each(data, function(index, value) {
						/* console.log(data[index]);
						console.log(value); */
						console.log(this);
						console.log(this.name);
					})
				},
				error : function(error) {
					// 실패시
					console.log('실패 : ' + error.status);
				}
			});
		})
	});
</script>
</head>
<body>
	<button id="btn">요청</button>
</body>
</html>