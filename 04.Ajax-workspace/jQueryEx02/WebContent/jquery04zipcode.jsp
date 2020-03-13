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
			// input text에 입력된 value값을 가져온다.
			var dong = $('#dong').val();
			// dong이 비어있다면 알람을, 비어있지않으면 요청을
			if (dong == "") {
				alert('동이름을 입력해주세요.');
			} else {
				$('#result').html('');
				$.ajax({
					// 동을 zipcode_json페이지로 인코딩해서 보내준다.
					url : './data/zipcode_json.jsp?dong=' + encodeURIComponent(dong),
					type : 'get',
					dataType : 'json',
					success : function(data) {
						/* console.log('성공 : ' + typeof(data));
						console.log(data); */
						if (data.length != 0){
							var result = '<table border=1>';
							result += '<tr><td>zipcode</td><td>sido</td><td>gugun</td><td>dong</td><td>ri</td><td>bunfi</td><td>seq</td></tr>';
							$.each(data, function(index, item){
								//console.log(this.seq);
								//console.log(this.zipcode);
								result += '<tr>';
								result += '<td>' + item.zipcode + '</td>';
								result += '<td>' + item.sido + '</td>';
								result += '<td>' + item.gugun + '</td>';
								result += '<td>' + item.dong + '</td>';
								result += '<td>' + item.ri + '</td>';
								result += '<td>' + item.bunji + '</td>';
								result += '<td>' + item.seq + '</td>';
								result += '</tr>';
							})
							result += '</ table>';
							$(result).appendTo('#result');
						} else {
							$('<p><b>검색 결과가 없습니다.</b></p>').appendTo('#result');
						}
					},
					error : function(error) {
						// 실패시
						console.log('실패 : ' + error.status);
					}
				});

			}
		})
	});
</script>
</head>
<body>
	<input type="text" id="dong" size="25" />
	<button id="btn">요청</button>
	<br>
	<hr>
	<div id="result"></div>
</body>
</html>