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
<link rel="stylesheet" href="./css/base/jquery-ui.css" />
<!-- jquery 라이브러리 호출하기 -->
<!-- 개발버전 -->
<script type="text/javascript" src="./js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./js/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 처음 시작시 db에서 테이블 받아온 후 테이블만들어 보여주기
		getList();

		// dialog 생성
		$('#dialog-form').dialog( {
			autoOpen : false,
			buttons : {
				// 취소버튼을 누르면 취소, 생성버튼을 누르면 생성하고, 창닫힌 후 목록이 다시 보인다.
				취소 : function() {
					$(this).dialog('close');
				},
				생성 : function() {
					writeUser($('#name').val(), $('#email').val(), $('#password').val());
				}
			}
		});
		// 수정 dialog
		$('#modify-user-dialog-form').dialog( {
			autoOpen : false,
			buttons : {
				// 취소버튼을 누르면 취소, 수정버튼을 누르면 수정하고, 창닫힌 후 목록이 다시 보인다.
				취소 : function() {
					$(this).dialog('close');
				},
				수정 : function() {
					modifyUser($('#modify-user-dialog-form #name').val(), $('#modify-user-dialog-form #email').val(), $('#modify-user-dialog-form #password').val(), $('#modify-user-dialog-form #seq').val());
				}
			}
		});
		// 삭제 dialog
		$('#delete-user-dialog-form').dialog( {
			autoOpen : false,
			buttons : {
				// 취소버튼을 누르면 취소, 삭제버튼을 누르면 삭제하고, 창닫힌 후 목록이 다시 보인다.
				취소 : function() {
					$(this).dialog('close');
				},
				삭제 : function() {
					deleteUser($('#delete-user-dialog-form #seq').val());
				}
			}
		});
		// 사용자 생성 버튼을 누르면 dialog 창이 보인다. 
		$('#create-user').button().on('click', function() {
			$('#dialog-form').dialog('open');
		});
	});

	var getList = function() {
		$.ajax({
			url : './data/04user_list.jsp',
			type : 'get',
			dataType : 'json',
			success : function(json) {
				var list = '';
				$.each(json,function(index, item) {
					list += '<tr>';
					list += '<td id="seq" index="' + index + '">' + item.seq + '</td>';
					list += '<td id="name" index="' + index + '">' + item.name + '</td>';
					list += '<td id="email" index="' + index + '">' + item.email + '</td>';
					list += '<td id="password" index="' + index+ '">' + item.password + '</td>';
					list += '<td><button name="user-modify" id="' + item.seq + '" >수정</button></td>';
					list += '<td><button name="user-delete" id="' + item.seq + '">삭제</button></td>';
					/* list += '<td><button index="' + index + '" >수정</button></td>';
					list += '<td><button index="' + index + '">삭제</button></td>'; */
					list += '</tr>';
				})
				$('#users tbody').empty();
				// DB에서 다 읽어오면 테이블에 추가
				$('#users tbody').append(list);

				// 수정버튼눌렀을때 - me
				$('button[name="user-modify"]').button().on('click', function() {
					$('#modify-user-dialog-form #seq').attr('value', $(this).attr('id'));
					$('#modify-user-dialog-form').dialog('open');
				});
				// 강사님
				/* $('#users tbody button').button().on('click', function(){
					console.log($(this).text() + $(this).attr('index'));
					var index = $(this).attr('index');
					console.log($('#users tbody #name[index=' + index + ']').text());
					console.log($('#users tbody #email[index=' + index + ']').text());
					console.log($('#users tbody #password[index=' + index + ']').text());
				}) */
				// 삭제버튼눌렀을때 - me
				$('button[name="user-delete"]').button().on('click', function() {
					$('#delete-user-dialog-form #seq').attr('value', $(this).attr('id'));
					$('#delete-user-dialog-form').dialog('open');
				});
			},
			error : function(e) {
				alert('error ' + e.status);
			}
		})
	};

	var writeUser = function(name, email, password) {
		$.ajax({
			url : './data/04user_write.jsp',
			data : {
				name : name,
				email : email,
				password : password
			},
			type : 'get',
			dataType : 'json',
			success : function(json) {
				if (json.flag == 0) {
					getList();
					$('#dialog-form').dialog('close');
				} else {
					alert('생성 실패');
				}
			},
			error : function() {
				alert('생성 실패');
			}
		});
	};

	var modifyUser = function(name, email, password, seq) {
		$.ajax({
			url : './data/04user_modify.jsp',
			data : {
				name : name,
				email : email,
				password : password,
				seq : seq
			},
			type : 'get',
			dataType : 'json',
			success : function(json) {
				if (json.flag == 0) {
					$('#modify-user-dialog-form').dialog('close');
					getList();
				} else {
					alert('생성 실패');
				}
			},
			error : function() {
				alert('생성 실패');
			}
		})
	}

	var deleteUser = function(seq) {
		$.ajax({
			url : './data/04user_delete.jsp?seq=' + seq,
			type : 'get',
			dataType : 'json',
			success : function(json) {
				if (json.flag == 0) {
					$('#delete-user-dialog-form').dialog('close');
					getList();
				} else {
					alert('삭제 실패');
				}
			},
			error : function() {
				alert('삭제 실패');
			}
		})
	}
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
					<th>seq</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th colspan="2"></th>
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
				<input type="text" name="name" id="name" value="" class="text ui-widget-content ui-corner-all">
				<label for="email">Email</label> <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all">
				<label for="password">Password</label> <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all">
				Allow form submission with keyboard without duplicating the dialog button
				<input type="submit" tabindex="-1" style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>
	
	<!-- 수정창 -->
	<div id="modify-user-dialog-form" title="Modify user">
		<p class="validateTips">All form fields are required.</p>

		<form>
			<fieldset>
			<input type="hidden" id="seq" value="" />
				<label for="name">Name</label>
				<input type="text" name="name" id="name" value="" class="text ui-widget-content ui-corner-all">
				<label for="email">Email</label> <input type="text" name="email" id="email" value="" class="text ui-widget-content ui-corner-all">
				<label for="password">Password</label> <input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all">
				Allow form submission with keyboard without duplicating the dialog button
				<input type="submit" tabindex="-1" style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>
	
	<!-- 삭제창 -->
	<div id="delete-user-dialog-form" title="Delete user">
		<p class="validateTips">삭제하시겠습니까?</p>

		<form>
			<fieldset>
				<input type="hidden" id="seq" value="" />
				<input type="submit" tabindex="-1" style="position: absolute; top: -1000px">
			</fieldset>
		</form>
	</div>
</body>
</html>