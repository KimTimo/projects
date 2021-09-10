<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 파일이름을 받자!!!!
	String file = request.getParameter("file");
	if(file==null || file.trim().length()==0){ // 파일이름이 없다면 기본값으로 poll가지자!!!
		file = "poll";
	}

	// 폼을 완성하기 위하여 json 파일을 읽어서 VO로 가져오자
	PollVO vo = PollUtil.readPollVO(application.getRealPath("/" + file.trim() + ".json"));
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
	<form action="pollOk2.jsp" method="post">
	<%--파일이름을 숨겨서 보내자!!! --%>
	<input type="hidden" name="file" value="<%=file.trim() %>" />
	<table>
		<tr>
			<th class="title">
				온라인 투표하기 Ver 0.9
			</th>
		</tr>
		<tr>
			<td style="font-weight: bold;">제목 : <%=vo.getTitle() %></td>
		</tr>
		<% for(int i=0;i<vo.getItem().length;i++){ %>
		<tr>
			<td>
				<label>
				<input type="radio" name="item" value="<%=i%>" <%=((i==0) ? " checked='checked'" : "") %>>
				<%=vo.getItem()[i] %>
				</label>
			</td>
		</tr>		
		<%  } %>
		<tr>
			<td align="center">
				<input type="submit" value="투표하기">
				<input type="button" onclick="location.href='pollResult.jsp?file=<%=file.trim() %>'" value="결과보기"/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>