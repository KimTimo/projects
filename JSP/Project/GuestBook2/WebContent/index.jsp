<%@page import="kr.green.guestbook.service.GuestBookServiceImpl"%>
<%@page import="kr.green.guestbook.service.GuestBookService"%>
<%@page import="kr.green.guestbook.vo.GuestBookVO"%>
<%@page import="kr.green.guestbook.vo.PagingVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록보기</title>
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
	<%-- 글목록을 읽어오자!!! --%>
	<%
		PagingVO<GuestBookVO> pv = GuestBookServiceImpl.getInstance().selectList(cv.getCurrentPage(), cv.getPageSize(), cv.getBlockSize());
	%>
	<div id="content">
		<div class="title">방명록 목록보기</div>
		<div class="count"><%=pv.getPageInfo() %></div>
		<%
			if(pv.getTotalCount()>0){
				for(GuestBookVO vo : pv.getList()){ 	
		%>
				<div class="item">
					<div class="item_title">
					<%
						String title = vo.getName();
						title = title.replaceAll("<", "&lt;");
						title = title.replaceAll(">", "&gt;");
						title += "님이 " + vo.getIp() + "에서 " + vo.getRegDate() + "에 남길글";
						out.println(title);
					%>
						<%-- 수정/ 삭제 버튼을 달아준다. --%>
						<button type="button" class="btn btn-outline-success btn-sm" 
						        onclick='SendPost("update.jsp",{"p":<%=pv.getCurrentPage() %>,"s":<%=pv.getPageSize() %>,"b":<%=pv.getBlockSize() %>,"idx":<%=vo.getIdx() %>,"m":"update"},"post")'>수정</button>
						<button type="button" class="btn btn-outline-success btn-sm" 
						        onclick='SendPost("update.jsp",{"p":<%=pv.getCurrentPage() %>,"s":<%=pv.getPageSize() %>,"b":<%=pv.getBlockSize() %>,"idx":<%=vo.getIdx() %>,"m":"delete"},"post")'>삭제</button>
						
					</div>
					<%
					String content = vo.getContent();
					content = content.replaceAll("<", "&lt;");
					content = content.replaceAll(">", "&gt;");
					content = content.replaceAll("\n", "<br>");
					out.println(content);
					%>
				</div>
		<% 
				} 
		%>
			<div>
				<%=pv.getPageList() %>
			</div>
		<%
			}else{
		%>
				<div class="no_item">등록된 글이 없습니다.</div>		
		<%  } %>
		<%-- 글쓰기 버튼을 출력하자 :   sendPost('hanjaList.jsp',{"p":1,"s":10,"b":10},"post"); --%>
		<div class="count">
			<button type="button" class="btn btn-outline-success btn-sm" 
			        onclick='SendPost("update.jsp",{"p":<%=pv.getCurrentPage() %>,"s":<%=pv.getPageSize() %>,"b":<%=pv.getBlockSize() %>,"m":"insert"},"post")'>글쓰기</button>
		</div>
	</div>
</body>
</html>