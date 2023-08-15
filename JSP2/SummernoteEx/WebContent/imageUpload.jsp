<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%
	// COS라이브러리를 이용한 업로드
	request.setCharacterEncoding("UTF-8");
	//System.out.println("호출이 되나요~~~~~~~~~~~~~~");
	// 이미지 업로드할 경로
	String uploadPath = application.getRealPath("/upload/");
	//System.out.println(uploadPath);
    int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
	String fileName = ""; // 파일명
	try{
        // 파일업로드 및 업로드 후 파일명 가져옴
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		Enumeration<String> files = multi.getFileNames();
		String fieldName = files.nextElement(); 
		fileName = multi.getFilesystemName(fieldName); 
	    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
		String path = request.getContextPath() + "\\upload\\" + fileName;
	    // 이미지의 이름만 리턴한다.
		out.print(path);	
		//System.out.println(path);
	}catch(Exception e){
		e.printStackTrace();
	}
%>
