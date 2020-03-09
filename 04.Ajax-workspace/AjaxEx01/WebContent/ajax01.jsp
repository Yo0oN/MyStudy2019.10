<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('btn').onclick = function() {
			//alert('click!');
			var request = new XMLHttpRequest();
			//request.open('GET', './data/csv2.jsp', false);
			request.open('GET', 'http://localhost:8080/AjaxEx01/data/csv2.jsp', false);
			// 익스 O 크롬 X
			// 크로스 도메인 : 데이터와 html은 같은 ip에서 요청되어야 한다.
			// request.open('GET', 'http://192.168.0.23:8080/AjaxEx01/data/csv2.jsp', false);
			request.send();
			//console.log(request.responseText);
			document.getElementById('result').innerHTML = request.responseText;
		};
	};
</script>
</head>
<body>
	<button id="btn">요청</button>
	<br>
	<hr>
	<br>
	<div id="result"></div>
</body>
</html>
