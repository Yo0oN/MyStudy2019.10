<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
	DataSource dataSource = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	StringBuffer result = new StringBuffer();

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		conn = dataSource.getConnection();
		String sql = "select * from books";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		result.append("[\n");
		while (rs.next()) {
			System.out.println(1);
			result.append("{");
			String data = String.format(
					"\"name\" : \"%s\",\n\"publisher\" : \"%s\",\n\"author\" : \"%s\",\n\"price\" : \"%s\"",
					rs.getString("name"), rs.getString("publisher"), rs.getString("author"),
					rs.getString("price"));
			result.append(data);
			result.append("}, \n");
			System.out.println(2);
		}
		result.replace(result.length() - 3, result.length()-2, "");
		System.out.println(3);
		result.append("]");

	} catch (NamingException e) {

	} catch (SQLException e) {

	} finally {
		if (conn != null) {
			conn.close();
		}
		if (pstmt != null) {
			conn.close();
		}
		if (rs != null) {
			conn.close();
		}
	}
	out.println(result);
%>