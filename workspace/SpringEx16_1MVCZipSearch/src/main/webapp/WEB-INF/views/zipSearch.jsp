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
	zipsearch.jsp
	<hr>
	<form action="./zipSearch.do" method="get" />
	동 :
	<input type="text" name="dong" />
	<input type="submit" value="검색하기" />
	</form>
	<hr>
	<%
		if (request.getParameter("dong") != null && !request.getParameter("dong").equals("")) {

			ArrayList<ZipcodeTO> dongLists = (ArrayList) request.getAttribute("dongLists");

			if (!dongLists.isEmpty()) {
				StringBuffer sbHtml = new StringBuffer();

				sbHtml.append("<table border='1px'>");

				sbHtml.append("<tr><td>우편번호</td><td>시/도</td><td>구/군</td><td>동</td><td>번지</td><td>리</td><td></td></tr>");
				while (!dongLists.isEmpty()) {
					ZipcodeTO to = new ZipcodeTO();
					sbHtml.append("<tr>");

					to = dongLists.remove(0);

					sbHtml.append("<td>" + to.getZipcode() + "</td>");
					sbHtml.append("<td>" + to.getSido() + "</td>");
					sbHtml.append("<td>" + to.getGugun() + "</td>");
					sbHtml.append("<td>" + to.getDong() + "</td>");
					sbHtml.append("<td>" + to.getBunji() + "</td>");
					sbHtml.append("<td>" + to.getRi() + "</td>");
					sbHtml.append("<td>" + to.getSeq() + "</td>");

					sbHtml.append("</tr>");
				}
				sbHtml.append("</table>");

				out.println(sbHtml);
			} else {
				out.println("검색 결과가 없습니다.");
			}
		}
	%>
</body>
</html>