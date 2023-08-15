<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL과 같이 써야 한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 배열 사용</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
</style>

</head>
<body>
	<h1>EL 배열 사용</h1>
	<c:set var="ar" value="<%=new int[]{11,22,33,44,55} %>" scope="request"/>

	${ar[0] },${ar[1] },${ar[2] },${ar[3] },${ar[4] },${ar[5] },${ar[6] } <br />
	<h1>배열의 내용</h1>
	<c:forEach var="i" items="${ar }" varStatus="cnt">
		ar[${cnt.index}] = ${i } <br />
	</c:forEach>


</body>
</html>