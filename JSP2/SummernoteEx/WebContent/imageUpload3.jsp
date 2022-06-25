<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
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
				String path = application.getRealPath("/upload/"); 
			    System.out.println(path);
			    String sFileName = UUID.randomUUID().toString(); // 유일한 문자열을 만들어준다.
			    // 실제 파일을 저장한다.
			    File file = new File(path + File.separator + sFileName); // 저장할 위치에 파일객체 생성
			    item.write(file); // 파일을 저장
			 	// 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
				String url = request.getContextPath() + "\\upload\\" + sFileName;
			   
			   // 업로드가 완료되면 3가지 정보를 리턴해 주어야 한다. JSON 형태로 리턴한다. 
			   JsonObject jsonObject = new JsonObject(); // JSON객체 생성
			   jsonObject.addProperty("uploaded", 1); // 항목 추가
			   jsonObject.addProperty("fileName", sFileName);
			   jsonObject.addProperty("url", url);
			   out.println(jsonObject); // 출력
			   // 아래 두줄은 지워도 된다. 정확한 값이 리턴되는지 출력만해보았다.
			   Gson gson = new Gson();
			   System.out.println(gson.toJson(jsonObject));
			}
		}
	}
%>
