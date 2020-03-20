<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 1) {
		out.println("alert('수정 실패.');");
		out.println("history.back();");
	} else if (flag == 0) {
		out.println("alert('수정하였습니다.')");
		out.println("location.href='./list.do'");
	}
	out.println("</script>");
%>