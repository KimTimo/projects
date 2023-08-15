<%@page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Calendar calendar = Calendar.getInstance();
    int yy = calendar.get(Calendar.YEAR);
    int mm = calendar.get(Calendar.MONTH)+1;
    // 넘어온 년/월을 받는다.
    try{
    	yy = Integer.parseInt(request.getParameter("yy"));
    }catch(Exception e){
    	yy = calendar.get(Calendar.YEAR);
    }
    try{
    	mm = Integer.parseInt(request.getParameter("mm"));
    }catch(Exception e){
    	mm = calendar.get(Calendar.MONTH)+1;
    }
    // 넘어온 데이터 우효성을 검증한다.
    if(mm>=13){
    	mm = 1;
    	yy++;
    }
    if(mm<=0){
    	mm = 12;
    	yy--;
    }
    if(yy<=0){
    	yy = calendar.get(Calendar.YEAR);
    }
    // 1일의 요일과 그달의 마지막 날짜를 구한다.
    calendar.set(yy, mm-1, 1); // 날짜를 그달의 1일로 변경
    int week = calendar.get(Calendar.DAY_OF_WEEK)-1;  // 1~7을 리턴 : 0~6으로 변경하기 위하여 -1을 한다.
    int lastday = calendar.getActualMaximum(Calendar.DATE);
    //System.out.println(yy + ", " + mm + ", " + week + ", " + lastday);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java의 기능만을 이용한 달력 출력</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js' ></script>
<style type="text/css">
table {
	margin: auto;
}

th, td {
	padding: 5px;
	border: 1px solid gray;
}

.title {
	font-size: 22pt;
	font-weight: bold;
	text-align: center;
	border: none;
}

.move {
	border: none;
	text-align: center;
	font-weight: bold;
}

.blank_date{
    height: 50px;
    border-radius: 20px;
    background-color: silver; 
}
.sun_date{
    height: 50px;
    border-radius: 20px;
    background-color: pink; 
    color: red;
    font-size: 15pt;
}
.sat_date{
    height: 50px;
    border-radius: 20px;
    background-color: skyblue; 
    color: blue;
    font-size: 15pt;
}
.date{
    height: 50px;
    border-radius: 20px;
    background-color: white; 
    color: blank;
    font-size: 15pt;
}

a:link { text-decoration: none; color: black;}
a:visited { text-decoration: none; color: black;}
a:hover { text-decoration: none; color: blue;}
a:active { text-decoration: none; color: blue;}
</style>
</head>
<body>
	<table>
		<tr align="center">
			<td colspan="2" class="move">
			    <a href="?yy=<%=(yy-1)%>&mm=<%=mm%>" title="이전년도"><i class='fas fa-angle-double-left' style='font-size:24px'></i></a>
			    <a href="?yy=<%=yy%>&mm=<%=(mm-1)%>" title="이전월"><i class='fas fa-angle-left' style='font-size:24px'></i></a>
			</td>
			<td colspan="3"><%=String.format("%04d년 %02d월", yy, mm)%></td>
			<td colspan="2" class="move">
			    <a href="?yy=<%=yy%>&mm=<%=(mm+1)%>" title="다음월"><i class='fas fa-angle-right' style='font-size:24px'></i></a>
			    <a href="?yy=<%=(yy+1)%>&mm=<%=mm%>" title="다음년도"><i class='fas fa-angle-double-right' style='font-size:24px'></i></a>
			</td>
		</tr>
	<%-- table>tr/th[width="100px;"]*7 --%>
	<tr bgcolor="silver">
			<th width="100px;" style="background-color: pink;">일</th>
			<th width="100px;">월</th>
			<th width="100px;">화</th>
			<th width="100px;">수</th>
			<th width="100px;">목</th>
			<th width="100px;">금</th>
			<th width="100px;" style="background-color: skyblue;">토</th>
		</tr>
	<%-- 달력을 출력해보자!!! --%>
	<tr>
	<%-- 1일의 요일을 맞추기 위해 앞에 공백을 출력한다. --%>
	<%
	    for(int i = 0; i < week; i++){
	    	out.println("<td class='blank_date'>&nbsp;</td>");
	    }
	%>
	<%-- 1일부터 마지막 날짜까지 출력한다. 단, 토요일이면 줄바꿈한다. --%>
	<%
	    for(int i = 1; i <= lastday; i++){
	    	calendar.set(yy, mm-1, i);
	    	week = calendar.get(Calendar.DAY_OF_WEEK)-1; 
	    	if(week==0){
	    		out.println("<td class='sun_date' align='right' valign='bottom'>" + i + "</td>");
	    	}else if(week==6){  // 토요일이면
	    		out.println("<td class='sat_date' align='right' valign='bottom'>" + i + "</td>");
	    	    out.println("</tr>");
	    	    if(i!=lastday){  // 현재 날짜가 마지막 날짜가 아니면 더 출력할 날짜가 있으니까 새로운 줄을 시작
	    	    	out.println("<tr>");
	    	    }
	    	}else{
	    		out.println("<td class='date' align='right' valign='bottom'>" + i + "</td>");
	    	}
	    }
	%>
	<%-- 표의 뒷부분을 마무리 한다. --%>
	<%
	    for(int i = week+1; i < 7; i++){
	    	out.println("<td class='blank_date'>&nbsp;</td>");
	    }
	    if(week!=6) out.println("</tr>");
	%>
	</tr>


	</table>
</body>
</html>