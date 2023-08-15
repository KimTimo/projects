<%@page import="java.util.Arrays"%>
<%@ page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL initParam 내장 객체</title>
</head>
<body>
	<h1>web.xml에 저장된 변수 읽기 : 표현식 사용</h1>
	아이디 : <%=application.getInitParameter("id") %> <br />
	비밀번호 : <%=application.getInitParameter("pwd") %> <br />
	별명 : <%=application.getInitParameter("nick") %> <br />
	
	<h1>web.xml에 저장된 변수 읽기 : EL 사용</h1>
	아이디 : ${initParam.id } <br />
	비밀번호 :  ${initParam.pwd }  <br />
	별명 :  ${initParam.nick }  <br />
	
	
</body>
</html>