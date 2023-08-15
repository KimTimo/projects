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
	누구나 접근 가능한 페이지 입니다. <br />
	<% if(session.getAttribute("userid")!=null){ %>
		<button onclick='location.href="logout.jsp"'>로그아웃</button>
	<% }else{ %>	
		<button onclick='location.href="login.jsp"'>로그인</button>
	<% } %>
	<br /><hr />
	<a href="member/list.jsp">회원전용페이지1(직접 코드 사용) 가기</a>
	<a href="member2/list.jsp">회원전용페이지2(필터 적용) 가기</a>
		
</body>
</html>