<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	form.jsp
	<hr>
	<!-- 일반 링크도 아래처럼 직접 적어서 데이터를 전송할 수 있지만,
		post방식이 아닌 get방식만 지원한다. 또 다국어처리가안되기 때문에,
		java.net.URLEncoder의 encode메소드를 이용하여 전송해주어야한다.-->
	<a href="./form_ok.jsp?data1=value1&data2=value2">form_ok.jsp</a>
	<hr>
	<%
		String han =URLEncoder.encode("한글", "utf-8");
	%>
	<!-- 영어가 아닌 다국어를 사용할 때는 java.net.URLEncoder의
	encode메소드를 이용하여 인코딩해준 후 사용해야 한다. -->
	<a href="./form_ok.jsp?data1=<%=han %>">form_ok.jsp</a>
	<hr>
	<form action="./form_ok.jsp" method="get">
		데이터 1 : <input type="text" name="data1" />
		데이터 2 : <input type="text" name="data2" />
		<input type="submit" value="전송하기" />
	</form>
	<hr>
	<!-- 보이지 않는다고하여 암호화 된것은 아니다! -->
	<form action="./form_ok.jsp" method="post">
		데이터 1 : <input type="text" name="data1" />
		데이터 2 : <input type="text" name="data2" />
		<input type="submit" value="전송하기" />
	</form>
</body>
</html>