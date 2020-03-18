<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready( function() {
		$('#search').button().on( 'click', function() {
			// 검색 버튼을 누르면 동을 가져온다.
			var dong = encodeURIComponent($('#dong').val());

			// 동을 검색한다.
			$.ajax({
				url : './data/zipsearch.jsp?dong=' + dong,
				type : 'get',
				dataType : 'json',
				success : function(result) {
					// 이전에 값이 있었다면 지운다.
					$('#accordion').empty();

					var accod = '';
					$.each(result, function(index, item) {
						accod += '<p>' + this.seq + ' ['
								+ item.zipcode + ']</p>';
						accod += '<p>' + this.sido + ' '
								+ this.gugun + ' ' + this.dong
								+ ' ' + this.ri + ' '
								+ this.bunji + '</p>';
					})
					$('#accordion').accordion();
					$('#accordion').append(accod);
					$('#accordion').accordion('refresh');
				},
				error : function() {
					alert('error!');
				}
			})
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>우편번호 검색기</legend>
		<label for="dong">동 :</label> <input type="text" id="dong" /> <input
			type="button" id="search" value="검색" />
	</fieldset>
	<br>
	<div id="accordion"></div>
</body>
</html>