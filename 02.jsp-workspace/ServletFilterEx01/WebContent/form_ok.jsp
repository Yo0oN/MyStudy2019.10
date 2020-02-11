<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 모든 페이지마다 다국어 처리를 해주기는 힘드니
	// 필터에서 처리해주자.
	String data = request.getParameter("data");
	out.println("data : " + data);
%>