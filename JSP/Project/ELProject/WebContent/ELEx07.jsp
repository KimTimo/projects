<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h1>헤더 정보를 출력해보자 : 표현식 사용</h1>
	<%
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			Enumeration<String> values = request.getHeaders(name);
			out.println(name + " : ");
			while(values.hasMoreElements()){
				String value = values.nextElement();
				out.println(value + " ");
			}
			out.println("<br>");
		}
	%>
	<hr />
	host : <%=request.getHeader("host") %> <br />
	user-agent : <%=request.getHeader("user-agent") %> <br />
	<hr />
	
	<h1>헤더 정보를 출력해보자 : EL사용</h1>
	<hr />
	host : ${header.host } <br />
	host : ${header["host"] } <br />
	user-agent : ${header.user-agent } <br /> <%-- 이름에 연산자가 있으면 계산이 된다. 그러므로 반드시 []를 사용해야 한다. --%>
	user-agent : ${header["user-agent"] }<br />
	<hr />
	<%-- JSTL과 EL을 같이 사용하면 다음과같이 모든 헤더를 출력 가능하다. --%>
	<c:forEach var="headerName" items="${pageContext.request.headerNames }">
		${headerName } :
		<c:forEach var="value" items="${headerValues[headerName] }">
			${value }
		</c:forEach>
		<br>
	</c:forEach>
	
</body>
</html>