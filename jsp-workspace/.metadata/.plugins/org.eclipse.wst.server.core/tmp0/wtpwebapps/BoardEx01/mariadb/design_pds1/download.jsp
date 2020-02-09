<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.net.URLEncoder"%>

<%
	String filename = request.getParameter("filename");
	String downPath = "C:/java/OneDrive/Java/eclipse/jsp-workspace/BoardEx01/WebContent/upload/" + filename;
	out.clearBuffer();
	// 아래 두 줄이 때문에 이 페이지로 이동이 아닌 다운로드만 하게 해준다.
	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "utf-8"));
	//response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("파일이름강제설정.jsp", "utf-8"));

	FileInputStream fis = new FileInputStream(downPath);
	ServletOutputStream sos = response.getOutputStream();
	int data;
	byte readByte[] = new byte[4096];
	while ((data = fis.read(readByte, 0, readByte.length)) != -1) {
		sos.write(readByte, 0, data);
	}
	sos.flush();
	sos.close();
	fis.close();
%>
