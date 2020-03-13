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
	// 무한 스크롤
	$(document).ready(function() {
		// 스크롤 이벤트 발생 시
		$(window).scroll(function() {
			// 스크롤 높이
			var scrollHeight = $(window).scrollTop() + $(window).height();
			// 현재 페이지의 높이
			var documentHeight = $(document).height();
			// 만약 현재 페이지의 높이와 스크롤이 같을 때
			// 즉 현재 페이지의 마지막에 스크롤이 도달했을 때
			// 아래에 스크롤을 주기위해 내용을 추가한다.
			if (scrollHeight == documentHeight) {
				for (var i = 0; i < 10; i++) {
					$('<h1> Infinity Scroll</h1>').appendTo('body');
				}
			}
		});
	});

	// 일단 페이지에 내용이 있어야 스크롤이 발생할 테니
	// 스크롤을 만들기 위해 페이지에 내용을 추가함
	$(document).ready(function() {
		for (var i = 0; i < 20; i++) {
			$('<h1>Infinity Scroll</h1>').appendTo('body');
		}
	});
</script>
</head>
<body>

</body>
</html>