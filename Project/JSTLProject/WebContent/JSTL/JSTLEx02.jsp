<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 태그 연습</title>
</head>
<body>
	<%-- c:set 태그는 변수를 선언한다. --%>
	
	<c:set  var="sum" value="0"/> <%-- int sum=0과 같다 --%>
	<c:forEach var="i" begin="1" end="100"> <%-- 1~100까지 반복 --%>
		<c:set  var="sum" value="${sum + i }"/> <%-- sum = sum + i 와 같다 --%>
	</c:forEach>
	
	1~100까지 합 : ${sum } <br />
	
	<%-- c:remove 태그는 변수를 삭제한다.  --%>
	<c:remove var="sum" />
	<c:remove var="sum" scope="session"/>
	
	1~100까지 합 : ${sum } <br />
	
</body>
</html>