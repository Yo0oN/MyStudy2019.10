<%@page import="model1.ELBookEx01"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="book" class="model1.ELBookEx01" />
	<jsp:setProperty property="*" name="book" />
	<%
		request.setAttribute("book", book);
	%>
	책제목 :${ book.title }
	<br> 책저자 : ${ book.author }
	<br> 출판사 : ${ book.publisher }
</body>
</html>
