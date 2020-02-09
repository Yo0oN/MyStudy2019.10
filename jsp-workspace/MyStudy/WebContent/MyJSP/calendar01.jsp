<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		int END_DAY_OF_WEEK = 0;

		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();

		// 현재 달의 첫날을 설정함
		sDay.set(year, month - 1, 1);

		// 현재 달의 마지막날을 설정함
		eDay.set(year, month, 1 - 1);

		// 첫날의 요일을 가져온다.
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

		// 마지막날의 날짜를 가져온다.
		END_DAY = eDay.get(Calendar.DATE);
		END_DAY_OF_WEEK = eDay.get(Calendar.DAY_OF_WEEK);

		out.println("<table border=1px>");
		out.println("<tr><td colspan='7'>" + year + "년 " + month + "월" + "</td></tr>");
		out.println("<tr><td>SU</td><td>MO</td><td>TU</td><td>WE</td><td>TH</td><td>FR</td><td>SA</td></tr>");

		out.println("<tr>");
		
		// 이달의 첫요일이 일요일이 아닐경우에는 첫 요일이 나올때까지 테이블에 빈칸을 채워준다.
		for (int i = 1; i < START_DAY_OF_WEEK; i++) {
			out.print("<td></td>");
		}
		
		// 위에서 빈칸을 다 채우고 1일이 되면 아래의 식을 시작한다.
		for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
			// n % 7 == 0이라는 것은 토요일이라는뜻.
			// 토요일이되면, 배경색을 파랑색으로하고 행을 바꿔준다.
			// 월요일이 되면 배경색을 빨강으로 바꿔준다.
			// 오늘일경우에는 강조를 해준다.
			// 그외의 날짜는 그냥 쓴다.
			if (n % 7 == 0) {
				out.print("<td bgcolor=blue>" + i + "</td>");
				out.println("</tr>");
			} else if (n % 7 == 1) {
				out.print("<td bgcolor=red>" + i + "</td>");
			} else if (i == now.get(Calendar.DATE)) {
				out.print("<td><b>" + i + "</b></td>");
			} else {
				out.print("<td>" + i + "</td>");
			}
		}
		
		// 이달의 마지막요일이 토요일이 아닐경우, 토요일이 될때까지 테이블의 빈칸을 채우고 끝낸다.
		for (int i = END_DAY_OF_WEEK; i < 7; i++) {
			out.print("<td></td>");
		}
		out.println("</tr>");
		out.println("</table>");
	%>
</body>
</html>