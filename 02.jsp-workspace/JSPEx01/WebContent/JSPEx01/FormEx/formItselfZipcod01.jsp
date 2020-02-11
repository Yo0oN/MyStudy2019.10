<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>

<%
	request.setCharacterEncoding("utf-8");
%>

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
	<h3>우편번호 검색기</h3>
	<form action="formItselfZipcode01.jsp" method="post">
		동 : <input type="text" name="dong" />
		<input type="submit" value="검색">
	</form>
	<%
	
		if (true){
			
		}
	
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select ? from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, "*");
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
		} catch (SQLException e) {
		}
	%>
</body>
</html>