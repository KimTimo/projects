<%@page import="kr.green.guestbook.service.GuestBookServiceImpl"%>
<%@page import="kr.green.guestbook.service.GuestBookService"%>
<%@page import="kr.green.guestbook.vo.GuestBookVO"%>
<%@ page import="kr.green.guestbook.vo.PagingVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//POST전송인지 검사
	if(!request.getMethod().equals("POST")){
		response.sendRedirect("index.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 저장/수정/삭제</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/commons.js"></script>
</head>
<body>
	<%-- currentPage, pageSize, blockSize를 받자!! --%>
	<jsp:useBean id="cv" class="kr.green.guestbook.vo.CommonVO"></jsp:useBean>
	<jsp:setProperty property="*" name="cv"/>
	<%-- VO를 받자 --%>
	<jsp:useBean id="vo" class="kr.green.guestbook.vo.GuestBookVO"></jsp:useBean>
	<jsp:setProperty property="*" name="vo"/>
	<%-- IP는 수동으로 넣어주자--%>
	<jsp:setProperty property="ip" name="vo" value="<%=request.getRemoteAddr() %>"/>
	<%
		
		// mode 값에따라 알맞은 서비스를 호출해주면 된다.
		switch(cv.getMode()){
		case "insert":
			GuestBookServiceImpl.getInstance().insert(vo);
			cv.setP(1);
			break;
		case "update":
			GuestBookServiceImpl.getInstance().update(vo);
			break;
		case "delete":
			GuestBookServiceImpl.getInstance().delete(vo);
			break;
		}
	%>
	<script>
		SendPost("index.jsp", {"p":"<%=cv.getCurrentPage()%>","s":"<%=cv.getPageSize()%>","b":"<%=cv.getBlockSize()%>"},"post");
	</script>
</body>
</html>