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
	<!-- jumbotron으로 위에 머리부분을 표현 -->
	<div class="jumbotron text-center" style="margin-botton:0">
		<h1>My First Bootstrap 4 Page</h1>
		<p>Resize this responsive page to see the effect!</p>
	</div>
	<!-- 상단바에 메뉴 -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNabvar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-link">
					<a class="nav-link" href="#">Link</a>
				</li>
				<li class="nav-link">
					<a class="nav-link" href="#">Link</a>
				</li>
				<li class="nav-link">
					<a class="nav-link" href="#">Link</a>
				</li>
			</ul>
		</div>
	</nav>
	<!-- 컨테이너 만듬 -->
	<div class="container" style="margin-top:30px">
		<div class="row">
		<!-- 컨테이너의 화면중 1/3에는 나에대한 설명 -->
			<div class="col-sm-4">
				<h2>About Me</h2>
				<h5>Photo of me : </h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text about me in culpa qui officia deserunt mollit anim..</p>
				<h3>Some Links</h3>
				<p>Lorem ipsum dolor sit ame.</p>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item">
						<a class="nav-link active" href="#">Active</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Link</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">Link</a>
					</li>
					<!-- 작동안하는 메뉴 -->
					<li class="nav-item">
						<a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<hr class="d-sm-non">
			</div>
			<!-- 화면중 나머지 2/3은 게시글 -->
			<div class="col-sm-8">
				<h2>TITLE HEADING</h2>
				<h5>Title description, Dec 7, 2017</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text...</p>
				<p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>

				<br>

				<h2>TITLE HEADING</h2>
     			<h5>Title description, Sep 2, 2017</h5>
 			    <div class="fakeimg">Fake Image</div>
 			    <p>Some text..</p>
			    <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
			</div>
		</div>
	</div>
	<!-- 마지막 부분 jumbotron -->
	<div class="jumbotron text-center" style="margin-botton:0">
		<p>Footer</p>
	</div>
</body>
</html>