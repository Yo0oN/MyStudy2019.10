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
			// json 읽어오기
			var request = new XMLHttpRequest();

			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						var data = request.responseText.trim();

						var json = JSON.parse(data);

						for (var i = 0; i < json['data'].length; i++) {
							console.log(json['data'][i]['rank'] + ' / ' + json['data'][i]['keyword']);
						}
					} else {
						alert('error : ' + request.status + ", "
								+ request.readyState);
					}
				}
			}

			request.open('get', 'https://www.naver.com/srchrank', true);
			request.send();
		}
	}
</script>
</head>
<body>
	ajax11.jsp
	<button id="btn">json3.jsp</button>
	<hr>
	<div id="result"></div>
</body>
</html>