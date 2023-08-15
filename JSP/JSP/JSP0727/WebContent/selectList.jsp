<%@page import="kr.green.jdbc.service.SampleServiceImpl"%>
<%@page import="kr.green.jdbc.vo.SampleVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>
<%
List<SampleVO> list = SampleServiceImpl.getInstance().selectList(currentPage,pageSize,blockSize);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<style type="text/css">
	table { width: 700px; margin: auto; padding: 10px; border: none;}
	th { padding: 5px; border: 1px solid gray; background-color: silver;}
	td { padding: 5px; border: 1px solid gray; background-color: white;}
	.title { text-align: center; font-size: 18pt; border: none;}
	.sub-title { text-align: right; font-size: 10pt; border: none;}
	.sub-title2 { text-align: center; font-size: 10pt; border: 1px solid gray;}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="5" class="title"> 목록 보기</td>
		</tr>
		<tr>
			<td colspan="5" class="sub-title"> 전체 : <%=list.size() %>개</td>
		</tr>
		<tr>
			<th>idx</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>Edit/Delete</th>
		</tr>
		<% if(list.size()>0){ %>
		<% 		for(SampleVO vo : list ){ %>
			<tr align="center">
				<td><%=vo.getIdx() %></td>
				<td><%=vo.getName() %></td>
				<td><%=vo.getAge() %></td>
				<td><%=vo.getGender().equals("M") ? "남":"여" %></td>
				<td>
				[<a href="updateForm.jsp?idx=<%=vo.getIdx()%>&m=u">Edit</a>]
				[<a href="updateForm.jsp?idx=<%=vo.getIdx()%>&m=d">Del</a>]
				</td>
			</tr>
		<% 		} 
		   }else {
		%>
		<tr>
			<td colspan="5" class="sub-title2">데이터가 없습니다.</td>
		</tr>
		<% } %>
		<tr>
			<td colspan="5" class="sub-title">
			[<a href="updateForm.jsp?m=i">글쓰기</a>]
			</td>
		</tr>
	</table>
</body>
</html>