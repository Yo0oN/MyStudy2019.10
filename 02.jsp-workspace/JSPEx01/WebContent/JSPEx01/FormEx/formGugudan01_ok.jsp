<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단</h2>
	<hr>
	<%
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));

		String output = "";
		output += "<table border=1px>";
		for (int i = start - 1; i <= end; i++) {
			output += "<tr>";

			for (int j = 0; j < 10; j++) {
				if (i == start - 1) {
					if (j == 0) {
						output += "<td></td>";
					} else {
						output += "<td>x " + j + "</td>";
					}
				} else {
					if (j == 0) {
						output += "<td>" + i + "단</td>";
					} else {
						output += "<td>" + i + " x " + j + " = " + (i * j) + "</td>";
					}
				}
			}
			output += "</tr>";
		}
		output += "</table>";
		out.println(output);
	%>
</body>
</html>