<%@page import="kr.green.memo.service.MemoService"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    // DB에서 목록을 가져온다.
    List<MemoVO> list = MemoService.getInstance().selectList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1줄 메모장</title>
<style type="text/css">
table {
	width: 1000px;
	margin: auto;
}

th {
	border: 1px solid gray;
	padding: 5px;
	background-color: silver;
}

td {
	border: 1px solid gray;
	padding: 5px;
}

.title {
	font-size: 18pt;
	border: none;
	text-align: center;
}

.sub-title {
	border: none;
	text-align: right;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="5" class="title">허접한 1줄 메모장</td>
		<tr>
			<td colspan="5" style="border: none;">
				<%-- 글쓰기 폼을 달아보자!!! --%>
				<hr />
				<form action="insertOk.jsp" method="post">
					<input type="text" size="10" placeholder="이름입력" name="name"	id="name" required="required"> 
					<input type="password" size="10" placeholder="암호입력" name="password" id="password" required="required"> 
					<input type="text" size="80" placeholder="내용입력" name="content" id="content" required="required"> 
					<input type="submit" id="submitBtn"	value="저장">
				</form>
				<hr />
			</td>
		</tr>
		<tr>
			<td colspan="5" class="sub-title">전체 : <%=(list==null ? 0 : list.size()) %>개
			</td>
		</tr>
		<tr>
			<th width="5%">No</th>
			<th width="10%">작성자</th>
			<th>메모</th>
			<th width="15%">작성일</th>
			<th width="10%">IP</th>
		</tr>
		<%
		    if(list==null || list.size()==0){
		    	out.println("<tr><td colspan='5' style='text-align: center;'>등록된 글이 없습니다.</td></tr>");
		    }else{
		    	for(MemoVO vo : list){
		    		%>
		<tr align="center">
			<td><%=vo.getIdx() %></td>
			<td>
			<%
			//=vo.getName() 
			// 태그 무시!!!
			String name = vo.getName();
			name = name.replace("<", "&lt;");
			name = name.replace(">", "&gt;");
			out.println(name);
			%>
			</td>
			<td align="left">
			
			<%
			//=vo.getContent() 
			// 태그 무시!!! 
			String content = vo.getContent();
			content = content.replace("<", "&lt;");
			content = content.replace(">", "&gt;");
			out.println(content);
			%>
			</td>
			<td><%=(vo.getRegDate()+"").split(" ")[1] %></td>
			<td><%=vo.getIp() %></td>
		</tr>
		<%
		    		
		    	}
		    }
		%>
	</table>

</body>
</html>