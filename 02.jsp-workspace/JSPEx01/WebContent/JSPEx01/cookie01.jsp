<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("data", "value");
	// 쿠키 추가
	response.addCookie(cookie);
%>