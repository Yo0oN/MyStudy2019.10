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
	request.setCharacterEncoding("utf-8");
	DataSource dataSource = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	JSONArray jsonArray = new JSONArray();

	String getDong = request.getParameter("dong");
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		conn = dataSource.getConnection();
		String sql = "select zipcode, sido, gugun, dong, ri, bunji, seq from zipcode where dong like ?";
		pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, "%" + "신사" + "%");
		pstmt.setString(1, "%" + getDong + "%");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			String seq = rs.getString("seq");
			String zipcode = rs.getString("zipcode");
			String sido = rs.getString("sido");
			String gugun = rs.getString("gugun");
			String dong = rs.getString("dong");
			String ri = rs.getString("ri");
			String bunji = rs.getString("bunji");

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("seq", seq);
			jsonObject.put("zipcode", zipcode);
			jsonObject.put("sido", sido);
			jsonObject.put("gugun", gugun);
			jsonObject.put("dong", dong);
			jsonObject.put("ri", ri);
			jsonObject.put("bunji", bunji);

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