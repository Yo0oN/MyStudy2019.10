<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery 라이브러리 호출하기 -->
<!-- 서비스버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script> -->
<!-- 개발버전 -->
<!-- <script type="text/javascript" src="./js/jquery-3.4.1.js"></script> -->
<!-- CDN 서비스버전 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btn').on('click', function() {
			$.ajax({
				url : './data/xml2.jsp',
				type : 'get',
				dataType : 'xml',
				success : function(data) {
					/* console.log('성공 : ' + data);
					console.log(typeof(data)); */

					/* var names = data.getElementsByTagName('name');
					for (var i = 0; i < names.length; i++) {
						console.log(names[i].childNodes[0].nodeValue);
					} */

					/* $(data).find('name').each(function() {
						console.log($(this).text());
					}) */
					var table = '';
					table += '<table border=1>';
					$(data).find('book').each(function(index) {
						table += '<tr>';
						table += '<td>' + $(this).find('name').text() + '</td>';
						table += '<td>' + $(this).find('publisher').text() + '</td>';
						table += '<td>' + $(this).find('author').text() + '</td>';
						table += '<td>' + $(this).find('price').text() + '</td>';
						table += '<tr>';
					})
					table += '</ table>';
					
					$(table).appendTo('div');
				},
				error : function(error) {
					// 실패시
					console.log('실패 : ' + error.status);
				}
			});
		})
	});
</script>
</head>
<body>
	<button id="btn">요청</button>
	<hr>
	<div></div>
</body>
</html>