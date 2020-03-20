<%@page import="com.exam.model1.Design_albumMemberTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("location.href='./search_result.do'");
	} else if (flag == 1) {
		out.println("alert('해당 정보가 없습니다.')");
		out.println("history.back()");
	} else {
		out.println("alert('찾기에 실패했습니다.')");
		out.println("history.back()");
	}

	out.println("</script>");
%>