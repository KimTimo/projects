<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<P>  The time on the server is ${serverTime}. </P>
	<a href='<c:url value="/test"/>'>테스트해보기</a>
	<a href='<c:url value="/mem/list"/>'>회원 전용 페이지 가기</a>
	<a href='<c:url value="/admin/list"/>'>관리자 전용 페이지 가기</a> <br />
	<hr />
	<c:if test='${pageContext.request.userPrincipal.name == null }'>
		<a href="${pageContext.request.contextPath }/login">로그인</a>
		<a href="${pageContext.request.contextPath }/join">회원가입</a>
		<a href="${pageContext.request.contextPath }/useridSearch">아이디찾기</a>
		<a href="${pageContext.request.contextPath }/passwordSearch">비번찾기</a>
	</c:if>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			${mvo.username }(${mvo.userid })님 반갑습니다.
			<%-- 시큐리티에 있는 로그아웃을 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="로그아웃">
			<input type="button" value="정보수정" onclick="location.href='${pageContext.request.contextPath }/update'">
			<input type="button" value="회원탈퇴" onclick="location.href='${pageContext.request.contextPath }/delete'">
		</form>
	</c:if>
	<hr />
	로그인 정보 :  ${user } <br />
	세션정보 : ${sessionScope.mvo } <br />
</body>
</html>
