<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
hello there
<hr>
<!-- 특정 페이지를 삽입할 수 있다. -->
<c:import url="./ex07.jsp" />
<hr>
<!-- 특정 페이지를 변수에 넣을 수도 있다. -->
<c:import var="html" url="https://m.daum.net" />
<!-- 변수를 그대로 출력하면 원래의 페이지가 그대로 보이겠지만,
	textarea에 넣어 출력하면 소스가 그대로 보인다. -->
<textarea rows="50" cols="600">
${html}
</textarea>
