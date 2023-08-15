<%@page import="java.util.Random"%>
<%@page import="kr.green.email.util.PasswordUtil"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 검사 스크립트 연습</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		// 이메일 검사 스크립트 연습
		/*
		alert(verifyEmail("xxx"));
		alert(verifyEmail("xxxx@xxx"));
		alert(verifyEmail("xxxx@xxx.com"));
		*/
	});
</script>
</head>
<body>
	<%
		// 이미지 생성 테스트
		Random rnd = new Random();
		for(int i=0;i<10;i++){
			String imageName = PasswordUtil.generateImageAuth(5 + rnd.nextInt(7), application.getRealPath("/imageAuth/"));
			out.println("<img src='imageAuth/" + imageName + ".jpg'><br><br>");
		}
	%>
</body>
</html>