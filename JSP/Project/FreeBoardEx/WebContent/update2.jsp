<%@page import="java.util.Map"%>
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
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
	
	});
</script>
</head>
<body>
<%-- 넘어온 인수 받기 1 --%>
<jsp:useBean id="cv" class="kr.green.board.vo.CommonVO"></jsp:useBean>
<jsp:setProperty property="*" name="cv"/>
${cv } <br />
현재 페이지 : ${cv.p } <br />
페이지 크기 : ${cv.s } <br />
블록의 크기 : ${cv.b } <br />
<!-- VO없이 맵으로 받아보자!!!! -->
<%
	Map<String,String[]> map = request.getParameterMap();
	request.setAttribute("map", map);
	/*
	if(map!=null){
		for(String key : map.keySet()){
			String[] values = map.get(key);
			out.println(key + " : ");
			if(values!=null){
				for(String value : values){
					out.println(value + " ");
				}
			}
			out.println("<br>");
		}
	}
	*/
%>
<hr />
현재 페이지 : ${map['p'][0] } <br />
페이지 크기 : ${map['s'][0] } <br />
블록의 크기 : ${map['b'][0] } <br />
<hr />	
현재 페이지 : ${map['p'] } <br />
페이지 크기 : ${map['s'] } <br />
블록의 크기 : ${map['b'] } <br />
</body>
</html>