<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer)request.getAttribute("flag");
	String cpage = request.getParameter("cpage");
	String seq = request.getParameter("seq");
	
	out.println("<script type='text/javascript'>");
	if (flag == 1) {
		out.println("alert('댓글을 달았습니다.')");
		out.println("location.href='./view.do?seq=" + seq + "&cpage=" + cpage + "'");
	} else {
		out.println("alert('댓글 달기에 실패하였습니다.')");
		out.println("history.back()");
	}
	out.println("</script>");
%>