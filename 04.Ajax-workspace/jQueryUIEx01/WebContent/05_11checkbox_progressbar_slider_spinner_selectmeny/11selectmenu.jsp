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
		$('#files').selectmenu({
			sidth:500,
			change:function(event, ui){
				console.log(ui.item.value)
			}
		});
	});
</script>
</head>
<body>
<select id="files">
	<option value="jQuery">jQuery.js</option>
	<option value="jQueryUI">ui.jQuery.js</option>
	<option value="jQueryMobile" selected="selected">mobile.jQuery.js</option>
	<option value="jQueryTest">test.jQuery.js</option>
</select>
</body>
</html>