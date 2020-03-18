<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url : './data/json01.jsp',
			type : 'get',
			dataType : 'json',
			success : function(json) {
				var availableTags = json.data;
				$('#tags').autocomplete({
					source : availableTags
				});
			},
			error : function() {
				alert('error')
			}
		})
	});
</script>
</head>
<body>
<div class="ui-widget">
	<label for="tags">프로그램 언어 : </label>
	<input type="text" id="tags">
</div>
</body>
</html>