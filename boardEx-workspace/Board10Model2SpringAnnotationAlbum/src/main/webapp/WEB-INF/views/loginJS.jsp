<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		document.getElementById('search').onclick = function() {
			open('./search.do', 'win', 'top=100,left=100,width=640,height=270');
		};
		document.getElementById('login').onclick = function() {
			if (document.loginfrm.id.value.trim() == '') {
				alert('아이디를 입력해주세요.');
				return false;
			}
			if (document.loginfrm.loginPassword.value.trim() == '') {
				alert('비밀번호를 입력해주세요.');
				return false;
			}
			document.loginfrm.submit();
		};
