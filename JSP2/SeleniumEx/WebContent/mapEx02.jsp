<%@page import="java.io.PrintWriter"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.green.selenium.MapVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.green.selenium.MapUtil"%>
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
	String driverPath = application.getRealPath("/chromeDriver/chromedriver.exe");
	List<MapVO> mapList = MapUtil.getMap(driverPath);
	
	// mapList을 json으로 저장해보자!!!
	String filename = application.getRealPath("/map/") + "map.json";
	Gson gson = new Gson();
	PrintWriter fw = new PrintWriter(filename);
	gson.toJson(mapList, fw);
	fw.close();
	out.println(filename + "저장 완료!!!");
	
	request.setAttribute("mapList", mapList);
	%>
	<c:forEach var="vo" items="${mapList }">
		<h3>${vo.area }</h3>
		<img src="http://www.event-tv.co.kr${vo.img }"/> <br />
	</c:forEach>
</body>
</html>