<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.File" %>

<%
	// 파일을 업로드 하기 전 정해주어야 할 3가지.
	// 1. 서버의 어디에 업로드할지 경로
	// 2. 크기는 어디까지 업로드 가능할지
	// 3. 인코딩

	String uploadPath = "C:/java/OneDrive/Java/eclipse/jsp-workspace/MyStudy/WebContent/upload";
	int maxFileSize = 1024 * 1024 * 2;
	String encType = "utf-8";

	MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, encType,
			new DefaultFileRenamePolicy());
	String data1 = multi.getParameter("data1");
	String data2 = multi.getParameter("data2");
	
	out.println("data1 : " + data1 + "<br>");
	out.println("data2 : " + data2 + "<br>");
	out.println("ip : " + request.getRemoteAddr());
	String imgName = multi.getFilesystemName("upload1");
	out.println("<img src='./upload/" + imgName + "'>");
%>

