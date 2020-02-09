<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 쿠키 정보 가져오기
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			out.println(cookies[i].getName() + "<br>");
			out.println(cookies[i].getValue() + "<br>");
		}
	}
%>

