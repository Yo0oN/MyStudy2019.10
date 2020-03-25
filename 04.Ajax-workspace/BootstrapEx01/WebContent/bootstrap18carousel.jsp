<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.carousel-inner img{
	width:100%;
	height:100%;
}
</style>
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
	<div id="demo" class="carousel slide" data-ride="carousel">
		<!-- 사진 아래에 있는 현재 위치바 -->
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active" />
			<li data-target="#demo" data-slide-to="1" />
			<li data-target="#demo" data-slide-to="2" />
		</ul>
		
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="./image/la.jpg" />
				<div class="carousel-caption">
					<h3>Los Angeles</h3>
					<p>Hello!!</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="./image/ny.jpg" />
			</div>
			<div class="carousel-item">
				<img src="./image/chicago.jpg" />
			</div>
		</div>
		
		<!-- 좌우화살표 -->
		<a href="#demo" class="carousel-control-prev" data-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</a>
		<a href="#demo" class="carousel-control-next" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
</body>
</html>