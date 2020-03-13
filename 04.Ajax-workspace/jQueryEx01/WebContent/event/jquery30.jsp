<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

div {
	margin: 5px;
	padding: 3px;
	border: 3px solid black;
	border-radius: 10px;
}
</style>
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('div').click(function() {
			var header = $('h1', this).text();
			var paragraph = $('p', this).text();

			alert(header + '\n' + paragraph);
		})
	});
</script>

</head>
<body>
	<div>
		<h1>Header 1</h1>
		<p>Paragraph</p>
	</div>
	<div>
		<h1>Header 2</h1>
		<p>Paragraph</p>
	</div>
	<div>
		<h1>Header 3</h1>
		<p>Paragraph</p>
	</div>
</body>
</html>