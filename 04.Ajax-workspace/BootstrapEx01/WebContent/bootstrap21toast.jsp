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
		$('#myBtn').click(function(){
			$('.toast').toast('show');
		});
	});
</script>
</head>
<body>
	<div class="container">
		<button type="button" class="btn btn-secondary" id="myBtn">Toast!</button>
		
		<div class="toast">
			<div class="toast-header">
				Toast Header
			</div>
			<div class="toast-body">
				Toast Body
			</div>
		</div>
	</div>
</body>
</html>