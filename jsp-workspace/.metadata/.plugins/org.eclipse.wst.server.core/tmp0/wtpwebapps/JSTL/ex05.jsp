<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 반복문 
		begin부터 end까지 반복하면서 step만큼 건너뛰면서 실행 -->
	<c:forEach var="i" begin="1" end="10" step="2">
		Hello${ i }<br>
	</c:forEach>
	<hr>
	<c:forEach var="i" begin="1" end="3">
		<c:forEach var="j" begin="1" end="3">
			${ i } / ${ j } || 
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>
