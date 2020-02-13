<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String cpage = (String) request.getAttribute("cpage");
	String seq = (String) request.getAttribute("seq");
	String url = request.getRequestURI().replaceAll(request.getContextPath(), "");

	out.println("<script type='text/javascript'>");

	// 로그아웃페이지로 오면 세션 삭제 + 메인페이지로 돌아감
	session.removeAttribute("idno");
	session.removeAttribute("id");

	out.println("alert('로그아웃 성공.')");

	out.println("location.href='./list.do'");

	out.println("</script>");
%>