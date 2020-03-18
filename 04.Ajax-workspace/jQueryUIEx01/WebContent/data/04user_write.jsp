<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;

	DataSource dataSource = null;

	JSONObject object = new JSONObject();
	
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
		
		// 데이터 삽입에 성공하면 flag를 0으로 변경
		if (result == 1) {
			flag = 0;
			object.put("flag", flag);
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
	}
	
	out.println(object);
%>