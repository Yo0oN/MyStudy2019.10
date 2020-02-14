<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>

<div class="con_title">
	<p style="margin: 0px; text-align: right">
		<%=id %> 님 환영합니다. <input type="button" value="로그아웃"
			class="btn_write btn_txt01" style="cursor: pointer;"
			onclick="location.href='./logout_ok.do'" />
			<input type="button"
			value="회원수정" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='./member_modify.do'" />
	</p>
</div>
