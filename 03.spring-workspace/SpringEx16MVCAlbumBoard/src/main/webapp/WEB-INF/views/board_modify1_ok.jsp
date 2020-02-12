<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");
	String seq = (String) request.getAttribute("seq");
	String cpage = (String) request.getAttribute("cpage");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('비밀번호를 다시 확인해주세요.');");
		out.println("history.back();");
	} else if (flag == 1) {
		out.println("alert('수정되었습니다.')");
		out.println("location.href='./view.do?seq=" + seq + "&cpage=" + cpage + "'");
	} else {
		out.println("alert('수정에 실패하였습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>