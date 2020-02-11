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
		int year = 2015;
		int month = 2;
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;

		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();

		sDay.set(year, month - 1, 1);

		eDay.set(year, month, 1 - 1);
		eDay.add(Calendar.DATE, -1);

		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		END_DAY = eDay.get(Calendar.DATE);

		String ca = "";
		ca += "<table border = 1px>";
		ca += "<tr> <td colspan='7'>" + year + "년 " + month + "월</td></tr>";

		ca += "<tr>" + "<td>SU</td><td>MO</td><td>TU</td><td>WE</td><td>TH</td><td>FR</td><td>SA</td>" + "</tr>";

		ca += "<tr>";
		for (int i = 1; i < START_DAY_OF_WEEK; i++) {
			ca += "<td></td>";
		}
		ca += "</tr>";

		ca += "<tr>";
		for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++) {
			ca += "<td>" + ((i < 10) ? "&nbsp;&nbsp;" + i : "&nbsp;" + i) + "</td>";
			if (n % 7 == 0) {
				ca += "</tr>";
				ca += "<tr>";
			}
		}

		ca += "</table>";

		out.println(ca);
	%>
</body>
</html>