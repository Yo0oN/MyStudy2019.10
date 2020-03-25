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
	<div class="container-fluid">
		<h1>Basic Grid Structure</h1>
		<p>Resize the browser window to see the effect.</p>
		<p>The first, second and third row will automatically stack on top
			of each other when the screen is less than 576px wide.</p>

		<div class="container-fluid">
			<!-- Control the column width, and how they should appear on different devices -->
			<div class="row">
				<div class="col-6" style="background-color: yellow;">50%</div>
				<div class="col-6" style="background-color: orange;">50%</div>
			</div>
			<br>

			<div class="row">
				<div class="col-4" style="background-color: yellow;">33.33%</div>
				<div class="col-4" style="background-color: orange;">33.33%</div>
				<div class="col-4" style="background-color: yellow;">33.33%</div>
			</div>
			<br>

			<!-- Or let Bootstrap automatically handle the layout -->
			<div class="row">
				<div class="col-sm" style="background-color: yellow;">25%</div>
				<div class="col-sm" style="background-color: orange;">25%</div>
				<div class="col-sm" style="background-color: yellow;">25%</div>
				<div class="col-sm" style="background-color: orange;">25%</div>
			</div>
			<br>

			<div class="row">
				<div class="col" style="background-color: yellow;">25%</div>
				<div class="col" style="background-color: orange;">25%</div>
				<div class="col" style="background-color: yellow;">25%</div>
				<div class="col" style="background-color: orange;">25%</div>
			</div>
			<br>
			
			<div class="row">
				<div class="col-sm-4" style="background-color: yellow;">.col-sm</div>
				<div class="col-sm-8" style="background-color: orange;">.col-sm</div>
			</div>
			
		</div>
	</div>
</body>
</html>