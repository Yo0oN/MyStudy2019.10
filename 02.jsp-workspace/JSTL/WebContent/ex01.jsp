<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 아래의 문구는 JSTL을 사용할 때 쓰는데, core를 사용할 때 쓴다.
	prefix를 통하여 아래의 태그에서의 접두사를 정해준다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 아래는 모두 같은 출력 기능을 가지고 있다. -->
<%="browser1"%><br>
${"browser1"}<br>
<!-- 참고로 아래의 c가 위에서 prefix로 설정해준 접두사부분이다. -->
<c:out value="browser1" /><br>
<c:out value="${ data = 1 }" /> <br>
<hr>

<!-- 아래는 모두 같은 기능을 하고 있다. -->
<c:set var="data1" value="test1" scope="page" />
<c:set var="data3" scope="page">test3</c:set>
<%
	pageContext.setAttribute("data2", "test2");
%>
<!-- 출력해보면 위의 세개가 같은 기능이었다는것을 알 수 있다. -->
${data1}<br>
${data2}<br>
${data3}<br>
<c:out value="${data1}"></c:out>
<c:out value="${data2}"></c:out>
<c:out value="${data3}" />
