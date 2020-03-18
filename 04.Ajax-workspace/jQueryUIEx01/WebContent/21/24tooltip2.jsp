<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var tooltips = $('[title]').tooltip({
			position:{
				my:'left top',
				at: 'right+5 top-5',
				collision:'none'
			}
		});
		$('<button>').text('Show help').button().on('click', function(){
			tooltips.tooltip('open');
		}).insertAfter('form');
	});
</script>
</head>
<body>
	<form>
		<fieldset>
			<div>
				<label for="firstname">Firstname</label> <input id="firstname"
					name="firstname" title="Please provide your firstname.">
			</div>
			<div>
				<label for="lastname">Lastname</label> <input id="lastname"
					name="lastname" title="Please provide also your lastname.">
			</div>
			<div>
				<label for="address">Address</label> <input id="address"
					name="address" title="Your home or work address.">
			</div>
		</fieldset>
	</form>
</body>
</html>