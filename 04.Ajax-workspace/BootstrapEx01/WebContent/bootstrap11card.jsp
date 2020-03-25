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

	});
</script>
</head>
<body>
	<div class="container">
		<h2>Card Image</h2>
		<p>Image at the top (card-img-top):</p>
		<div class="card" style="width: 400px">
			<img class="card-img-top" src="./image/Penguins.jpg" alt="Card image"
				style="width: 100%">
			<div class="card-body">
				<h4 class="card-title">John Doe</h4>
				<p class="card-text">Some example text some example text. John
					Doe is an architect and engineer</p>
				<a href="#" class="btn btn-primary">See Profile</a>
			</div>
		</div>
		<br>

		<p>Image at the bottom (card-img-bottom):</p>
		<div class="card" style="width: 400px">
			<div class="card-body">
				<h4 class="card-title">Jane Doe</h4>
				<p class="card-text">Some example text some example text. Jane
					Doe is an architect and engineer</p>
				<a href="#" class="btn btn-primary">See Profile</a>
			</div>
			<img class="card-img-bottom" src="./image/Penguins.jpg" alt="Card image"
				style="width: 100%">
		</div>
	</div>
</body>
</html>