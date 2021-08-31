<%@page import="java.net.InetAddress"%>
<%@page import="java.io.File"%>
<%@page import="java.util.UUID"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	// Commons-FileUpload를 이용한 파일 업로드
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if(isMultipart){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = upload.parseRequest(request);
		for(FileItem item : items){
			if(!item.isFormField()){
				String path = application.getRealPath("/summernote/"); 
			    String sFileName = UUID.randomUUID().toString(); // 유일한 문자열을 만들어준다.
			    // 실제 파일을 저장한다.
			    File file = new File(path + File.separator + sFileName); // 저장할 위치에 파일객체 생성
			    item.write(file); // 파일을 저장
			 	//업로드된 경로와 파일명을 통해 이미지의 경로를 생성
			 	//  다른 컴퓨터로 이 내용가 전달될때도 이미지가 보이려면 앞에 받드시
			 	// 이미지가 있는 서버의 주소까지 전달해야 한다. : "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080"
				String path2 = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080" + request.getContextPath() + "\\summernote\\" + sFileName;
			    // 이미지의 이름만 리턴한다.
				out.print(path2);	
			    System.out.println(path2);
			}
		}
	}
%>
