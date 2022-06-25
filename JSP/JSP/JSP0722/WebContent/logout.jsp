<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 로그아웃 처리를 하자
    String referer = request.getHeader("referer");  // 이전 주소를 알아낸다.
    // 로그아웃은 세션에 저장된 회원 정보를 삭제해주면 된다.
    session.removeAttribute("userid"); // 세션정보 삭제
    // 이전페이지로 간다.
    if(referer!=null){
    	response.sendRedirect(referer);
    }else{
    	response.sendRedirect("login.jsp");
    }

%>