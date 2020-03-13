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
		$('textarea').keyup(function() {
			// 남은 글자수 구하기
			var inputLength = $(this).val().length;
			var remain = 150 - inputLength;

			$('h1').html(remain);
			
			if (remain >= 0) {
				$('h1').css('color', 'black');
			} else {
				$('h1').css('color', 'red');
			}
		})
	});
</script>
</head>
<body>
	<div>
		<p>지금 내 생각을</P>
		<h1>158</h1>
		<textarea cols="70" rows="5"></textarea>
	</div>
</body>
</html>