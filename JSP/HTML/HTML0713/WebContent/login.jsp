<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 클라이언트로 부터 넘어온 요청 자료를 받는다
request.setCharacterEncoding("UTF-8");
String userid = request.getParameter("userid");
String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	사용자 아이디 :
	<%=userid%>
	<br /> 사용자 비밀번호 :
	<%=password%>
	<br />
    <!-- 실제 로그인처리를 해줘야 한다. -->
</body>
</html>