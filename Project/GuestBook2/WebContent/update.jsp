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
<script>
	$(function(){
		
	});
</script>
<style type="text/css">
	div#content {width: 90%; margin: auto;}
	div.title {font-size: 18pt; text-align: center;}
	div.count {font-size: 10pt; text-align: right;}
	div.no_item {font-size: 10pt; text-align: center; border: 1px solid gray; padding:5px;margin-bottom: 5px; }
	div.item {font-size: 10pt; border: 1px solid gray; padding:5px;margin-bottom: 5px; }
	div.item_title {font-size: 11pt; font-weight: bolder; border: 1px solid gray; padding:5px;margin-bottom: 5px; background-color: silver; }
</style>
</head>
<body>
	<%-- currentPage, pageSize, blockSize를 받자!! --%>
	<jsp:useBean id="cv" class="kr.green.guestbook.vo.CommonVO"></jsp:useBean>
	<jsp:setProperty property="*" name="cv"/>
	<%
		// mode 값에따라 글을 읽어오거나 아니면 초기화 해 주면된다.
		String title = "";
		GuestBookVO vo = null;
		switch(cv.getMode()){
		case "insert":
			title = "저장하기";
			vo = new GuestBookVO();
			vo.setIdx(0);
			vo.setName("");
			vo.setPassword("");
			vo.setContent("");
			break;
		case "update":
			title = "수정하기";
			vo = GuestBookServiceImpl.getInstance().selectByIdx(cv.getIdx());
			break;
		case "delete":
			title = "삭제하기";
			vo = GuestBookServiceImpl.getInstance().selectByIdx(cv.getIdx());
			break;
		default:
			response.sendRedirect("index.jsp");
			return;
		}
	%>
	<div id="content">
		<div class="title">방명록 <%=title %></div>		
		<%-- 글쓰기/수정/삭제 폼이 있어야 한다. --%>
		<div class="item">
			<form action="updateOk.jsp" method="post">
				 <%-- 숨겨서 몇개를 넘기자!! --%>
				 <input type="hidden" name="p" value="<%=cv.getCurrentPage()%>">
				 <input type="hidden" name="s" value="<%=cv.getPageSize()%>">
				 <input type="hidden" name="b" value="<%=cv.getBlockSize()%>">
				 <input type="hidden" name="idx" value="<%=cv.getIdx()%>">
				 <input type="hidden" name="m" value="<%=cv.getMode()%>">
				 
				 이름  : <input type="text" id="name" name="name" value="<%=vo.getName()%>" size="15" required="required">
				 비밀번호  : <input type="password" id="password" name="password"  size="15" required="required">
				 <br />
				 내용 : 
				 <textarea name="content" id="content" cols="70" rows="10"><%=vo.getContent() %></textarea>
				 <br />
				 <input type="submit" value="<%=title%>" class="btn btn-outline-success btn-sm"/>
				 <input type="button" value="취소하기" class="btn btn-outline-success btn-sm" 
				        onclick='SendPost("index.jsp",{"p":<%=cv.getCurrentPage() %>,"s":<%=cv.getPageSize() %>,"b":<%=cv.getBlockSize() %>},"post")'/>
			</form>
		</div>  
	</div>
</body>
</html>