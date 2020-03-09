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
			request.open('GET', './data/csv2.jsp', false);
			// 익스 O 크롬 X
			// 크로스 도메인 : 데이터와 html은 같은 ip에서 요청되어야 한다.
			request.send();

			var data = request.responseText.trim();
			var arrData = data.split('\n');

			var result = "<table width='600' border='1'>";
			for (var i = 0; i < arrData.length; i++) {
				var rowData = arrData[i].split(',');

				result += "<tr>";
				
				result += "<td>" + "ㅅㄷㄴㅅ" + rowData[0] + "</td>";
				result += "<td>" + rowData[1] + "</td>";
				result += "<td>" + rowData[2] + "</td>";
				result += "<td>" + rowData[3] + "</td>";
				
				result += "</tr>";
			}

			result += "</table>";
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
