<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.util.UUID"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String uploadPath = application.getRealPath("/upload/"); // upload는 폴더명 / 폴더의 경로를 구해옴
	out.println("저장경로 : " + uploadPath + "<br>");
	try{
		MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
				request, 
				uploadPath, // 파일을 저장할 디렉토리 지정
				10 * 1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10MB / 용량 초과 시 예외 발생
				"utf-8", // 인코딩 방식 지정
				new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
		);
		// 위처럼 1줄만 쓰면 업로드가 완료된다.
		// 이제 업로드된 정보를 출력해보자!!!!
		// 일반 폼필드 내용 받기
		String note1 = multi.getParameter("note1");
		String note2 = multi.getParameter("note2");
		out.println("설명 1 : " + note1 + "<br>");
		out.println("설명 2 : " + note2 + "<br>");
		
		// 파일 받기
		File file = multi.getFile("upfile");
		if(file!=null && file.exists()){
			out.println("저장 파일명 : " + multi.getFilesystemName("upfile") + "<br>");
			out.println("원본 파일명 : " + multi.getOriginalFileName("upfile") + "<br>");
			out.println("파일 종류 : " + multi.getContentType("upfile") + "<br>");
			out.println("파일 크기 : " + file.length() + "Byte<br>");
		}
		out.println("<hr>");
	}catch(Exception e){
		e.printStackTrace();
	}
	
	%>
</body>
</html>