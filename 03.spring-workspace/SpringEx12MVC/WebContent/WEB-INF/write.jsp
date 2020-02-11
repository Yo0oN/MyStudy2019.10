<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	write.jsp
	<hr>
	<form action="write_ok.do" method="get">
		get 데이터 : <input type="text" name="data"/>
		<input type="submit" value="전송" />
	</form>
	
	<hr>
	
	<form action="write_ok.do" method="post">
		post 데이터 : <input type="text" name="data"/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>