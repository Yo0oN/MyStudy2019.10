<%@page import="com.exam.model1.Design_albumMemberTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Design_albumMemberTO to = (Design_albumMemberTO) request.getAttribute("to");
	int flag = to.getFlag();

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		session.setAttribute("to", to);
		out.println("location.href='./search_id.do'");
	} else if (flag == 1) {
		out.println("alert('아이디가 없습니다.')");
		out.println("history.back()");
	} else {
		out.println("alert('아이디 찾기에 실패했습니다.')");
		out.println("history.back()");
	}

	out.println("</script>");
%>