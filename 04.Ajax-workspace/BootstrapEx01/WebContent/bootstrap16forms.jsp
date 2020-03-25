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
		<h2>Stacked form</h2>
		<form action="/action_page.php">
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Enter password"
					name="pswd">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<hr>
	<div class="container">
		<h2>Inline form</h2>
		<form class="form-inline" action="/action_page.php">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email"> <label for="pwd">Password:</label> <input
				type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="pswd">
			<div class="form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember">
					 Remember me 
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>