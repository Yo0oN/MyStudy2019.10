<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="mysql.model1.BoardTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.json.simple.JSONArray"%>
<%@ page import="org.json.simple.JSONObject"%>

<%
	JSONObject result = new JSONObject();
	result.put("flag", "0");
	JSONObject obj = new JSONObject();

	obj.put("seq", (String) request.getAttribute("seq"));
	obj.put("subject", (String) request.getAttribute("subject"));
	obj.put("writer", (String) request.getAttribute("writer"));

	result.put("data", obj);

	out.println(result);
%>
