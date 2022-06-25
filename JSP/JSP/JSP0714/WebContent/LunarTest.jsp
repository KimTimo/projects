<%@page import="kr.green.cal.LunarUtil"%>
<%@page import="kr.green.cal.DateVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Calendar calendar = Calendar.getInstance();
int yy = calendar.get(Calendar.YEAR);
int mm = calendar.get(Calendar.MONTH)+1;

//넘어온 년/월을 받는다.
try{
	yy = Integer.parseInt(request.getParameter("yy"));
}catch(Exception e){
	yy = calendar.get(Calendar.YEAR); // 숫자로 변경 못하면 현재 년도를 가져라!!
}
try{
	mm = Integer.parseInt(request.getParameter("mm"));
}catch(Exception e){
	mm = calendar.get(Calendar.MONTH)+1; // 숫자로 변경 못하면 현재 월을 가져라!!
}
// https://astro.kasi.re.kr/life/pageView/5에서 음력데이터를 읽어보자!!!!
List<DateVO> list = LunarUtil.readLunarDate(yy, mm);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음력 달력 보기</title>
</head>
<body>
	<%
		for(DateVO vo : list){
			out.println(vo.getSolar() + " : " + vo.getLunar() + " : " + vo.getGangi() + "<br>");
		}
	%>
	<hr />
	1일의 양력 년도 : <%=list.get(0).getSolarYear() %>년 <br />
	1일의 양력 월 : <%=list.get(0).getSolarMonth() %>월 <br />
	1일의 양력 일 : <%=list.get(0).getSolarDate() %>일 <br />
	1일의 양력 요일 문자 : <%=list.get(0).getSolarDayOfWeekStr() %>요일 <br />
	1일의 양력 요일 숫자 : <%=list.get(0).getSolarDayOfWeekInt() %>요일 <br />
	<hr />
	1일의 음력 년도 : <%=list.get(0).getLunarYear() %>년 <br />
	1일의 음력 월 : <%=list.get(0).getLunarMonth() %>월 <br />
	1일의 음력 일 : <%=list.get(0).getLunarDate() %>일 <br />	
	<hr />
	
	1일의 세차 : <%=list.get(0).getGangiYearKor() %><br />	
	1일의 세차 : <%=list.get(0).getGangiYearHanja() %><br />	
	
	1일의 월건 : <%=list.get(0).getGangiMonthKor() %><br />	
	1일의 월건 : <%=list.get(0).getGangiMonthHanja() %><br />	
	
	1일의 일진 : <%=list.get(0).getGangiDateKor() %><br />	
	1일의 일진 : <%=list.get(0).getGangiDateHanja() %><br />	
	
	
	
	
</body>
</html>