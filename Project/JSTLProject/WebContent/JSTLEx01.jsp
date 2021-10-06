<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<h1>JSTL을 배워보자!!!</h1>
	JSTL의 정식 명칭은 자바 서버 페이지 표준 태그 라이브러리(JavaServer Pages Standard Tag Library)이고 
	줄여서 JSTL이라 부른다. 
	JSTL은 Java EE 기반의 웹 애플리케이션 개발 플랫폼을 위한 컴포넌트 모음이다.
	<hr />
	JSTL을 사용하기 위해서는 taglib 디렉티브를 써줘야 한다.
	<hr />
	
	<c:forEach begin="10" end="100" step="5" var="i">
		<div style='font-size:${i}pt;'>야 호~~~~</div>
	</c:forEach>
</body>
</html>