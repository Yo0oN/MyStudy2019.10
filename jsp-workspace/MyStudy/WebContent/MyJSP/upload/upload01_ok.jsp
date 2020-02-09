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
	// 저장된 파일명
	out.println(multi.getFilesystemName("upload1") + "<br>");
	// 실제 파일명
	out.println(multi.getOriginalFileName("upload1") + "<br>");
	// 파일 객체 접근하기
	File file = multi.getFile("upload1");
	// 파일의 크기를 알아오기. byte 단위로 알려준다.
	out.println(file.length() + "<br>");
%>
