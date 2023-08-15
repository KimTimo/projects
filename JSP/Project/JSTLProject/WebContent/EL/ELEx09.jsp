<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL과 같이 써야 한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL pageContext 객체</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
</style>

</head>
<body>
	<h1>EL pageContext 객체</h1>
	접속자 IP : <%=request.getRemoteAddr() %> <br />
	접속자 IP : ${pageContext.request.remoteAddr } <br />
	${pageContext.request.contextPath }/ELEx01.jsp <br />
	
	<%-- request영역에 gender란 변수를 만든다. --%>
	<c:set var="gender" value="true" scope="request"/>
	
	성별  : ${gender eq true ? "남자":"여자" } <br />
	성별  : ${gender ? "남자":"여자" } <br />
	성별  : ${gender ne true ? "여자":"남자" } <br />
	${empty param.ID ? "손" : param.ID }님 반갑습니다. <br />
</body>
</html>