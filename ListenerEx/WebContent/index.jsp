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
	<h1>리스너 연습</h1>
	현재 접속자수 : ${currCount }명 <br /><hr />
	<button onclick="location.href='addAppVar.jsp'">application영역에 변수 저장하기</button>
	<button onclick="location.href='replaceAppVar.jsp'">application영역에 변수 변경하기</button>
	<button onclick="location.href='removeAppVar.jsp'">application영역에 변수 삭제하기</button>
	<button onclick="location.href='removeSession.jsp'">세션 강제종료 하기</button>
</body>
</html>