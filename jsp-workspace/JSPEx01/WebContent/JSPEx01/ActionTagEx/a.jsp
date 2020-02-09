<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 매개변수로 데이터를 받아야한다.
	String i = request.getParameter("i");
	String j = request.getParameter("j");
	out.println("a.jsp<br>");
	out.println(i + "<br>");
	out.println(j);
%>
