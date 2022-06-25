<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr />
<a href="test">DB 연동 테스트</a>
<a href="${pageContext.request.contextPath }/test/uploadForm">파일 업로드 테스트</a>
<a href="${pageContext.request.contextPath }/board/list">게시판 보기</a>

</body>
</html>
