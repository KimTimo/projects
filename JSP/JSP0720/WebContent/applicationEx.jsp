<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화 파라미터 읽기</title>
</head>
<body>
    <h2>web.xml에 저장된 변수값을 읽어보자</h2>
    <%
        String db = application.getInitParameter("DBMS");
        String user = application.getInitParameter("DBUSER");
        String password = application.getInitParameter("DBPWD");
    %>
    DBMS 이름 : <%=db %> <br />
    DBMS 사용자 아이디 : <%=user %> <br />
    DBMS 사용자 비번 : <%=password %> <br />
    <hr/>
    
    <%
        Enumeration<String> names = application.getInitParameterNames();
        while(names.hasMoreElements()){
        	String name = names.nextElement();
        	String value = application.getInitParameter(name);
        	out.println(name + " : " + value + "<br>");
        }
    %>
    <hr/>
    서버의 실제 경로 : <%=application.getRealPath("/") %><br />
    서버의 실제 경로 : <%=application.getRealPath("\\") %><br />
    서버의 실제 경로 : <%=application.getRealPath(File.separator) %><br />
    <hr/>
    <h2>json폴더의 존재 여부 확인해서 없으면 만들어주기</h2>
    
    <%
        String path = application.getRealPath("/json");  // 경로 얻기
        File file = new File(path);                      // 파일객체 생성
        if(!file.exists()){                              // 있는지 확인
        	out.println("없다.<br>");
        	file.mkdir();                                // 없으면 폴더 생성
        }else{
        	out.println("있다.<br>");
        }
    %>

</body>
</html>