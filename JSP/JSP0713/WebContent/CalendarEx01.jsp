<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	__2F_JSP0713_2F_WebContent_2F_CalendarEx01_2E_jsp cal = Calendar.getInstance();
	int yy = cal.get(Calendar.YEAR); 
	int mm = cal.get(Calendar.MONTH) + 1; 
	
	// 넘어온 값을 받아서 처리하자!!
	try{ // 최초 실행시 년도가 넘어오지 않거나 년도에 숫자가 아닌값이 있을때 예외처리
		yy = Integer.parseInt(request.getParameter("yy"));
	}catch(Exception e){
		yy = cal.get(Calendar.YEAR); 
	}
	try{
		mm = Integer.parseInt(request.getParameter("mm"));
	} catch(Exception e){
		mm = cal.get(Calendar.MONTH) + 1;
	}
	// 값의 유효성을 검사해 줘야 한다.
	if(mm<=0){
		yy--;
		mm=12;
	}
	if(mm>=13){
		yy++;
		mm=1;
	}
	if(yy<=0){
		yy = cal.get(Calendar.YEAR);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력을 만들어 보자!!!</title>
<style type="text/css">
	table {
		margin: auto;padding: 5px;
	}
	th, td {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<!-- 
	 table>tr>th[width="100px"]*7
	 -->
	 	 <table border="0">
	 	 	<tr>
	 	 		<th colspan="2" style="border: none;">
	 	 			<a href="?yy=<%=yy-1 %>&mm=<%=mm %>" title="이전년도">◀</a>
	 	 			<a href="?yy=<%=yy %>&mm=<%=mm-1 %>" title="이전월">◁</a>
	 	 		</th>
	 	 		<th colspan="3"  style="border: none;">
	 	 			<span style="font-size: 18pt;"><%=yy %>년 <%=mm %>월</span>
	 	 		</th>
	 	 		<th colspan="2"  style="border: none;">
	 	 			<a href="?yy=<%=yy %>&mm=<%=mm+1 %>" title="다음월">▷</a>
	 	 			<a href="?yy=<%=yy+1 %>&mm=<%=mm %>" title="다음년도">▶</a>
	 	 		</th>
	 	 	</tr>
	 	 	<tr>
	 	 		<th width="100px">일</th>
	 	 		<th width="100px">월</th>
	 	 		<th width="100px">화</th>
	 	 		<th width="100px">수</th>
	 	 		<th width="100px">목</th>
	 	 		<th width="100px">금</th>
	 	 		<th width="100px">토</th>
	 	 	</tr>
	 	 </table>
</body>
</html>