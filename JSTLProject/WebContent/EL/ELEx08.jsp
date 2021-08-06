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
<title>EL로 헤더값 읽기</title>
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
	<h1>EL로 헤더값읽기</h1>
	<h1>EL 사용하지 않았을 경우</h1>
	host :
	<%=request.getHeader("host")%>
	<br /> user-agent :
	<%=request.getHeader("user-agent")%>
	<br />
	<hr />
	<h1>EL 사용했을 경우</h1>
	host : ${header.host }
	<br /> user-agent : ${header.user-agent}
	<br /> user-agent : ${header["user-agent"]}
	<br />
	<hr />
	<h1>모든 헤더를 출력해 보자</h1>
	<h1>EL 사용하지 않았을 경우</h1>
	<%
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println(headerName + " : ");
			Enumeration<String> values = request.getHeaders(headerName);
			while (values.hasMoreElements()) {
				out.println(values.nextElement() + "<br>");
			}
		}
	%>
	<hr />
	<h1>EL 사용했을 경우</h1>
	<c:forEach var="headerName" items="${pageContext.request.headerNames }">
		${headerName } :
		<c:forEach var="value" items="${headerValues[headerName] }">
			${value }
		</c:forEach>
		<br>
	</c:forEach>
	<hr />
	쿠키값 찍기 : ${cookie.JSESSIONID } <br />
	쿠키값 찍기 : ${cookie.JSESSIONID.value } <br />
	
</body>
</html>