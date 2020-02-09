<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("data1", "value1");
	out.println("나는 session01.jsp");
	out.println((String) session.getAttribute("data1"));
%>
