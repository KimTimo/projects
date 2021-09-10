<%-- %@로 시작 되면 디렉티브라고 한다. 페이지에 대한 설정 정보를 기술한다. --%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.green.util.DateUtil"%>
<%@ page contentType="text/palin; charset=UTF-8"pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫번째 예제</title>
<%--%!로 시작되면 선언문임을 나타낸다. --%>
<%!public String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		Date today = new Date();
		return sdf.format(today);
	}%>
</head>
<body>
	<%--%로 시작하면 일반 자바코드들을 적고 스트림트릿 이라고 한다. --%>
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
	Date today = new Date();
	%>
	<%-- %=로 시작하면 표현식이라고 하면 출력을 담담항다. --%>
	현재 시간 :
	<%=sdf.format(today)%><br> 현재 시간 :
	<%=getToday()%>
	<br> 현재 시간  :
	<%=DateUtil.getToday()%>
	<br>
</body>
</html>