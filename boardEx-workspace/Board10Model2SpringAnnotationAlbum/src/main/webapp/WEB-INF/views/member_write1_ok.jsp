<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('회원가입에 성공하였습니다.')");
		out.println("location.href='./list.do'");
	}  else if (flag == 1) {
		out.println("alert('중복된 이메일이 있습니다.')");
		out.println("history.back()");
	} else if (flag == 2) {
		out.println("alert('중복된 아이디가 있습니다.')");
		out.println("history.back()");
	} else if (flag == 3){
		out.println("alert('회원가입에 실패하였습니다.')");
		out.println("history.back()");
	}
	out.println("</script>");
%>