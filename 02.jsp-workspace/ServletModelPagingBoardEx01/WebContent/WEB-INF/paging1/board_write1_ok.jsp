<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>
<!-- 이 페이지는 쓰기페이지인 board_writ1에서 넘어온 정보를
DB에 저장해주는 페이지이기 때문에 화면에 보여주지 않는페이지이다.
그래서HTML서식은 필요없다. -->

<%
	int flag = (Integer) request.getAttribute("flag");
	
	System.out.println(1);
	// flag가 0이면(글쓰고 DB등록 성공했으면) 
	// 알림창이 뜨고 메인페이지 아니면 알림창이 뜨고 이전페이지로
	// 알림창이 뜨게 하고싶으므로, 알림창 기능이 있는 javascript로 진행한다.
	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기 성공');");
		out.println("location.href='./pagingController?action=list';");
	} else {
		out.println("alert('글쓰기 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>