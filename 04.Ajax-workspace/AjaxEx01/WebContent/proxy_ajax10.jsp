<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String search = request.getParameter("search");
%>
<c:import var="data" charEncoding="utf-8"
	url="http://newssearch.naver.com/search.naver?where=rss&query=<%=search%>" />
${data}
