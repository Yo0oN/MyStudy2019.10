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

			request.onreadystatechange = function() {
				// 통신성공 + 데이터 받아옴
				if (request.readyState == 4) {
					if (request.status == 200) {
						// XML객체를 가져옴
						console.log(request.responseXML);
						var data = request.responseXML;

						var books = data.getElementsByTagName('book');

						console.log(books[0].childNodes.length);

						for (var i = 0; i < books.length; i++) {
							console.log(books[i]);
						}
						for (var i = 0; i < books.length; i++) {
							console
									.log(books[i].childNodes[0].childNodes[0].nodeValue);
						}
						for (var i = 0; i < books.length; i++) {
							for (var j = 0; j < books[i].childNodes.length; j++) {
								console
										.log(books[i].childNodes[j].childNodes[0].nodeValue);
							}
						}
					} else {
						alert('error : ' + request.status + ", "
								+ request.readyState);
					}
				}

			};
			// 전송방식 설정
			// 192.168.0.23
			request.open('get', 'http://192.168.0.29:8080/AjaxEx01/data/xml2.jsp', true);
			// 전송
			request.send();
		};
	};
</script>
</head>
<body>
	ajax09.jsp
	<br>
	<button id="btn">요청</button>
	<hr>
	<div id="result"></div>
</body>
</html>