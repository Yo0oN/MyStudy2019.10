<%@page import="java.util.ArrayList"%>
<%@page import="model1.EmpTO"%>
<%@page import="config.SqlMapperInterface"%>
<%@page import="org.apache.ibatis.io.Resources"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	SqlSession sqlSession = null;
	InputStream is = null;
	String resource = "myBatisConfig.xml";
	
	StringBuffer sbHtml = new StringBuffer();

	is = Resources.getResourceAsStream(resource);
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	sqlSession = sqlSessionFactory.openSession(true);

	sqlSession.getConfiguration().addMapper(SqlMapperInterface.class);
	SqlMapperInterface mapper = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);

	ArrayList<EmpTO> empList = mapper.selectEmp("s%");
	
	sbHtml.append("<table border=1 width=500>");
	for (EmpTO to : empList) {
		sbHtml.append("<tr>");
		sbHtml.append("<td>" + to.getEmpno() + "</td>");
		sbHtml.append("<td>" + to.getEname() + "</td>");
		sbHtml.append("<td>" + to.getSal() + "</td>");
		sbHtml.append("</tr>");
	}
	sbHtml.append("</table>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
emp테이블에서 s로 시작하는 사원정보(사원번호, 사원명, 급여) 출력하기
<%= sbHtml %>
</body>
</html>