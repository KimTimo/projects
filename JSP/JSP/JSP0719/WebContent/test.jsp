<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="kr.green.memo.service.MemoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>읽고 저장되는지 </title>
</head>
<body>
    <%
        String path = application.getRealPath("/memo.json");
        out.println("절대 경로 : " + path + "<br>");
        List<MemoVO> list = MemoService.readMemo(path);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        MemoVO vo = new MemoVO();
        vo.setName("지나가유");
        vo.setPassword("123456");
        vo.setContent("이게 왜 진짜야?");
        vo.setRegDate(sdf.format(new Date()));
        vo.setIp(request.getRemoteAddr());
        
        list.add(0, vo);
        MemoService.saveMemo(path, list);
        out.println("저장완료!!");
        
        list = MemoService.readMemo(path);
        out.println("읽기완료 : " + list + "<br>");
    %>

</body>
</html>