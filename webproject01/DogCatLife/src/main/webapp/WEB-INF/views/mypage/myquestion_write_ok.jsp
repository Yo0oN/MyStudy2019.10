<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("location.href='./myquestion_list.mysql'");
		out.println("alert('글이 등록 되었습니다.')");
	} else {
		out.println("history.back();");
		out.println("alert('글 등록에 실패하였습니다.');");
	}
	out.println("</script>");
%>