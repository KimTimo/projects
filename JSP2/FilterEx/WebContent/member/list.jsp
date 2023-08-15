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
	<%-- 이 폴더가 회원전용 페이지라면 
	     모든 파일의 상단에 세션을 검사해서 로그인되어 있지 않으면 
	     로그인페이지로 보내주는
	     코드를 입력해 주어야 한다.  
	--%>
	<% 
	if(session.getAttribute("userid")==null){
		response.sendRedirect("../list.jsp");	
	} 
	%>


	회원 전용페이지 입니다. <br />
	<button onclick='location.href="../logout.jsp"'>로그아웃</button>
</body>
</html>