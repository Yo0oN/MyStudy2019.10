<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단</h2>
	<hr>
	<form action="formSelfGugudan01.jsp" method="get">
		시작단 : <input type="text" name="start" /><br>
		<br> 끝단 : <input type="text" name="end" /> <input type="submit"
			value="전송" />
	</form>
	<hr>
	<%
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			
		} else {
			int start = Integer.parseInt(request.getParameter("start"));
			int end = Integer.parseInt(request.getParameter("end"));
			out.println(start);
			out.println(end);
		}
	%>
</body>
</html>