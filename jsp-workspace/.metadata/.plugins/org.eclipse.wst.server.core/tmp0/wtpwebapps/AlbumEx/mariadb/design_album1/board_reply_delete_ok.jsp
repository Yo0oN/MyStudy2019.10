<%@page import="AlbumBeans.Design_album01DAO"%>
<%@page import="AlbumBeans.Design_album01TO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");
	String cseq = request.getParameter("cseq");
	String com_password = request.getParameter(cseq + "password");

	Design_album01TO to = new Design_album01TO();

	to.setSeq(seq);
	to.setCseq(cseq);
	to.setCom_password(com_password);

	Design_album01DAO dao = new Design_album01DAO();

	int flag = dao.board_view1_ok2(to);

	out.println("<script type='text/javascript'>");

	if (flag == 1) {
		out.println("alert('댓글 삭제에 성공했습니다.')");
		out.println("location.href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage + "'");
	} else if (flag == 0) {
		out.println("alert('비밀번호를 다시 확인해 주세요.')");
		out.println("history.back()");
	} else {
		out.println("alert('댓글 삭제에 실패했습니다.')");
		out.println("history.back()");
	}

	out.println("</script>");
%>
