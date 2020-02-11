<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// out과 새로 만든 writer와 yo의 주소가 같다.
	// 즉 세개 모두 같은 객체를 참조하고 있다.
	out.println("Hello JSP<br>");
	out.println(out + "<br>");

	// out - JSPWriter 타입
	JspWriter writer = pageContext.getOut();
	writer.println("Hello JSP<br>");
	out.println(writer + "<br>");

	JspWriter yo = pageContext.getOut();
	yo.println("Hello JSP<br>");
	out.println(yo + "<br>");
%>