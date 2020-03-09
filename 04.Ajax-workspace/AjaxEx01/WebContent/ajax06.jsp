<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		// 버튼 누르면
		document.getElementById('btn').onclick = function() {
			// 객체 생성
			var request = new XMLHttpRequest();
			// data 가져오기
			var data = document.getElementById('data').value;
			// 객체가 모든 데이터를 다 받아오고, 통신도 성공했다면
			// 콘솔에 보데이터 보여줌
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200) {
						document.getElementById('result').innerHTML += request.responseText
								.trim()
								+ "<br>";
						console.log(request.responseText.trim());
					} else {
						alert('error : ' + request.status);
					}
				}
			};
			// 페이지와 연결
			var url = './data/param.jsp?data=' + encodeURIComponent(data);
			request.open('GET', url, true);
			// 데이터 보냄
			request.send();
		};

		// 초기화 버튼 누르면 데이터 사라짐
		document.getElementById('reset').onclick = function() {
			document.getElementById('result').innerHTML = '';
		}
	};
</script>
</head>
<body>
	<input type="text" id="data" />
	<button id="btn">요청</button>
	<button id="reset">초기화</button>
	<br>
	<hr>
	<br>
	<div id="result"></div>
</body>
</html>
