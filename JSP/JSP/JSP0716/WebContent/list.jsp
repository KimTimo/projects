<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String fileName = application.getRealPath("/poll.json");
	List<PollVO> list = PollUtil.readPollVO(fileName);
	// System.out.println(list);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String today = sdf.format(new Date());
	System.out.println(today);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 목록보기</title>
<style type="text/css">
	table { width: 700px; margin: auto; border: none; }
	.title { border: none; text-align: center; font-size: 18pt; }
	th { border: 1px solid gray; background-color: silver; padding: 5px;}
	td { border: 1px solid gray; padding: 5px;}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="4" class="title">설문조사 프로그램 Ver 0.9</td>
		</tr>
		<tr>
			<td colspan="4" style="border: none;" align="right">
				설문개수 : <%=list.size() %>개
				<button onclick="location.href='pollForm.jsp'">설문등록하기</button>
			</td>
		</tr>
		<tr>
			<th width="5%">No</th>
			<th>투표제목</th>
			<th width="20%">기간</th>
			<th width="15%">결과보기</th>
		</tr>
		<%  
		for(int i=0;i<list.size();i++){ 
			PollVO vo = list.get(list.size()-i-1);
		%>
			<tr align="center">
				<td><%=(list.size()-i) %></td>
				<td align="left">
					<% if(today.compareTo(vo.getStart())>=0 && today.compareTo(vo.getEnd())<=0) { %>
						<a href="poll.jsp?idx=<%=(list.size()-i-1)%>"><%=vo.getTitle() %></a>
					 <% }else{ %>
					 	<%=vo.getTitle() %>
					 <% } %>
				</td>
				<td style="font-size: 9pt;">
					<%=vo.getStart() %>~<%=vo.getEnd() %>
				</td>
				<td>
					<button onclick="location.href='pollResult.jsp?idx=<%=(list.size()-i-1)%>'">결과보기</button>
				</td>
			</tr>
		<% } %>
	</table>
</body>
</html>