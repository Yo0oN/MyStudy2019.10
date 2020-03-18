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

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String password = request.getParameter("password");

	int flag = 1;
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		conn = dataSource.getConnection();

		String sql = "insert into users values(0, ?, ?, ?)";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, password);
		
		int result = pstmt.executeUpdate();
		
		if (result == 1) {
			flag = 0;
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
	}
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("flag", flag);
	
	out.println(jsonObject);
%>