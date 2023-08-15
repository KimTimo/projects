<%@page import="kr.green.poll.service.PollUtil"%>
<%@page import="kr.green.poll.vo.PollVO"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    // 서버의 실제 경로를 구한다.
    String fileName = application.getRealPath("./poll.json");
    out.println(fileName + "<br>");
    // 읽기
    PollVO vo = PollUtil.readPollVO(fileName);
    out.println(vo + "<br>");
    // 저장 
    fileName = application.getRealPath("./poll2.json");
    out.println(fileName + "<br>");
    PollUtil.savePollVO(vo, fileName);

%>

</body>
</html>