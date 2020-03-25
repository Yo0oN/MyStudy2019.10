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
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			</ul>
		</div>
	</nav>
	<br>

	<div class="container">
		<h3>Collapsible Navbar</h3>
		<p>In this example, the navigation bar is hidden on small screens
			and replaced by a button in the top right corner (try to re-size this
			window).</p>
		<p>Only when the button is clicked, the navigation bar will be
			displayed.</p>
		<p>Tip: You can also remove the .navbar-expand-md class to ALWAYS
			hide navbar links and display the toggler button.</p>
	</div>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<form class="form-inline" action="/action_page.php">
			<input class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-success" type="submit">Search</button>
		</form>
	</nav>
	<br>

	<div class="container">
		<h3>Navbar Forms</h3>
		<p>Use the .form-inline class to align form elements side by side
			inside the navbar.</p>
	</div>
</body>
</html>