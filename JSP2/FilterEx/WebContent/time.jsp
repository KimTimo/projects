<%@page import="java.util.Random"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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
	<%-- 이 파일의 실행시간을 알고싶다. --%>
	<% 
	// 1. 시작 전에 시간을 저장한다.
	// long startTime = System.currentTimeMillis();

	// 2. 원하는 작업을 수행한다.
	Thread.sleep(new Random().nextInt(1000));
		
	// 3. 종료시간을 구한다.
	// long endTime = System.currentTimeMillis();
	// System.out.println("time.jsp 실행시간 : " + (endTime - startTime) + "ms");
	%>
</body>
</html>