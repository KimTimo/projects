<%@page import="java.util.Arrays"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL param 내장 객체</title>
</head>
<body>
	<%
		// http://localhost:8080/ELProject/ELEx05.jsp?name=kimc&age=22&hobby=aa&hobby=bb&hobby=cc 
		// 주소 표시줄 뒤에 "?name=kimc&age=22&hobby=aa&hobby=bb&hobby=cc "를 붙여서 실행해 보세요
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String[] hobby = request.getParameterValues("hobby");
	%>
	<h1>지금까지의 데이터 받아 출력하기</h1>
	이름  : <%=name %> <br />
	나이  : <%=age %> <br />
	취미  : <%=Arrays.toString(hobby) %> <br />
	<hr />
	이름  : ${param.name } <br />
	나이  : ${param.age } <br />
	취미  : ${paramValues.hobby[0]},  ${paramValues.hobby[1]},  ${paramValues.hobby[2]},  <br />
</body>
</html>