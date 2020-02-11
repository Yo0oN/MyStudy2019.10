<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	out.println(out.getRemaining() + "<br>");
	out.println("1<br>");
	out.println("2<br>");
	out.println("3<br>");

	// buffer 안에 들어있는것들을 비운다.
	// 비웠기 때문에 위에 있는 1 2 3 은 출력되지 않는다.
	out.clearBuffer();

	out.println(out.getRemaining() + "<br>");
	out.println("4<br>");
	out.println("5<br>");
	out.println("6<br>");

	// client에게 buffer안에 있는것들을 보내고 비웠기 때문에
	// 8192가 그대로 남아있다
	out.flush();
	
	out.println(out.getRemaining() + "<br>");
	out.println("7<br>");
	out.println("8<br>");
	out.println("9<br>");

	// 강제로 buffer에 담지 못하게 출력스트림을 해제했기 때문에
	// 아래의 10 11 은 출력되지 못한다.
	out.close();

	out.println("10<br>");
	out.println("11<br>");
%>
