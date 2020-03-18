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
<!-- 다국어 처리를 위한 라이브러리들 -->
<script type="text/javascript" src="../js/i18n/datepicker-ko.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#datepicker1').datepicker({
			dateFormat: 'yy-mm-dd',
			showAnim : 'slide',
			numberOfMonths: 3
		});
		// 한글처리
		$('#datepicker1').datepicker('option', $.datepicker.regional['ko']);
	});
</script>
</head>
<body>
	<div> Date : <input type="text" id="datepicker1" /></div>
</body>
</html>
