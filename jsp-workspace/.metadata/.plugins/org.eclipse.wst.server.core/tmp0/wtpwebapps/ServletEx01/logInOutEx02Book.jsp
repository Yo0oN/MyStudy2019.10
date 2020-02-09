<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 인증</title>
</head>
<body>
	<%
		if (session.isNew() || session.getAttribute("id") == null) {
	%>

	<form action="./Log02Book" method="post">
		ID : <input type="text" name="id"><br> <br> Password
		: <input type="password" name="pwd"> <input type="submit"
			value="로그인">
	</form>

	<%
		} else {
	%>

	<a href="Log01Book"> 로그아웃 </a>

	<%
		}
	%>
</body>
</html>
