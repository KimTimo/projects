<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼의 확인</title>
</head>
<body>
    <%
        out.println(out.getBufferSize() + "Byte<br>"); // 버퍼의 크기
        out.println(out.getRemaining() + "Byte<br>"); // 버퍼의 크기
    %>
    움하하하움하하하움하하하움하하하 움하하하움하하하
    움하하하움하하하움하하하움하하하 움하하하움하하하
    움하하하움하하하움하하하움하하하 움하하하움하하하
    <br />
    <%
        
    %>

</body>
</html>