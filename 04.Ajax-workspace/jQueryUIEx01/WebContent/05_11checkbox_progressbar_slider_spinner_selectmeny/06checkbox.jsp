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
		$('input[type="checkbox"]').checkboxradio({
			icon: false
		}).on('click', function(){
			alert('click');
		});
		$('input[type="radio"]').checkboxradio({
			icon: false
		}).on('change', function(){
			alert('change');
		});;
	});
</script>
<style type="text/css">
body { font-size: 80%; }
</style>
</head>
<body>
	<fieldset>
		<legend>과일</legend>
		<label><input type="checkbox" name="cb1" />사과</label>
		<label><input type="checkbox" name="cb2" /> 수박</label>
		<label><input type="checkbox" name="cb3" /> 딸기</label>
	</fieldset>
	<br>
	<fieldset>
		<legend>과일</legend>
		<label><input type="radio" name="cb" />사과</label>
		<label><input type="radio" name="cb" /> 수박</label>
		<label><input type="radio" name="cb" /> 딸기</label>
	</fieldset>
</body>
</html>