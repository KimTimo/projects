<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// EL로 출력하기 위해서는 반드시 page, request, session, application 객체에 저장이 되어 있어야만 출력이 가능
	int sum = 0;
	for(int i=1;i<=100;i++) sum += i;
	request.setAttribute("sum", sum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1 ~ 100 까의 합 : <%=sum %> <br />
	1 ~ 100 까의 합 : ${sum } <br />
	<%
		// 아래 두줄과 같은 역할을 하는 태그가 jsp:useBean이다.
		// Date today = new Date();
		// pageContext.setAttribute("today", today);
	%>
	
	<jsp:useBean id="today" class="java.util.Date" scope="page"></jsp:useBean>
	현재 날짜 : <%=today %> <br />
	현재 날짜 : ${today } <br />
	<hr />
	현재 날짜 : <%=today.getYear()+1900 %>년 <%=today.getMonth()+1 %>월 
	            <%=today.getDate() %>일 <%=today.getHours() %>시 <%=today.getMinutes() %>분  <br />
	<%-- EL은 Getter메서드를 호출해준다. get을 지우고 첫글자를 소문자로 바꿔서 써준다. --%>            
	현재 날짜 : ${today.year+1900 }년 ${today.month+1 }월 
	            ${today.date }일 ${today.hours }시 ${today.minutes }분  <br />
	
</body>
</html>