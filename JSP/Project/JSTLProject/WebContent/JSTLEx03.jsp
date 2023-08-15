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
	<h2>c:if 태그는 조건을 판단할때 사용합니다.</h2>
	<%-- test="${empty param }" : 인수가 넘어오지 않았으면 --%>
	<c:if test="${empty param }">
		주소 표시줄 뒤에 "?num=숫자"를 붙여서 실행하세요
	</c:if>
	<%-- test="${not empty param }" : 인수가 넘어 왔으면 --%>
	<c:if test="${not empty param }">
		<c:if test="${param.num==0 }">
			${param.num }은 "영"입니다 <br />
		</c:if>
		<c:if test="${param.num>0 }">
			${param.num }은 "양수"입니다 <br />
		</c:if>
		<c:if test="${param.num<0 }">
			${param.num }은 "음수"입니다 <br />
		</c:if>
		<hr />
		<%-- c:choose태그는 switch를 대신한다. --%>
		<c:choose>
			<c:when test="${param.num>0 }">
				${param.num }은 "양수"입니다 <br />
			</c:when>
			<c:when test="${param.num<0 }">
				${param.num }은 "음수"입니다 <br />
			</c:when>
			<c:otherwise>
				${param.num }은 "영"입니다 <br />
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>