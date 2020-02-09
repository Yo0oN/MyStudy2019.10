<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.DeptTO"%>
<%@ page import="model1.DeptDAO"%>

<%
	DeptDAO dao = new DeptDAO();

	ArrayList<DeptTO> lists = dao.selectOne();
	StringBuffer sbHtml = new StringBuffer();

	sbHtml.append("<table border=1>");

	for (DeptTO to : lists) {
		sbHtml.append("<tr>");
		sbHtml.append("<td>" + to.getDeptno() + "</td>");
		sbHtml.append("<td>" + to.getDname() + "</td>");
		sbHtml.append("<td>" + to.getLoc() + "</td>");
		sbHtml.append("</tr>");
	}
	sbHtml.append("</ table>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=sbHtml%>
</body>
</html>