<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet" href="./css/bootstrap.css" />
<!-- jquery -->
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<!-- bootstrap -->
<script type="text/javascript" src="./js/bootstrap.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#myInput').on('keyup', function(){
			//console.log($(this).val());
			// #myInput에 쓰여진 값을 소문자로 만들어 value에 넣는다.
			var value=$(this).val().toLowerCase();
			$('#myTable tr').filter(function(){
				// #myTable의 tr들에서는 tr의 text값을 전부 소문자로 만든 후,
				// tr의 text값 중 value와 일치하는 부분이 있다면 toggle을 이용하여
				// 해당 tr이 보여지게 한다.(false인 tr들은 보이지 않는다.)
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
			});
			// toggle 메소드는 매개변수가 true일 경우 해당 선택자를 보여주고,
			// false인 경우 보여주지 않는다.
		})
	});
</script>
</head>
<body>
	<div class="container mt-3">
		<input class="form-control" id="myInput" type="text"
			placeholder="Search.."> <br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<tr>
					<td>John</td>
					<td>Doe</td>
					<td>john@example.com</td>
				</tr>
				<tr>
					<td>Mary</td>
					<td>Moe</td>
					<td>mary@mail.com</td>
				</tr>
				<tr>
					<td>July</td>
					<td>Dooley</td>
					<td>july@greatstuff.com</td>
				</tr>
				<tr>
					<td>Anja</td>
					<td>Ravendale</td>
					<td>a_r@test.com</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>