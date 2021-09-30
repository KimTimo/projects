<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr />
<a href="${pageContext.request.contextPath }/resources/Ex01.jsp">1. 기본 달력 띄우기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex02.jsp">2. 로케일(국가/언어) 변경하기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex03.jsp">3. 툴바 변경하기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex04.jsp">4. 이벤트 추가하기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex05.jsp">5. 클릭 이벤트 추가하기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex06.jsp">6. JSON 이벤트 표시하기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex07.jsp">7. JSON 파일 이벤트 표시하기</a> <br />
<a href="${pageContext.request.contextPath }/resources/Ex08.jsp">8. 사용자별 이벤트 표시하기</a> <br />
</body>
</html>
