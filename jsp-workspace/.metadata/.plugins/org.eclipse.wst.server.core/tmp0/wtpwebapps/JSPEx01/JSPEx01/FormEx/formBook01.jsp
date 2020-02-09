<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 정보</h3>
	<form action="formBook01_ok.jsp" method="get">
		ID : <input type="text" name="id" /><br><br>
		password : <input type="password" name="pwd" /><br><br>
		name : <input type="text" name="name" /><br><br>
		hobby : <input type="checkbox" name="hobby" value="climbing" /> climbing
				<input type="checkbox" name="hobby" value="sports" /> sports
				<input type="checkbox" name="hobby" value="reading" /> reading
				<input type="checkbox" name="hobby" value="traveling" /> travleing
		<br><br>
		gender : <input type="radio" name="gender" value="male" />male
				<input type="radio" name="gender" value="female" />female
		<br><br>
		religion :
		<select name="religion">
			<option value="Christianity">Christianity
			<option value="Buddhism">Buddhism
			<option value="Catholicism">Catholicism
			<option value="atheism">atheism
		</select> <br><br>
		introduction :<br><br>
		<textarea rows="10" cols="30" name="introduction"></textarea>
		<br><br>
		<input type="submit" value="submit" />
		<input type="reset" value="reset" />
	</form>

</body>
</html>