<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>형식에 맞추어 출력하기</title>
</head>
<body>
	<jsp:useBean id="today" class="java.util.Date" scope="request"/>
	
	날짜  : ${today } <br />
	날짜  : <fmt:formatDate value="${today }"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="date"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="time"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="both"/>  <br />
	
	날짜  : <fmt:formatDate value="${today }" type="date" dateStyle="full"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="date" dateStyle="long"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="date" dateStyle="medium"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="date" dateStyle="short"/>  <br />
	
	날짜  : <fmt:formatDate value="${today }" type="time" timeStyle="full"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="time" timeStyle="long"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="time" timeStyle="medium"/>  <br />
	날짜  : <fmt:formatDate value="${today }" type="time" timeStyle="short"/>  <br />
	
	날짜  : <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/>  <br />
	
	날짜  : <fmt:formatDate value="${today }" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초(E)"/>  <br />
</body>
</html>