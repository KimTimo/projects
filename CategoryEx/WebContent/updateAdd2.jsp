<%@page import="kr.green.category.service.CategoryService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		
	});
</script>
</head>
<body>
	<%-- 한글이 깨진다. 깨지지 않게하려면 다음을 꼭 기술해야 한다. --%>
	<fmt:requestEncoding value="UTF-8"/>
	<%-- POST 방식이 아니면 리스트로 보낸다. --%>
	<c:if test='${pageContext.request.method != "POST"  }'>
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
	<%-- 넘어온 데이터를 받자 --%>
	<jsp:useBean id="vo" class="kr.green.category.vo.CategoryVO" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="vo"/>
	<%-- 서비스를 호출하여 저장을 수행한다. --%>
	${vo }
	<%
		CategoryService.getInstance().insert(vo);
	%>
	<%-- 리스트로 보낸다. --%>
	<c:redirect url="index.jsp"></c:redirect>
</body>
</html>