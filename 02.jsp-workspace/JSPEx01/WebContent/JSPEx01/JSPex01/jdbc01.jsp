<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%
	String url = "jdbc:mysql://127.0.0.1:3306/employees";
	String user = "root";
	String password = "123456";

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);

			out.println("연결 성공");
			
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			out.println("<table border=1px>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString("deptno") + "</td>");
				out.println("<td>" + rs.getString("dname") + "</td>");
				out.println("<td>" + rs.getString("loc") + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	%>
</body>
</html>
