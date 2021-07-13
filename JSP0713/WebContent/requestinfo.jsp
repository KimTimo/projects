<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 기본 객체 사용</title>
</head>
<body>
    <h2>서버정보</h2>
	getServerName : <%= request.getServerName() %> <br />
	getServerPort : <%= request.getServerPort() %> <br />
	getLocalAddr : <%= request.getLocalAddr() %> <br />
	getLocalName : <%= request.getLocalName() %> <br />
	getLocalPort : <%= request.getLocalPort() %> <br />
	getLocale : <%= request.getLocale() %> <br />
	getMethod : <%= request.getMethod() %> <br />  <!-- 많이씀!! -->
	
	<hr />
	<h2>클라이언트 정보<h2/>
	getRemoteHost : <%= request.getRemoteHost() %> <br />
	getRemoteAddr : <%= request.getRemoteAddr() %> <br />  <!-- 많이씀!! -->
	getRemotePort : <%= request.getRemotePort() %> <br />
	getRemoteUser : <%= request.getRemoteUser() %> <br />
	<hr />
	<h2>현재 페이지 정보</h2>
    getContextPath : <%=request.getContextPath() %> <br />  <!-- 많이씀!! -->
    getRequestURI  : <%=request.getRequestURI() %> <br />   <!-- 많이씀!! -->
    getRequestURL  : <%=request.getRequestURL() %> <br />   <!-- 많이씀!! -->
    getServletPath : <%=request.getServletPath() %> <br />  <!-- 많이씀!! -->
    getQueryString : <%=request.getQueryString() %> <br />  <!-- 많이씀!! -->
    getRealPath    : <%=request.getRealPath(".") %> <br />  <!-- 많이씀!! 서버의 실제 경로 -->




</body>
</html>