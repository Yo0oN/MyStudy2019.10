<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name1 = "홍길동";
	// 내장객체에 담은 후 출력을 해야 EL에서도 보인다.
	pageContext.setAttribute("name1", "박문수");
	request.setAttribute("name2", "홍길동");
	session.setAttribute("name3", "이순신");
	application.setAttribute("name4", "김철수");
%>
이름 :<%=name1%><br>
이름 : ${name1}<br>
이름 : ${name2}<br>
<!-- 사용전에 경로를 정확히 알려주는게 좋다.
	만약 경로를 설정하지 않았는데,
	변수 이름을 전부 같게 설정한 후 출력했다면
	가장 가까이 있는 변수
	(가장 안쪽에있는것 request-session-application 순서)가 불려온다.-->
이름 : ${sessionScope.name3}<br>
이름 : ${applicationScope.name4}
