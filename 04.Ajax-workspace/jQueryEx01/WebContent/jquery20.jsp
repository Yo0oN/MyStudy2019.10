<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('h1').each(function(index, item) {
			console.log(item);
		});
		$(document).find('h1').each(function(index, item) {
			console.log(item);
		});
		$('body').find('h1').each(function(index, item) {
			console.log(item);
		});
		$('body').find('h1').each(function(index, item) {
			console.log(this);
		});
	});
</script>
</head>
<body>
	<h1 class="select">Header-0</h1>
	<h2>Header-1</h2>
	<h1>Header-2</h1>
	<h2>Header-3</h2>
	<h1 class="select">Header-4</h1>
</body>
</html>