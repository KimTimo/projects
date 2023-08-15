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
	<h2>c:set 태그는 변수를 선언할때 사용합니다.</h2>
	<%
		int i=100;
		request.setAttribute("i", i);
	%>
	i = ${i } <br />
	<hr />
	
	<c:set var="j" value="200" scope="request"/> <%-- 위의 두줄과 같은 것이다. --%>
	j = ${j } <br />
	<hr />
	
	<%
		int sum=0;
		for(int k=1;k<=100;k++){
			sum += k;
		}
		request.setAttribute("sum", sum);
	%>
	1 ~ 100까지 합 : ${sum } <br />
	
	<hr />
	
	<c:set var="sum2" value="0"></c:set>
	<c:forEach var="i" begin="1" end="100">
		<c:set var="sum2" value="${sum2 + i }"></c:set> <%-- EL 표현식으로 값 할당 가능 --%>
	</c:forEach>
	1 ~ 100까지 합 : ${sum2 } <br />
	
	<hr />
	
	<%-- c:remove 태그는 변수를 제거한다. 영역.removeAttrbute(변수명) --%>
	<% request.removeAttribute("sum"); %>
	1 ~ 100까지 합 : ${sum } <br />
	<c:remove var="sum2" scope="page"/>
	1 ~ 100까지 합 : ${sum2 } <br />
	
</body>
</html>