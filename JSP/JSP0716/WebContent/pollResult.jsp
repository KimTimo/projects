<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	//-------------------------------------------------------------------
	// 투표 번호를 받자!!!!
	int idx = 0;
	try{
		idx = Integer.parseInt(request.getParameter("idx"));
	}catch(Exception e){
		;
	}
	//-------------------------------------------------------------------

	// 폼을 완성하기 위하여 json 파일을 읽어서 VO로 가져오자
	PollVO vo = PollUtil.readPollVO(application.getRealPath("/poll.json")).get(idx); // ===> 이 부분 수정
	String colors[] = "black,pink,orange,skyblue,red,green,blue".split(",");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 투표하기</title>
<style type="text/css">
	table { margin: auto; border: 1px solid gray; padding: 5px;width: 400px;}
	.title{color: white;background-color: black; font-size: 13pt;padding: 5px;}
	td {padding: 5px;}
</style>
</head>
<body>
	<table>
		<tr>
			<th class="title">
				온라인 투표하기 Ver 0.9 -- 결과
			</th>
		</tr>
		<tr>
			<td align="right"> 총투표수 : <%=vo.getTotal() %>표</td>
		</tr>
		<tr>
			<td style="font-weight: bold;">제목 : <%=vo.getTitle() %></td>
		</tr>
		<% for(int i=0;i<vo.getItem().size();i++){ %>
		<tr>
			<td>
				<%=(i+1) + ". " + vo.getItem().get(i) %> 
				<span style="font-size: 11pt;font-weight: bold; color: blue;">
				(<%=vo.getResult().get(i) %>표, <%=vo.getPercent(i) %>)
				</span>
				<br />
				<%-- 그래프를 선으로 그려보자!!! --%>
				<hr align="left" size="20" width="<%=vo.getPercent(i) %>" color="<%=colors[i%colors.length]%>"/>
			</td>
		</tr>		
		<%  } %>
		<tr>
			<td align="center">
				<input type="button" onclick="location.href='poll.jsp?idx=<%=idx %>'" value="돌아가기"/> <%-- // ===> 이 부분 수정 --%>
			</td>
		</tr>
	</table>
</body>
</html>