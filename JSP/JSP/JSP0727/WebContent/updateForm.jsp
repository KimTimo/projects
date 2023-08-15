<%@page import="kr.green.jdbc.service.SampleServiceImpl"%>
<%@page import="kr.green.jdbc.vo.SampleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 넘어온 데이터 받기 --%>
<%@ include file="include.jsp" %>
<%
	// 해당 글번호의 글을 가져온다.
	SampleVO vo = SampleServiceImpl.getInstance().selectByIdx(idx);
	// 가져온 글이 null이라는것은 해당 글번호의 글이 없다. 글쓰기 일 수 있다.
	if(vo==null){
		vo = new SampleVO();
		vo.setIdx(0);
		vo.setName("");
		vo.setAge(0);
		vo.setGender("M");
	}
	String title = (mode.equals("i") ? "저장" : mode.equals("u") ? "수정" : "삭제");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title %>하기 폼</title>
</head>
<body>
	<form action="updateOk.jsp" method="post">
		<input type="hidden" name="idx" value="<%=vo.getIdx()%>">
		<input type="hidden" name="m" value="<%=mode%>">
		이름 : <input type="text" name="name" required="required" value='<%=vo.getName() %>'> <br />
		나이 : <input type="number" name="age" required="required" value='<%=vo.getAge() %>'> <br />
		성별 : 
		<label><input type="radio" name="gender" <%=(vo.getGender().equals("M")? " checked='checked' ":"")%> value="M">남자</label> 
		<label><input type="radio" name="gender" <%=(vo.getGender().equals("F")? " checked='checked' ":"")%> value="F">여자</label>
		<br />
		<input type="submit" value="<%=title %>하기" /> 
		<input type="button" value="목록으로" onclick="location.href='selectList.jsp'" /> 
	</form>
</body>
</html>