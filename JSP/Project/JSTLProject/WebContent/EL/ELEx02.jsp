<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int sum = 0;
	for (int i = 1; i <= 100; i++)
		sum += i;
	// 추가적으로 4개의 영역 중에 저장을 해놓으면 EL로 간단하게 출력이 가능하다.
	request.setAttribute("sum", sum);
	
	pageContext.forward("Ex02View.jsp");
%>
