<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label, input {
	display: block;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}

fieldset {
	padding: 0;
	border: 0;
	margin-top: 25px;
}

h1 {
	font-size: 1.2em;
	margin: .6em 0;
}

div#users-contain {
	width: 350px;
	margin: 20px 0;
}

div#users-contain table {
	margin: 1em 0;
	border-collapse: collapse;
	width: 100%;
}

div#users-contain table td, div#users-contain table th {
	border: 1px solid #eee;
	padding: .6em 10px;
	text-align: left;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}
</style>
<link rel="stylesheet" href="../css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#dialog-form').dialog({
			autoOpen : false,
			modal : true,
			width : 350,
			height : 300,
			buttons : {
				'취소' : function() {
					$(this).dialog('close');
				},
				'생성' : function() {
					var append = '<tr>';
					append += '<td>' + $('#name').val() + '</td>';
					append += '<td>' + $('#email').val() + '</td>';
					append += '<td>' + $('#password').val() + '</td>';
					append += '<td><button>수정</button></td>';
					append += '<td><button>삭제</button></td>';
					append += '</tr>';
					$('tbody').append(append);
					
					$(this).dialog('close');
				}
			}
		});
		$('#create-user').button().on('click', function() {
			$('#dialog-form').dialog('open');
		});
	});
</script>
</head>
<body>
	<button id="create-user">사용자 생성</button>
	<br>
	<hr>
	<!-- 표 -->
	<div id="users-contain" class="ui-widget">
		<h1>Existing Users:</h1>
		<table id="users" class="ui-widget ui-widget-content">
			<thead>
				<tr class="ui-widget-header ">
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th colspan="2"> </th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
	<!-- 추가창 -->
	<div id="dialog-form" title="Create new user">
		<p class="validateTips">All form fields are required.</p>

		<form>
			<fieldset>
				<label for="name">Name</label>
				<input type="text" name="name" id="name" value="Jane Smith" class="text ui-widget-content ui-corner-all">
				<label for="email">Email</label>
				<input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" value="xxxxxxx" class="text ui-widget-content ui-corner-all">
				<!-- Allow form submission with keyboard without duplicating the dialog button -->
				<input type="submit" tabindex="-1" style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>
</body>
</html>