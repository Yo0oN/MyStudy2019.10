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
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- bootstrap -->
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
		$('[data-toggle="popover"]').popover();
	});
</script>
</head>
<body>
	<div class="container">
		<h3>Tooltip</h3>
		<br><br><br>
		<a href="#" data-toggle="tooltip" title="Hooray!">Hover over me!</a>
		<a href="#" data-toggle="tooltip" data-placement="top" title="Hooray!">Top!</a>
		<a href="#" data-toggle="tooltip" data-placement="bottom" title="Hooray!">Bottom!</a>
		<a href="#" data-toggle="tooltip" data-placement="left" title="Hooray!">Left!</a>
		<a href="#" data-toggle="tooltip" data-placement="right" title="Hooray!">Right!</a>
		<hr>
		<h3>Popover</h3>
		<a href="#" data-toggle="popover" title="Popover Header" data-content="Popover Content">Click me!</a>
		<a href="#" data-toggle="popover" data-placement="top" title="Popover Header" data-content="Popover Content">Top!</a>
		<a href="#" data-toggle="popover" data-placement="bottom" title="Popover Header" data-content="Popover Content">Bottom!</a>
		<a href="#" data-toggle="popover" data-placement="left" title="Popover Header" data-content="Popover Content">Left!</a>
		<a href="#" data-toggle="popover" data-placement="right" title="Popover Header" data-content="Popover Content">Right!</a>
	</div>
</body>
</html>