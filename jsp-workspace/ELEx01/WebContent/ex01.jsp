<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td width="50">출력</td>
			<td width="50"><%=2%></td>
		</tr>
		<tr>
			<td>출력</td> <td>${2}</td>
		</tr>
		<tr>
			<td>출력</td> <td>${"2"}</td>
		</tr>
		<tr>
			<td>출력</td> <td>${2+5}</td>
		</tr>
		<tr>
			<td>출력</td> <td>${2/5}</td>
		</tr>
		<tr>
			<td>출력</td> <td>${2 div5 }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${ 2 mod 5 }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${ "2"+"5" }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${"2"+5 }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${"일" }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${2 < 3 }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${2 lt 3 }</td>
		</tr>
		<tr>
			<td>출력</td> <td>${empty data }</td>
		</tr>
	</table>
</body>
</html>