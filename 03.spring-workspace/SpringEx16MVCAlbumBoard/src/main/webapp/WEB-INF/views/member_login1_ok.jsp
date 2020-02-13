<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int flag = (Integer) request.getAttribute("flag");
	int idno = (Integer) request.getAttribute("idno");
	String cpage = (String) request.getAttribute("cpage");
	String seq = (String) request.getAttribute("seq");
	String id = (String) request.getAttribute("id");

	

	out.println("<script type='text/javascript'>");
	if (flag == 3) {
		out.println("alert('로그인에 실패하였습니다..');");
		out.println("history.back();");
	} else if (flag == 2) {
		out.println("alert('해당 아이디가 없습니다.');");
		out.println("history.back();");
	} else if (flag == 1) {
		out.println("alert('비밀번호를 다시 확인해주세요.');");
		out.println("history.back();");
	} else if (flag == 0) {
		// 로그인 성공시 세션 생성
		session.setAttribute("idno", idno + "");
		session.setAttribute("id", id);

		out.println("alert('로그인 성공.')");
		if (!seq.equals("null") && !cpage.equals("null")) {
			out.println("location.href='./view.do?seq=" + seq + "&cpage=" + cpage + "'");
		} else if (seq.equals("null") && !cpage.equals("null")) {
			out.println("location.href='./list.do?cpage=" + cpage + "'");
		} else {
			out.println("location.href='./list.do'");
		}

	}
	out.println("</script>");
%>