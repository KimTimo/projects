<%@ page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// EL로 출력하기 위해서는 반드시 page, request, session, application 객체에 저장이 되어 있어야만 출력이 가능
	String name = null;
	request.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	초기화 되지 않은 변수의 출력 : <%=name%> <br />
	초기화 되지 않은 변수의 출력 : <%=name!=null ? name : ""%> <br />
	초기화 되지 않은 변수의 출력 : ${name } <br />
	
</body>
</html>