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
	<h1>하하하하 나는 상단</h1>
	<hr />
	<%-- 인코딩된 URL주소를 만들어 준다. --%>
	<c:url var="url1" value="https://green.kr">
		<c:param name="name" value="한사람"></c:param>
		<c:param name="age" value="22"></c:param>
		<c:param name="gender" value="남자"></c:param>
	</c:url>
	
	<h2>${url1 }</h2>

	<c:url var="url2" value="list.jsp">
		<c:param name="p" value="5"></c:param>
		<c:param name="b" value="10"></c:param>
		<c:param name="s" value="10"></c:param>
		<c:param name="idx" value="66"></c:param>
		<c:param name="m" value="list"></c:param>
	</c:url>
	
	<h2>${url2 }</h2>
	
	

</body>
</html>