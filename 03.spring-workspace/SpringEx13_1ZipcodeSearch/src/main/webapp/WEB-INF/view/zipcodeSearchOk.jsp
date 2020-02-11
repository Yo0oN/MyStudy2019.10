<%@page
	import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="model1.ZipcodeTO"%>
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
	zipcodeSearchOk.jsp
	<hr>
	<%
	ArrayList<ZipcodeTO> toLists = (ArrayList) request.getAttribute("toLists");

	if (toLists != null && toLists.size() != 0) {
		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append("<table border='1'>");

		sbHtml.append("<tr><td>우편번호</td><td>시도</td><td>구군</td><td>동</td><td>리</td><td>번지</td></tr>");

		for (ZipcodeTO to : toLists) {
			sbHtml.append("<tr>");
			sbHtml.append("<td>" + to.getZipcode() + "</td>");
			sbHtml.append("<td>" + to.getSido() + "</td>");
			sbHtml.append("<td>" + to.getGugun() + "</td>");
			sbHtml.append("<td>" + to.getDong() + "</td>");
			sbHtml.append("<td>" + to.getRi() + "</td>");
			sbHtml.append("<td>" + to.getBunji() + "</td>");
			sbHtml.append("</tr>");
		}
		sbHtml.append("</table>");

		out.println(sbHtml);
	} else if (toLists == null || toLists.size() == 0) {
		out.println("검색 결과가 없습니다.");
	}
%>
</body>
</html>