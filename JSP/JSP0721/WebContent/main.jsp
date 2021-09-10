<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String viewPage = request.getParameter("mem");
    if(viewPage==null) viewPage = "guest";
    switch(viewPage){
    case "admin" :
    	request.setAttribute("user", "최고관리자");
    	break;
    case "member" :
    	request.setAttribute("user", "나회원");
    	break;	
    default:
    	viewPage = "guest";
    	request.setAttribute("user", "손님");
    }
    viewPage += ".jsp";
    // forward 하는 3가지 방법
    // 1. jsp : forward 태그 사용        ==> 태그들 사이에서
    // 2. pageContext.forward 함수 사용
    // pageContext.forward(viewPage);    ==> jsp코드 사이에서
    // 3. request를 이용한 forward       ==> Servlet 에서 사용
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    dispatcher.forward(request, response);
%>