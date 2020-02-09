<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 세션은 브라우저가 켜져 있는동안만 유지되고,
	// 브라우저 하나당 하나의 세션만 사용 가능하다.
	// session01에서 세션의 값을 설정해주었기 때문에
	// 이곳에서는 저절로 data1의 값이 출력된다.
	// 하지만 session01을 실행하지 않고, session02를 바로 실행하면
	// null이 출력될것이다.
	out.println("나는 session02.jsp");
	out.println((String) session.getAttribute("data1"));
%>
