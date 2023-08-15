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
	// 일반전송인지 파일전송인지를 판단한다.
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if(isMultipart){
		// 파일이 전송 되었다면
		// 파일을 받기 위하여 DiskFileItemFactory 객체를 선언한다.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// ------------ 선택사항 시작 -------------------------
		// 시스템의 임시 폴더를 알아낸다.
		// ServletContext servletContext = this.getServletConfig().getServletContext();
		//File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		// 임시폴더를 지정한다.
		//factory.setRepository(repository);
		//factory.setSizeThreshold(1024*10); // 메모리 사이즈 최대지정
		// ------------ 선택사항 종료 -------------------------

		// DiskFileItemFactory 객체를 이용하여 실제 업로드를 실행할 ServletFileUpload객체 생성
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//upload.setSizeMax(10*1024*1024); // 파일의 최대크기 지정. 지정하지 않으면 서버의 값이 적용된다.

		// 넘어온 모든데이터를 파싱해서 FileItem객체를 저장하는 리스트를 얻는다.
		List<FileItem> items = upload.parseRequest(request);
		
		// 이제 반복문을 이용하여 1개씩 직접 처리하면 된다.
		for(FileItem item : items){
			//파일인지 일반 데이터인지를 판단해서 처리한다.
			if(item.isFormField()){
				// 일반 필드라면
				String name = item.getFieldName(); 			// 이름읽기
			    String value = item.getString("UTF-8");   	// 내용읽기
			    out.println(name + " : " + value + "<br>");
			}else{
				// 파일이 넘어왔다면
				String fieldName = item.getFieldName();	// 필드 이름 읽기
			    String fileName = item.getName();       // 파일명 
			    String contentType = item.getContentType(); // 파일 종류
			    boolean isInMemory = item.isInMemory();  // 파일로 저장되었지만 메모리에 저장되었는지를 판단
			    long sizeInBytes = item.getSize(); // 파일의 크기
			    out.println((isInMemory ? "메모리" : "파일") + "에 저장<br>");
			    out.println( "필드 이름 : " + fieldName + "<br>");
			    out.println( "파일 이름 : " + fileName + "<br>");
			    out.println( "파일 종류 : " + contentType + "<br>");
			    out.println( "파일 크기 : " + sizeInBytes + "Byte<br>");
			    if(sizeInBytes>0){
				    // 위의 결과를 이용하여 저장할 파일의크기나 종류를 제어할 수 있다. 
				    // 임시 폴더나 메모리에 있는 파일의 내용을 서버릐 사용자가 원하는 위치로 복사해야 한다.
				    // 파일이을에서 파일의 이름만 잘라내어보자
				    String oFileName = "";
				    if(fileName.lastIndexOf(File.separator)!=-1){ // 파일이름에 \나/가 있다면 뒤의 파일명만 잘라낸다.
				    	oFileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
				    }
				    String path = application.getRealPath("/upload/"); 
				    out.println( "저장 위치 : " + path + "<br>");
				    out.println( "원본 파일 이름 : " + oFileName + "<br>");
				    String sFileName = UUID.randomUUID().toString(); // 유일한 문자열을 만들어준다.
				    out.println( "저장 파일 이름 : " + sFileName + "<br>");
				    // 실제 파일을 저장한다.
				    File file = new File(path + File.separator + sFileName); // 저장할 위치에 파일객체 생성
				    item.write(file); // 파일을 저장
				    out.println( "저장 : " + file.getAbsolutePath() + "<br>");
			    }
			    out.println("<hr>");
			}
		}
	}else{
		// 일반전송이면 입력폼으로 보내버린다.
		out.println("<script>");
		out.println("alert('장난치면 죽는다.!!!!');");
		out.println("location.href='uploadForm1.jsp'");
		out.println("</script>");
	}
	%>
</body>
</html>