<%@page import="AlbumBeans.Design_album01DAO"%>
<%@page import="AlbumBeans.Design_album01TO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");
	String cpage = request.getParameter("cpage");
	Design_album01TO to = new Design_album01TO();

	to.setSeq(request.getParameter("seq"));
	to.setCom_writer(request.getParameter("cwriter"));
	to.setCom_password(request.getParameter("cpassword"));
	to.setCom_comment(request.getParameter("ccontent"));

	Design_album01DAO dao = new Design_album01DAO();
	
	int flag = dao.board_view1_ok(to);
	
	out.println("<script type='text/javascript'>");
	if (flag == 1) {
		out.println("alert('댓글을 달았습니다.')");
		out.println("location.href='board_view1.jsp?seq=" + seq + "&cpage=" + cpage + "'");
	} else {
		out.println("alert('댓글 달기에 실패하였습니다.')");
		out.println("history.back()");
	}
	out.println("</script>");
%>