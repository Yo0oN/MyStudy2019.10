<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] hobby = request.getParameterValues("hobby");
		String hob = "";
		for (int i = 0; i < hobby.length; i++) {
			if (i == hobby.length - 1) {
				hob += (hobby[i]);
			} else {
				hob += (hobby[i] + ", ");
			}
		}
		String gender = request.getParameter("gender");
		String rel = request.getParameter("religion");
		String intro = request.getParameter("introduction");

		out.println("ID : " + id + "<br>");
		out.println("password : " + pwd + "<br>");
		out.println("name : " + name + "<br>");
		out.println("hobby : " + hob + "<br>");
		out.println("gender : " + gender + "<br>");
		out.println("religion : " + rel + "<br>");
		out.println("introduction: " + intro + "<br>");
	%>
</body>
</html>