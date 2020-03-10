<%@page import="java.net.URLDecoder"%>
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

<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%
	DataSource dataSource = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	JSONArray jsonArray = new JSONArray();

	String dong = request.getParameter("dong");//URLDecoder.decode(request.getParameter("dong"), "utf-8").trim();

	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		conn = dataSource.getConnection();
		String sql = "select * from zipcode where dong like ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + dong + "%");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("zipcode", rs.getString("zipcode"));
			jsonObject.put("sido", rs.getString("sido"));
			jsonObject.put("gugun", rs.getString("gugun"));
			jsonObject.put("dong", rs.getString("dong"));
			jsonObject.put("ri", rs.getString("ri"));
			jsonObject.put("bunji", rs.getString("bunji"));
			jsonObject.put("seq", rs.getString("seq"));

			jsonArray.add(jsonObject);
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
	out.println(jsonArray);
%>