<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URL"%>
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
	// 원격에 있는 이미지를 다운받아 저장해보자
	String imageName = "https://images.khan.co.kr/freecomics/0845/001/002.jpg";
	URL url = new URL(imageName);
	byte[] data = new byte[1024];
	String path = application.getRealPath("/");
	
	out.println(imageName + "<br>");
	out.println(path + imageName.substring(imageName.lastIndexOf("/")+1) + "<br>");
	
	FileOutputStream fos = new FileOutputStream(path + imageName.substring(imageName.lastIndexOf("/")+1));
	InputStream is = url.openStream();
	int length = 0;
	while((length=is.read(data))>0){
		fos.write(data, 0, length);
	}
	is.close();
	fos.close();
%>
	<a href='<%=imageName.substring(imageName.lastIndexOf("/")+1) %>'>보기</a>
</body>
</html>