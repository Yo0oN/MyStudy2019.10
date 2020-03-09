<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('btn1').onclick = function() {
			var request = new XMLHttpRequest();
			console.log('1');
			request.open('GET', './data/csv2.jsp', false);
			console.log('2');
			request.send();
			console.log('3');
			console.log(request.responseText);
			console.log('4');
		};

		document.getElementById('btn2').onclick = function() {
			var request = new XMLHttpRequest();
			console.log('1');

			request.onreadystatechange = function() {
				console.log('readystate : ' + request.readyState);
				/* if (request.readyState == 1) {
					console.log('1 : ' + request.responseText);
				} else if (request.readyState == 2) {
					console.log('2 : ' + request.responseText);
				} else if (request.readyState == 3) {
					console.log('3 : ' + request.responseText);
				} else if (request.readyState == 4) {
					console.log('4 : ' + request.responseText);
				} */
				if (request.readyState == 4) {
					console.log (request.status);
					console.log ('4 : ' + request.responseText)
				}
			};

			request.open('GET', './data/csv2.jsp', true);
			console.log('2');
			request.send();
			console.log('3');
			console.log(request.responseText);
			console.log('4');
		};
	};
</script>
</head>
<body>
	<button id="btn1">동기식 요청</button>
	<button id="btn2">비동기식 요청</button>
	<br>
	<hr>
	<br>
	<div id="result"></div>
</body>
</html>
