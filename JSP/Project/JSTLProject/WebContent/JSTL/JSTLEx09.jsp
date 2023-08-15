<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 이동</title>
</head>
<body>
	<%-- URL주소를 만들어 준다. 자동 인코딩 됨 --%>
	<c:url var="url" value="view.jsp">
		<c:param name="data1" value="qwerty"/>
		<c:param name="data2" value="한글"/>
	</c:url>
	<%-- JSP의 response.sendRedirect 대신 사용 --%>
	<c:redirect url="${url }"/>
	<%--
	<c:redirect url="view.jsp">
		<c:param name="data1" value="qwerty"/>
		<c:param name="data2" value="한글"/>
	</c:redirect>
	 --%>
</body>
</html>