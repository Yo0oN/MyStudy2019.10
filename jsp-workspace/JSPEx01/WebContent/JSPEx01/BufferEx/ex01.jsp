<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page buffer="1kb" autoFlush="false"%>
<!-- autoFlush : true일 경우 buffer의 용량이 다 차면
				스스로 buffer를 비우고(출력하고) 다시 채우기를 하지만,
				false로 한다면 스스로 비우지 못하기 때문에 에러가 발생한다.-->
<%
	out.println("버퍼 크기 : " + out.getBufferSize() + "<br>");
	out.println("남은 버퍼 크기: " + out.getRemaining() + "<br>");

	for (int i = 1; i < 1000; i++) {
		out.println(i + "Hello JSP<br>");
		if (i % 200 == 0) {
			out.println("남은 버퍼 크기 : " + out.getRemaining() + "<br>");
		}
	}
%>