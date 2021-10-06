<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<h2>JSTL 반복문 : c:forEach </h2>
	<c:forEach var="i" begin="1" end="10">
		${i } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br /><hr />
	<c:forEach var="i" begin="1" end="10" step="2">
		${i } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br /><hr />
	역순 1 : 
	<c:forEach var="i" begin="10" end="1" step="2">
		${i } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br /><hr />
	역순 2 : 
	<c:forEach var="i" begin="1" end="10">
		${11-i } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br /><hr />
	Collection 1 : 
	<c:forEach var="item" items="<%=new int[]{11,22,33,44,55,66,77} %>">
		${item } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br /><hr />
	
	Collection 2 : 
	<c:forEach var="item" items="<%=new int[]{11,22,33,44,55,66,77} %>" begin="2" end="4">
		${item } &nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br /><hr />
	
	Collection 2 : <br />
	<%-- 
	varStatus="vs" : 실행정보를 알아낼때 사용한다.
	index는 데이터의 몇번째
	count는 반목문의 반복 회수를 나타낸다.
	 --%>
	<c:forEach var="item" items="<%=new int[]{11,22,33,44,55,66,77} %>" begin="2" end="4" varStatus="vs">
		${vs.index } : ${vs.count } : ${item } <br />
	</c:forEach>
	<br /><hr />
	<%-- c:forTokens : 문자열을 구분자로 구분해준다. --%>
	<c:forTokens var="item" items="한놈,두식이,석삼,너구리,오징어" delims=",">
		 ${item } <br />
	</c:forTokens>
	<br /><hr />
	<c:forTokens var="item" items="한놈,두식이.석삼-너구리*오징어" delims=",.-*">
		 ${item } <br />
	</c:forTokens>
	<br /><hr />
	
</body>
</html>