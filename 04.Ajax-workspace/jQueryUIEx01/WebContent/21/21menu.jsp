<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 body {font-size:80%}
 .ui-menu{width:200px}
</style>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#menu').menu();
	});
</script>
</head>
<body>
	<ul id="menu">
		<!-- class="ui-state-disabled"를 이용하여 메뉴 비활성화 -->
		<li class="ui-state-disabled"><div>Toys (n/a)</div></li>
		<li><div><span class="ui-icon ui-icon-disk"></span>Books</div></li>
		<li><div><span class="ui-icon ui-icon-zoomin"></span>Clothing</div></li>
		<li><div>Electronics</div>
			<ul>
				<li class="ui-state-disabled"><div><span class="ui-icon ui-icon-zoomout"></span>Home Entertainment</div></li>
				<li><div>Car Hifi</div></li>
				<li><div>Utilities</div></li>
			</ul></li>
		<li><div>Movies</div></li>
		<li><div>Music</div>
			<ul>
				<li><div>Rock</div>
					<ul>
						<li><div>Alternative</div></li>
						<li><div>Classic</div></li>
					</ul></li>
				<li><div>Jazz</div>
					<ul>
						<li><div>Freejazz</div></li>
						<li><div>Big Band</div></li>
						<li><div>Modern</div></li>
					</ul></li>
				<li><div>Pop</div></li>
			</ul></li>
		<li class="ui-state-disabled"><div>Specials (n/a)</div></li>
	</ul>
</body>
</html>