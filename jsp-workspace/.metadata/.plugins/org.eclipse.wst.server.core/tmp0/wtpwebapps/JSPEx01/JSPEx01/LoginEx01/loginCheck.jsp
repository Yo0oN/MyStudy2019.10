<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");

	// 비밀번호와 아이디를 DB에서 확인해야 하지만,
	// 연습이니까 아이디와 비밀번호를 지정하자..
	String save_id = "test";
	String save_password = "123456";

	// 검사하기
	int flag = 1;
	if (id.equals(save_id) && password.equals(save_password)) {
		// 아이디와 비밀번호가 같으면 세션에 id와 회원등급같은 정보를 저장해둔다.
		// 비밀번호 주민등록번호같은건 저장하면 안된다!DB밖으로 빼지말것!
		session.setAttribute("sess_id", id);
		session.setAttribute("sess_grade", "A");
		flag = 0;
	}

	out.println("<script type='text/javascript'>");

	if (flag == 0) {
		out.println("alert('로그인 성공.');");
		out.println("location.href='loginComplete.jsp';");
	} else {
		out.println("alert('암호와 비밀번호가 틀렸습니다.');");
		out.println("history.back();");
	}

	out.println("</script>");
%>