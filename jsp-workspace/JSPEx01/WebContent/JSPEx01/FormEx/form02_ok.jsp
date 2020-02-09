<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	form02_ok.jsp
	<hr>
	<%
		String id = request.getParameter("id");
		out.println("id : " + id + "</ br>");
	%>
</body>
</html>