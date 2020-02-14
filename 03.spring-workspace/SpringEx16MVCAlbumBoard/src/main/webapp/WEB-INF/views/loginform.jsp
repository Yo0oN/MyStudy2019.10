<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action='./login_ok.do' method='post' name='loginfrm'>
	<div class='con_title'>
		<p style='margin: 0px; text-align: right'>
			아이디 : <input type='text' name='id' class='board_login_input' maxlength='5' />
			비밀번호 : <input type='password' name='loginPassword' class='board_login_input' />
			<input type='submit' value='로 그 인' id='login' class='btn_write btn_txt01' style='cursor: pointer;' />
			<input type='button' value='회원 가입' class='btn_write btn_txt01' style='cursor: pointer;' onclick="location.href='./join.do'" />
			&nbsp;
			<input type='button' id='search' value='찾     기' class='btn_write btn_txt01' style='cursor: pointer;' />
		</p>
	</div>
</form>
