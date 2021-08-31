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
		// 로그인 버튼 클릭 이벤트
		$("#goLogin").click(function() {
			location.href='login.jsp';
		});
		// 로그아웃 버튼 클릭 이벤트
		$("#goLogout").click(function() {
			location.href='logout.jsp';
		});
		// 회원가입 버튼 클릭 이벤트
		$("#goJoin").click(function() {
			location.href='join.jsp';
		});
	});
</script>
</head>
<body>
	<c:if test="${not empty sessionScope.mvo }">
		${sessionScope.mvo } <br />
		<hr />
		<input type="button" value=" 로그아웃 " id="goLogout" class="btn btn-outline-success btn-sm"/>
	</c:if>
	<c:if test="${empty sessionScope.mvo }">
		<input type="button" value=" 로그인 " id="goLogin" class="btn btn-outline-success btn-sm"/>
		<input type="button" value=" 회원가입 " id="goJoin" class="btn btn-outline-success btn-sm"/>
	</c:if>
</body>
</html>