<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	zipcode.jsp
	<hr>
	<form action="./MVC01ZipcodeController" method="post">
		<input type="hidden" name="action" value="zipcode_ok">
		동이름 : <input type="text" name="dong">
		<input type="submit" value="전송하기">
	</form>
</body>
</html>