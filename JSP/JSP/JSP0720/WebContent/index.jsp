<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //response.sendRedirect(request.getContextPath() + "/WEB-INF/getHeader.jsp"); // 이건 실행되지 않는다.
    // WEB-INF 폴더는 직접 URL로 접근할 수 없다.
    
    // forward : 실행을 옮겨준다.
    pageContext.forward("WEB-INF/getHeader.jsp");
%>