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
			var request = new XMLHttpRequest();

			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						console.log(request.responseText.trim());
					} else {
						alert('서버 오류');
					}
				}
			};

			var data = document.getElementById('data').value;
			console.log(data);
			
			var url = './data/param.jsp?data=' + encodeURIComponent(data);
			request.open('GET', url, true);
			request.send();
		};
	};
</script>
</head>
<body>
	<input type="text" id="data" />
	<button id="btn">요청</button>
	<br><hr><br>
	<div id="result"></div>
</body>
</html>
