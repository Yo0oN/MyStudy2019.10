<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- pack.MemberTo파일을 생성하여 사용중이다.
	MemberTo to = new MemberTo();와 같은 뜻이다. -->
<jsp:useBean id="to" class="pack.MemberTo" />
<!-- setProperty를 이용하여 id의 setter메소드에 접근하여 id를 설정해준다.
	id에 직접 접근한것이 아니다! setter에 접근한것이다!
	to.setId("tester"); 	to.setPassword("1234"); 와 같은뜻이다.-->
<jsp:setProperty name="to" property="id" value="tester" />
<jsp:setProperty name="to" property="password" value="1234" />
<!-- getProperty를 이용하여 id의 getter메소드에 접근하여 값을 가져올 수 있다.
	out.println과 getXXX() 기능 둘다 포함되어있기 때문에 화면상에 출력된다.
	out.println(to.getId() + "<br>"); out.println(to.getPassword() + "<br>");와 같음 -->
<jsp:getProperty name="to" property="id" /><br>
<jsp:getProperty name="to" property="password" />
