<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 로그아웃을 처리하자!!!!
	session.removeAttribute("userid");  // 세션에 저장되어 있는 변수를 지운다.
	response.sendRedirect("login.jsp"); // 메인페이지 또는 로그인 페이지로 이동한다. 
%>