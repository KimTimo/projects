<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<%
	int ar[] = {11,22,33,44,55,66,77};
	pageContext.setAttribute("ar", ar);
	%>
	배열에 접근<br>
	ar배열의 내용 : ${ar }<br>
	ar[0] : ${ar[0] }<br>
	ar[1] : ${ar[1] }<br>
	ar[2] : ${ar[2] }<br>
	<br>
	<c:forEach var="i" items="${ar }">
		${i }<br>
	</c:forEach>
	<hr />
	<%
	HashSet<String> hashSet = new HashSet<>(Arrays.asList(new String[]{"한사람","두사람","세사람","네사람","오사람"}));
	pageContext.setAttribute("hashSet", hashSet);
	%>
	Set에 접근<br>
	hashSet의 내용 : ${hashSet }<br>
	<br>
	<c:forEach var="i" items="${hashSet }">
		${i }<br>
	</c:forEach>	
	<hr />
	<%
	List<String> list =	Arrays.asList(new String[]{"한사람","두사람","세사람","네사람","오사람"});
	pageContext.setAttribute("list", list);
	%>
	List에 접근<br>
	list의 내용 : ${list }<br>
	list[0] : ${list[0] }<br>
	list[2] : ${list[2] }<br>
	<br>
	<c:forEach var="i" items="${list }">
		${i }<br>
	</c:forEach>	
	<hr />
	<%
	Map<String, String> map = new HashMap<String,String>();
	map.put("a1010","한사람");
	map.put("a1011","두사람");
	map.put("a1012","세사람");
	map.put("a1013","네사람");
	pageContext.setAttribute("map", map);
	%>
	Map에 접근<br>
	map의 내용 : ${map }<br>
	map['a1010'] : ${map['a1010'] }<br>
	map['a1011'] : ${map['a1011'] }<br>
	map.a1012 : ${map.a1012 }<br>
	map.a1013 : ${map.a1013 }<br>
	<br>
	<c:forEach var="i" items="${map }">
		${i }<br>
	</c:forEach>	
	
</body>
</html>