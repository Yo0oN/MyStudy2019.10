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
			// 전송방식 설정
			request.open('get', './data/xml2.jsp', true);
			// 전송
			request.send();
			request.onreadystatechange = function() {
				// 통신성공 + 데이터 받아옴
				if (request.readyState == 4) {
					if (request.status == 200) {
						var xml2result = request.responseText.trim();

						xml2result = xml2result.replace(/books/g, 'table');
						xml2result = xml2result.replace(/book/g, 'tr');
						xml2result = xml2result.replace(/name/g, 'td');
						xml2result = xml2result.replace(/publisher/g, 'td');
						xml2result = xml2result.replace(/author/g, 'td');
						xml2result = xml2result.replace(/price/g, 'td');

						console.log(xml2result);
						document.getElementById('result').innerHTML = xml2result;
					} else {
						alert('error : ' + request.status + ", "
								+ request.readyState);
					}
				}

			};

		}
	};
</script>
</head>
<body>
	ajax07.jsp
	<button id="btn">요청</button>
	<hr>
	<div id="result"></div>
</body>
</html>