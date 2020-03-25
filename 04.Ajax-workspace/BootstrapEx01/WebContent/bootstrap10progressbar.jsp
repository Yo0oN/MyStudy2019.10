<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="./css/bootstrap.css" />
<!-- jquery -->
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<!-- bootstrap -->
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#up').button().on('click', function() {
			console.log($('#progress').parent().css('width'));
			var width = parseInt($('div[class*=progress-bar]').attr('style').substring(6,9));
			if (width != 100) {
				$('div[class*=progress-bar]').attr('style', 'width:' + (width + 10) + '%');
			}
			/* $('#progress').css('width','50%'); */
		});
		$('#down').button().on('click', function() {
			var width = parseInt($('div[class*=progress-bar]').attr('style').substring(6,9));
			if (width != 0) {
				$('div[class*=progress-bar]').attr('style', 'width:' + (width - 10) + '%');
			}
			/* $('#progress').css('width','20%'); */
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h2>Animated Progress Bar</h2>
		<p>Add the .progress-bar-animated class to animate the progress
			bar:</p>
		<div class="progress">
			<div id="progress" class="progress-bar progress-bar-striped progress-bar-animated"
				style="width: 40%"></div>
		</div>
		<br>
		<button id="down" type="button" class="btn btn-danger">감소</button>
		<button id="up" type="button" class="btn btn-primary">증가</button>
	</div>
</body>
</html>