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
	<%-- fmt:requestEncoding 태그 : request.setCharacterEncoding("UTF-8") 과 같은 일을하는 JSTL태그 --%>
	<fmt:requestEncoding value="UTF-8"/>
	이름 : ${param.name } <br />나이 : ${param.age } <br /> <hr />
	${pageContext.request.method} <%-- 메서드 알아내기 --%>
	<br /> <hr />
	<%-- POST방식의 전송이 아니면  --%>
	<c:if test="${pageContext.request.method != 'POST' }">
		<c:redirect url="myform.jsp"></c:redirect> <%-- myform.jsp로 가라!!! --%>
	</c:if>
	
	<c:if test="${param.age ge 20 }"> <%-- 20세 이상이면 --%>
		${param.name }씨는 성년입니다.
	</c:if>
	
	<c:if test="${param.age lt 20 }"> <%-- 20세 미만이면 --%>
		${param.name }씨는 미성년입니다.
	</c:if>
	
</body>
</html>