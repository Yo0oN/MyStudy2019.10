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
	<!-- c:if 조건문 -->
	<c:if test="true">
		무조건 실행<br>
		무조건 실행<br>
	</c:if>

	<c:set var="country" value="korea" />

	<c:if test="${country == 'korea'}">
		country : korea 실행<br>
	</c:if>

	<c:choose>
		<c:when test="${country == 'canada'}">
			canada : 겨울은 더 춥다
		</c:when>
		<c:when test="${country == 'korea'}">
			korea : 겨울은 춥다
		</c:when>
		<c:otherwise>
			other.. : 겨울은 안춥다
		</c:otherwise>
	</c:choose>
</body>
</html>
