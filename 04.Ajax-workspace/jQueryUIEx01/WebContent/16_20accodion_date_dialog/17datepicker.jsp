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
		$('#datepicker1').datepicker();
		$('#datepicker2').datepicker();
		$("#format").on('change', function(){
			$('#datepicker2').datepicker('option', 'dateFormat', $(this).val());
		})
	});
</script>
</head>
<body>
	<div> Date : <input type="text" id="datepicker1" /></div>
	<br>
	<hr>
	<br>
	<div> Date : <input type="text" id="datepicker2" /></div>
	<p>Format options:<br />
	<select id="format">
		<option value="mm/dd/yy">Default - mm/dd/yy</option>
		<option value="yy-mm-dd">ISO 8601 - yy-mm-dd</option>
		<option value="d M, y">Short - d M, y</option>
		<option value="d MM, y">Medium - d MM, y</option>
		<option value="DD, d MM, yy">Full - DD, d MM, yy</option>
		<option value="'day' d 'of' MM 'in the year' yy">With text - 'day' d 'of' MM 'in the year' yy</option>
	</select>
</p>
</body>
</html>
