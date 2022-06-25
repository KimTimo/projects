<%@page import="kr.green.select.DongUtil"%>
<%@page import="kr.green.select.vo.AreaVO"%>
<%@page import="java.util.List"%>
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
	<%
		String filename = application.getRealPath("/dong.json");
		List<AreaVO> listItem = DongUtil.readItem1(filename);
		/*
		out.println(listItem.size() + "개<br>");
		for(AreaVO vo : listItem){
			out.println(vo.toString() + "<br>");
		}
		*/
		request.setAttribute("listItem", listItem);
	%>
	<hr />
	시도 : 
	<select name="item1" id="item1">
		<option>선택</option>
		<c:forEach var="vo" items="${listItem }">
			<option value="${fn:substring(vo.code,0,2) }">${vo.name }</option>
		</c:forEach>
	</select>
	<br />
	시군구 : 
	<select name="item2" id="item2">
		<option>선택</option>
	</select>
	<br />
	읍면동 : 
	<select name="item3" id="item3">
		<option>선택</option>
	</select>
	<br />
	리 : 
	<select name="item4" id="item4">
		<option>선택</option>
	</select>
	<br />
</body>
</html>