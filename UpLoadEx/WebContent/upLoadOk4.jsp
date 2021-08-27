<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Enumeration"%>
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
		out.println("<hr>");
		
		Enumeration<String> em = multi.getFileNames();
		while(em.hasMoreElements()){
			String fieldName = em.nextElement();
			// 파일 받기
			File file = multi.getFile(fieldName);
			if(file!=null && file.exists()){
				// 파일을 링크를 걸어버리면 브라우저에 따라 해석이 가능하면 내용을 보여주고
				// 브라우져가 해석이 불가능하면 다운로드가 된다.
				// 그래서 어떤 파일이든 다운로드를 하려면 download.jsp파일을 만들어서 호출하게 하면 된다. 
				out.println("저장 파일명 : <a href='upload\\" + multi.getFilesystemName(fieldName) + "'>"+multi.getOriginalFileName(fieldName)+"</a><br>");
				out.println("다운로드 : <a href='download.jsp?sf=" 
				// IE의 경우 주소표시줄에 한글이 허용되지 않는다. 그래서 반드시 인코딩을 해줘야 한다.		
				+ URLEncoder.encode(multi.getFilesystemName(fieldName),"UTF-8") 
				+ "&of=" + URLEncoder.encode(multi.getOriginalFileName(fieldName),"UTF-8")  
				+ "'>"+multi.getOriginalFileName(fieldName)+"</a><br>");
				out.println("원본 파일명 : " + multi.getOriginalFileName(fieldName) + "<br>");
				out.println("파일 종류 : " + multi.getContentType(fieldName) + "<br>");
				out.println("파일 크기 : " + file.length() + "Byte<br><hr>");
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	%>
</body>
</html>