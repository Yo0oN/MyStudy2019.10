<%@page import="com.exam.model1.Design_albumMemberTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("location.href='./search_password.do'");
	} else if (flag == 1) {
		out.println("alert('아이디나 메일이 틀렸습니다.')");
		out.println("history.back()");
	} else if (flag == 2) {
		out.println("alert('비밀번호 찾기에 실패했습니다.')");
		out.println("history.back()");
	}

	out.println("</script>");
%>