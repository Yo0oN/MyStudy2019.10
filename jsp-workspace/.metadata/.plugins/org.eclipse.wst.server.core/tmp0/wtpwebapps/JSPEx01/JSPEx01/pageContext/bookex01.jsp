<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <%! %>부분은 멤버변수, 메소드를 선언하는곳이다.
		이를 이용하여 work라는 메소드를 하나 만들어 주었다. -->
	<%!public void work(String p, PageContext pc) {
		try {
			JspWriter out = pc.getOut();
			// 만약 p의 값이 include이면 test.jsp가 현재페이지에 포함된다.
			// forward면 test.jsp 페이지로 이동한다.
			if (p.equals("include")) {
				out.print("-- inlude 전 -- <br>");
				pc.include("test.jsp");
				out.print("-- inlude 후 -- <br>");
			} else if (p.equals("forward")) {
				pc.forward("test.jsp");
			}
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
	}%>
	<%
		String p = request.getParameter("p");
		this.work("forward", pageContext);
	%>
</body>
</html>