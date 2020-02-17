<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.apache.ibatis.io.Resources"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@ page import="config.SqlMapperInterface"%>
<%@ page import="model1.DeptTO"%>

<%
	String resource = "myBatisConfig.xml";
	SqlSession sqlSession = null;

	InputStream is = null;

	StringBuffer sbHtml = new StringBuffer();

	try {
		is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		sqlSession = sqlSessionFactory.openSession(true);

		// annotation을 사용하면 아래의 문장이 더 필요하다.
		sqlSession.getConfiguration().addMapper(SqlMapperInterface.class);
		SqlMapperInterface mapper = (SqlMapperInterface) sqlSession.getMapper(SqlMapperInterface.class);

		// select
		ArrayList<DeptTO> lists = mapper.selectList();

		sbHtml.append("<table border=1>");

		for (DeptTO to : lists) {
			sbHtml.append("<tr>");
			sbHtml.append("<td>" + to.getDeptno() + "</td>");
			sbHtml.append("<td>" + to.getDname() + "</td>");
			sbHtml.append("<td>" + to.getLoc() + "</td>");
			sbHtml.append("</tr>");
		}

		sbHtml.append("</table>");

	} catch (IOException e) {
		System.out.println("error" + e.getMessage());
	} finally {
		if (sqlSession != null)
			sqlSession.close();
		if (is != null)
			try {
				is.close();
			} catch (IOException e) {
			}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= sbHtml %>
</body>
</html>