<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 태그 연습</title>
</head>
<body>
	<c:set var="ar" value="<%=new int[]{11,22,33,44,55,66,77} %>" scope="request"/>
	<%-- c:foreach 태그는 반복한다. --%>
	<c:forEach var="item" items="${ar }">
		${item } <br />
	</c:forEach>
	<hr />
	<%-- 두번째 부터 4번째까지만 반복 --%>
	<c:forEach var="item" items="${ar }" begin="1" end="3">
		${item } <br />
	</c:forEach>
	<hr />
	<%-- index는 첨자, count는 반복횟수 --%>
	<c:forEach var="item" items="${ar }" begin="2" end="5" varStatus="vs">
		${item } - ${vs.index } - ${vs.count } <br />
	</c:forEach>
	<hr />

</body>
</html>