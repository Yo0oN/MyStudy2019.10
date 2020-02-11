<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Connection"%>

<%
	int flag = (Integer) request.getAttribute("flag");
	String seq = (String) request.getAttribute("seq");
	String cpage = (String) request.getAttribute("cpage");
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('수정 완료');");
		out.println("location.href='./view.do?seq=" + seq + "&cpage=" + cpage + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호를 다시 확인해주세요');");
		out.println("history.back();");
	} else {
		out.println("alert('수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>
