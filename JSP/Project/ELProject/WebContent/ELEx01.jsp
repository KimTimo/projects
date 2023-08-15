<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<h1>익스프레션 언어(expression language)란?</h1>
	<ul>
		<li>식(expression)을 중심으로 코드를 기술하는 언어 => $</li>
		<li>연산자와 피연산자의 조합을 $ { 와 }로 둘러싸서 표현한다.</li>
	</ul>
	<hr />
	클라이언트 IP 주소 : <%=request.getRemoteAddr() %> <br />
	클라이언트 IP 주소 : ${pageContext.request.remoteAddr } <br />
</body>
</html>