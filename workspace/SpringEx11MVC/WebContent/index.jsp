<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 시작페이지 index.jsp -->
	<a href="list1.do">list1.do</a><br><br>
	<a href="list2.do">list2.do</a><br><br>
	<a href="list3.do">list3.do</a><br><br>
	
	<!-- 가상경로. indext.jsp가 있는 이 폴더에는
		board라는 폴더가 없으나 webContext.xml에서
		/board/list1.do로 요청이 들어오면 list1.jsp로 이동시켜주기때문에
		겉으로 보기에는 경로가 존재하는것처럼 보인다. -->
	<a href="./board/list1.do">board/list1.do</a><br><br>
	<a href="./board/list2.do">board/list2.do</a>
</body>
</html>
