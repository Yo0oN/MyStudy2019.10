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
			// 객체 생성
			var request = new XMLHttpRequest();
			// 검색어 받아옴
			var search = document.getElementById('search').value;

			request.onreadystatechange = function() {
				// 통신성공 + 데이터 받아옴
				if (request.readyState == 4) {
					if (request.status == 200) {
						// proxy_ajax10.jsp의 객체를 가져옴
						var data = request.responseXML;

						var items = data.getElementsByTagName('item');

						var result = "<table border=1>";
						for (var i = 0; i < items.length; i++) {
							result += "<tr>";
							console
									.log(items[i].childNodes[1].childNodes[0].nodeValue);
							console
									.log(items[i].childNodes[5].childNodes[0].nodeValue);
							result += "<td>"
									+ items[i].childNodes[1].childNodes[0].nodeValue
									+ "</ td>";
							result += "<td>"
									+ items[i].childNodes[5].childNodes[0].nodeValue
									+ "</ td>";
							result += "</ tr>";
						}
						result += "</table>";

						document.getElementById('result').innerHTML = result;
					} else {
						alert('error : ' + request.status + ", "
								+ request.readyState);
					}
				}

			};
			// 전송방식 설정
			request.open('get', './proxy_ajax10.jsp?search='
					+ encodeURIComponent(search), true);
			// 전송
			request.send();
		};
	};
</script>
</head>
<body>
	ajax10.jsp
	<br>
	<input type="text" id="search">
	<button id="btn">요청</button>
	<hr>
	<div id="result"></div>
</body>
</html>