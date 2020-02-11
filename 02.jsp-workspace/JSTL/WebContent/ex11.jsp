<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import var="news"
	url="https://media.daum.net/syndication/today_sisa.rss" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
RSS읽기
<br><hr><br>
<textarea rows="50" cols="600">
${news }
</textarea>
</body>
</html>
