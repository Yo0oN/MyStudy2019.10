<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String output = "";
		output += "<table border=1px width='800'>";
		for (int i = 0; i < 10; i++) {
			output += "<tr>";

			for (int j = 0; j < 10; j++) {
				if (i == 0) {
					if (j == 0) {
						output += "<td></ td>";
					} else {
						output += "<td>x " + j + "</ td>";
					}
				} else {
					if (j == 0) {
						output += "<td>" + i + "단</ td>";
					} else {
						output += "<td>" + i + " x " + j + " = " + (i * j) + "</td>";
					}
				}
			}
			output += "</ tr>";
		}

		output += "</ table>";
		out.println(output);
	%>
	<%= output %>
</body>
</html>