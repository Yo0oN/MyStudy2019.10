<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:redirect url="https://www.daum.net" /> --%>
<!-- url에 파라미터를 정해줄 수 있다. -->
<c:redirect url="https://search.daum.net/search">
	<c:param name="w" value="tot" />
	<c:param name="q" value="스타워즈" />
</c:redirect>
