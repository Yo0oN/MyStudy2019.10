<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 세션객체 삭제하는 메소드
	session.invalidate();

	out.println("<script type='text/javascript'>");
	out.println("alert('로그아웃 되었습니다.');");
	out.println("location.href='loginForm.jsp';");
	out.println("</script>");
%>
