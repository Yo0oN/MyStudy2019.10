<%@page import="model1.BoardDAO"%>
<%@page import="model1.BoardTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");

	BoardTO to = new BoardTO();
	to.setSeq(seq);
	to.setPassword(password);

	BoardDAO boardDAO = new BoardDAO();
	int flag = boardDAO.boardDeleteOk(to);

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글삭제에 성공했습니다.');");
		out.println("location.href='board_list1.jsp';");
	} else if (flag == 1) {
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글삭제에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
%>





