<%@page import="kr.green.memo.service.MemoService"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    // POST 전송이 아니면 그냥 리스트로 보내버린다.
    if(!request.getMethod().equals("POST")){
    	response.sendRedirect("index.jsp");
    	return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- VO로 받아보자. --%>
    <jsp:useBean id="memo" class="kr.green.memo.vo.MemoVO"></jsp:useBean> <%-- MemoVO memo = new MemoVO()와 같다!!! --%>
    <jsp:setProperty property="*" name="memo"/> <%-- vo의 모든 setter를 호출하여 데이터를 넣어준다. --%>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        memo.setRegDate(sdf.format(new Date()));
    %>
    <jsp:setProperty property="ip" name="memo" value="<%=request.getRemoteAddr() %>"/> <%-- memo.setIp(request.getRemoteAddr()) 와 같다. --%>
    <%//=memo.toString() %>
    
    <%
        // 저장하고
        String path = application.getRealPath("/memo.json");
        List<MemoVO> list = MemoService.readMemo(path);      // 읽어서
        list.add(0, memo);                                     // 앞에 추가하고
        MemoService.saveMemo(path, list);                    // 다시 저장하고
        // 목록으로 간다.
        response.sendRedirect("index.jsp");
        
    %>

</body>
</html>