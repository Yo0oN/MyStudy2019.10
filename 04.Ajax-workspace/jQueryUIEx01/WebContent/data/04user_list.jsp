<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	DataSource dataSource = null;

	JSONArray jsonArray = new JSONArray();
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");
		conn = dataSource.getConnection();

		String sql = "select * from users";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			JSONObject object = new JSONObject();

			object.put("seq", rs.getString("seq"));
			object.put("name", rs.getString("name"));
			object.put("email", rs.getString("email"));
			object.put("password", rs.getString("password"));

			jsonArray.add(object);
		}

	} catch (NamingException e) {
		System.out.println("error : " + e.getMessage());
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
	
	out.println(jsonArray);
%>