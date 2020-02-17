<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('submit1').onclick = function() {
			// 파일의 경로를 알 수 있다.
			//alert('입력 : ' + document.frm.upload.value);
			// 확장자만 분리해서 보기
			//var filePath = document.frm.upload.value
			//alert(document.frm.upload.value.slice(filePath.lastIndexOf("."), filePath.length));

			if (document.frm.upload.value == "") {
				alert('파일을 선택해주세요.');
				return false;
			} else {
				var ext = document.frm.upload.value.split('.');
				if (ext[ext.length - 1] != 'jpg'
						&& ext[ext.length - 1] != 'png'
						&& ext[ext.length - 1] != 'gif') {
					alert('이미지 파일을 선택해주세요.');
					return false;
				}
			}
			document.frm.submit();
		};
	};
</script>
</head>
<body>
	write.jsp
	<hr>
	<form action="./write_ok.do" method="post" name="frm"
		enctype="multipart/form-data">
		파일 : <input type="file" name="upload">
		<!-- 버튼의 type을 button으로 하면 파일을 검사하고 전송할수있다.
			확장자 검사같은거.. -->
		<input type="button" id="submit1" value="파일 전송">
	</form>
</body>
</html>