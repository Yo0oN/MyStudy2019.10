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
<!-- CDN 서비스버전 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	var xml = '';
	xml += '<friends>';
	xml += '<friend>';
	xml += '<name>연하진</name>';
	xml += '<language>Ruby</language>';
	xml += '</friend>';
	xml += '<friend>';
	xml += '<name>윤명월</name>';
	xml += '<language>Basic</language>';
	xml += '</friend>';
	xml += '<friend>';
	xml += '<name>윤하린</name>';
	xml += '<language>C#</language>';
	xml += '</friend>';
	xml += '</friends>';

	$(document).ready(function() {
		var xmlDoc = $.parseXML(xml);

		/* document.body.innerHTML = xml;
		var output = '';
		$('friend').each(function(index) {
			output += '<div>';
			output += '<h1>' + $(this).find('name').text() + '</h1>';
			output += '<p>' + $(this).find('language').text() + '</p>';
			output += '</div>';

			console.log(output);
		});
		document.body.innerHTML = output; */
		$(xmlDoc).find('friend').each(function(index) {
			var output = '';
			output += '<div>';
			output += '<h1>' + $(this).find('name').text() + '</h1>';
			output += '<p>' + $(this).find('language').text() + '</p>';
			output += '</div>';

			document.body.innerHTML += output;
		});
	});
</script>
</head>
<body>

</body>
</html>