<%@ page import="java.util.Date"%>
<%@ page import="kr.green.el.DateUtil"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="myfn" uri="/WEB-INF/tlds/functions.tld" %>
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
	<h1>사용자가 만든 정적 메서드 호출 : 표현식 사용</h1>
	날짜 : <%=DateUtil.getDate(new Date()) %> <br />
	시간 : <%=DateUtil.getTime(new Date()) %> <br />
	<h1>사용자가 만든 정적 메서드 호출 : EL사용</h1>
	<jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
	날짜 : ${myfn:date(today) } <br />
	시간 : ${myfn:time(today) } <br />
	난수1 : ${myfn:random() } <br />
	난수2 : ${myfn:random() } <br />
	난수3 : ${myfn:random() } <br />
	4의 제곱근 : ${myfn:sqrt(4.0) } <br />
	5의 제곱근 : ${myfn:sqrt(5.0) } <br />
</body>
</html>