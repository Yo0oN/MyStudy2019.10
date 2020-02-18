<%@page import="com.exam.jdbc01zipsearch.ZipcodeTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	zipsearch.jsp
	<hr>
	<form action="./zipsearch.do" method="post">
		동 : <input type="text" name="dong"> <input type="submit"
			value="찾기">
	</form>
	<hr>
	<%
		if (request.getAttribute("zipcodeTO") != null) {
			ArrayList<ZipcodeTO> zipcodeTO = (ArrayList) request.getAttribute("zipcodeTO");

			if (zipcodeTO.size() > 0) {
				out.println("<table boder=1>");
				out.println("<tr>");
				out.println(
						"<td>zipcode</td><td>sido</td><td>gugun</td><td>dong</td><td>ri</td><td>bunji</td><td>seq</td>");
				out.println("</tr>");
				while (!zipcodeTO.isEmpty()) {

					ZipcodeTO to = zipcodeTO.remove(0);
					out.println("<tr>");
					out.println("<td>" + to.getZipcode() + "</td>");
					out.println("<td>" + to.getSido() + "</td>");
					out.println("<td>" + to.getGugun() + "</td>");
					out.println("<td>" + to.getDong() + "</td>");
					out.println("<td>" + to.getRi() + "</td>");
					out.println("<td>" + to.getBunji() + "</td>");
					out.println("<td>" + to.getSeq() + "</td>");
					out.println("</tr>");
				}
				out.println("</ table>");
			} else {
				out.println("검색 결과가 없습니다.");
			}
		}
	%>
</body>
</html>
