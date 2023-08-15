<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8"/>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<hr />
	현재 사용자 : ${user }
	<br />
	<hr />
	<a href="admin">관리자 페이지 가기</a>
	<a href="dba">DB관리자 페이지 가기</a>
	<a href="home">일반페이지 가기</a>
	<c:if test='${user!="anonymousUser" }'>
		<a href="${pageContext.request.contextPath }/logout?_csrf=${_csrf.token}">로그아웃</a>
	</c:if>
	<c:if test='${user=="anonymousUser" }'>
		<a href="${pageContext.request.contextPath }/login">로그인</a>
	</c:if>
	<hr />
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<c:url value="/logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<%-- 시큐리티에 있는 로그아웃을 사용하려면 아래의 내용도 넘겨줘야 한다. --%>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" value="로그아웃">
			</form>
		</c:if>
	<hr />
	<a href="${pageContext.request.contextPath }/getPwd">비밀번호 암호화 확인하기</a>
	<a href="${pageContext.request.contextPath }/checkPwd">비밀번호 일치비교 확인하기</a>
</body>
</html>
