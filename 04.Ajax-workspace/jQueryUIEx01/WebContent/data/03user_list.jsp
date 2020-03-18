<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
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

	JSONArray result = new JSONArray();

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		conn = dataSource.getConnection();

		String sql = "select * from users";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			JSONObject data = new JSONObject();

			data.put("seq", rs.getString("seq"));
			data.put("name", rs.getString("name"));
			data.put("email", rs.getString("email"));
			data.put("password", rs.getString("password"));
			
			result.add(data);
		}

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