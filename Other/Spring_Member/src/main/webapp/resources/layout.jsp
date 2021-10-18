<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	   <!-- 원래 타이틀을 []로 감싸라 -->
<title>[<sitemesh:write property='title' />]</title>
<!-- axicon 사용하기 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/axicon/axicon.min.css" />
<!-- Jquery사용하기 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<!-- Bootstrap사용하기 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<!-- 헤더 태그안의 모든 내용을 여기에 넣어라 -->
<sitemesh:write property='head' />
</head>
<body>
	<h1> <i class="axi axi-axisj"></i> 상단</h1>
	<hr />
	<div class='mainBody'>
		<!-- BODY 태그안의 모든 내용을 여기에 넣어라 -->
		<sitemesh:write property='body' />
	</div>
	<hr />
	<h1> <i class="axi axi-axu"></i> 하단</h1>
</body>
</html>