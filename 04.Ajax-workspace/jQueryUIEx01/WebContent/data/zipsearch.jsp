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

	// StringBuffer를 이용하면 시간이 너무 오래걸린다.
	// JSON을 이용하자.
	JSONArray result = new JSONArray();

	String dong = request.getParameter("dong");
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
			JSONObject data = new JSONObject();

			data.put("zipcode", rs.getString("zipcode"));
			data.put("sido", rs.getString("sido"));
			data.put("gugun", rs.getString("gugun"));
			data.put("dong", rs.getString("dong"));
			data.put("ri", rs.getString("ri"));
			data.put("bunji", rs.getString("bunji"));
			data.put("seq", rs.getString("seq"));
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