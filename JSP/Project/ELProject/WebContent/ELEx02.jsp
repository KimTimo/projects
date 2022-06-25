<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// EL로 출력하기 위해서는 반드시 page, request, session, application 객체에 저장이 되어 있어야만 출력이 가능
	int var = 123;
	pageContext.setAttribute("var", 111);
	request.setAttribute("var", 222);
	session.setAttribute("var", 333);
	application.setAttribute("var", 444);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	var 변수의 값 : <%=var %> <br />
	pageContext var 변수의 값 : <%=pageContext.getAttribute("var") %> <br />
	request var 변수의 값 : <%=request.getAttribute("var") %> <br />
	session var 변수의 값 : <%=session.getAttribute("var") %> <br />
	application 변수의 값 : <%=application.getAttribute("var") %> <br />
	<hr />
	var 변수의 값 : ${var } <br /> <%-- 영역의 이름을 생략하면 제일 작은 영역의 값이 출력된다.  EL로는 일반 변수는 출력되지 않는다.--%>
	pageContext var 변수의 값 : ${pageScope.var } <br />
	request var 변수의 값 : ${requestScope.var } <br />
	session var 변수의 값 : ${sessionScope.var } <br />
	application 변수의 값 : ${applicationScope.var } <br />
	
</body>
</html>