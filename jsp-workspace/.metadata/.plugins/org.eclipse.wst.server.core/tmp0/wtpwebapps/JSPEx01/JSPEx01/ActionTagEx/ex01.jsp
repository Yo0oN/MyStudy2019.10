<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
시작<br>
<%
	String j = "10";
%>
<jsp:include page="a.jsp">
	<jsp:param value="10" name="i"/>
	<jsp:param value="<%=j %>" name="j"/>
</jsp:include>

끝<br>
