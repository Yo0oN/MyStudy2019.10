<%@page import="model1.ZipcodeTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	우편번호 검색
	<hr>
	<form action="./zipcodeSearchOk.do" method="post">
		동 : <input type="text" name="dong"> <input type="submit"
			value="검색">
	</form>
</body>
</html>