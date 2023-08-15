<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 정보 받기</title>
</head>
<body>
    <%
        // 만약에 name 속성의 값을 모른다면 request.getParameter(), request.getParameterValues()를 사용 못한다.
        // 이때 이름만 받는 메소드가 존재한다. request.getParameterNames() 이다.
        // 한번에 몽땅 받아보기
        
        Enumeration<String> names = request.getParameterNames(); // 이름을 열거형으로 모두 받는다.
        
        while(names.hasMoreElements()){
        	// 이름을 알아냈다. 이제 값을 알아볼 시간.
        	String name = names.nextElement();
        	String[] values = request.getParameterValues(name); // 배열로 받는다. 동명이인이 있을수도 있어서.
        	
        	out.println(name + " : ");
        	if (values != null && values.length > 0) {
        		for (String value : values) {
        			out.print(value + " ");
        		}
        	}else{
        		out.println("없음");
        	}
        	
        	out.println("<br>");
        }
    %>
</body>
</html>