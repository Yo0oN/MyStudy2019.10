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
						// 태그이름을 통하여 해당 태그만 배열로 가져옴
						var names = data.getElementsByTagName('name');

						console.log(names);
						console.log(names.length);
						console.log(names[0].childNodes[0].nodeValue);

						for (var i = 0; i < names.length; i++) {
							console.log(names[i].childNodes[0].nodeValue);
						}
						
						Array.from(names).forEach(function(name) {
							console.log(name.childNodes[0].nodeValue);
						});
					} else {
						alert('error : ' + request.status + ", "
								+ request.readyState);
					}
				}

			};
			// 전송방식 설정
			request.open('get', './data/xml2.jsp', true);
			// 전송
			request.send();
		};
	};
</script>
</head>
<body>
	ajax08.jsp
	<br>
	<button id="btn">요청</button>
	<hr>
	<div id="result"></div>
</body>
</html>