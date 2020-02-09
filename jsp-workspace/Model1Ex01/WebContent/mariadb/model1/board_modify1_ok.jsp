<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model1.BoardDAO"%>
<%@page import="model1.BoardTO"%>

<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");

	BoardTO to = new BoardTO();
	
	to.setSeq(request.getParameter("seq"));
	to.setSubject(request.getParameter("subject"));
	String mail = "";
	if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
		to.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
	} else {
		to.setMail("");
	}
	to.setPassword(request.getParameter("password"));
	to.setContent(request.getParameter("content"));

	BoardDAO boardDAO = new BoardDAO();
	int flag = boardDAO.boardModifyOk(to);

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글수정에 성공했습니다.');");
		out.println("location.href='board_view1.jsp?seq=" + seq + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글수정에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>
