<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	시작<br>
	<%
		String i = "10";
	%>
	<jsp:forward page="c.jsp">
		<jsp:param value="<%=i%>" name="i" />
	</jsp:forward>
	끝<br>
</body>
</html>