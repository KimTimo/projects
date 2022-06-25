<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>

    
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			${mvo.username }(${mvo.userid })님 반갑습니다.
			<%-- 시큐리티에 있는 로그아웃을 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="로그아웃">
			<input type="button" value="비밀번호바꾸기" onclick="location.href='${pageContext.request.contextPath }/changePassword'">
			<input type="button" value="회원탈퇴" onclick="location.href='${pageContext.request.contextPath }/delete'">
			<input type="button" value="게시판" onclick="location.href='${pageContext.request.contextPath }/list'">
		</form>
	</c:if>
</body>
</html>
