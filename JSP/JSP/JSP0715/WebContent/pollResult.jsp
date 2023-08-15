<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//이 부분 추가
// 파일이름 받기
String file = request.getParameter("file");
if(file==null || file.trim().length()==0){ // 파일 이름이 없다면 기본값으로 poll을 가지자.
file = "poll";
}
//--------------------------------------------------------------------------

// 폼을 완성하기 위하여 json 파일을 읽어서 VO로 가져오자 
PollVO vo = PollUtil.readPollVO(application.getRealPath("/" + file.trim() +".json"));       // ====> 수정
String colors[] = "red,green,blue,black,pink,orange,blue".split(",");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 투표하기</title>
<style type="text/css">
table {
	margin: auto;
	border: 1px solid gray;
	padding: 5px;
	width: 450px;
}

.title {
	color: white;
	background-color: black;
	font-size: 13pt;
	padding: 5px;
}

td {
	padding: 5px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th class="title">온라인 투표하기</th>
		</tr>
		<tr>
			<td align="right">총투표수 : <%=vo.getTotal() %>표
			</td>
		</tr>
		<tr>
			<td colspan="2" style="font-weight: bold; ">제목 : <%=vo.getTitle()%></td>
		</tr>
		<%
			for (int i = 0; i < vo.getItem().length; i++) {
			%>
		<tr>
			<td>
			<span style="font-size: 11pt; font-weight: bold; color: blue;">
			(<%=vo.getResult()[i] %>표, <%=vo.getPercent(i) %>)
			</span>
			<br />
			<hr align="left" size="20" width="<%=vo.getPercent(i) %>" color="<%=colors[i%colors.length]%>"/>
			</td>
		</tr>
		<% } %>
		<tr>
		<td align="center">
		 <input	type="button" onclick="location.href='poll.jsp?file<%=file.trim() %>'" value="돌아가기" />     <%-- // ====> 수정 --%>
			</td>
		</tr>

	</table>

</body>
</html>