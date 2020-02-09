<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	zipcode_ok.jsp
	<hr>
	<%
		out.println("동이름 : " + request.getParameter("dong") + "<br>");
		out.println("새로운 데이터 : " + (String) request.getAttribute("data") + "<br>");
	%>
</body>
</html>