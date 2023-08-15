<%@page import="kr.green.memo.vo.PagingVO"%>
<%@page import="kr.green.memo.service.MemoService"%>
<%@page import="kr.green.memo.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1줄 메모장</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});
	
	function editForm(idx){
		// 폼의 값을 채워주고
		$("#idx").val($("#idx"+idx).html());
		$("#name").val($("#name"+idx).html());
		$("#content").val($("#content"+idx).html());

		// 폼의 액션 속성을 변경
		// $("#updateForm").attr('action','updateOk.jsp');
		
		// mode 값을 "update"로 변경한다.
		$("#mode").val("update")
		// 버튼의 제목을 "수정하기"로 변경
		$("#submitBtn").val("수정하기")
		// 취소 버튼을 보이게 한다.
		$("#cancelBtn").css('display','inline');
	}
	function deleteForm(idx){
		// 폼의 값을 채워주고
		$("#idx").val($("#idx"+idx).html());
		$("#name").val($("#name"+idx).html());
		$("#content").val($("#content"+idx).html());
		
		// 폼의 액션 속성을 변경
		// $("#updateForm").attr('action','deleteOk.jsp');
		// mode 값을 "delete"로 변경한다.
		$("#mode").val("delete")
		
		// 버튼의 제목을 "삭제하기"로 변경
		$("#submitBtn").val("삭제하기")
		// 취소 버튼을 보이게 한다.
		$("#cancelBtn").css('display','inline');
	}
	function resetForm(){
		// 폼의 값을 비워주고
		$("#idx").val(0);
		$("#name").val("");
		$("#content").val("");
		
		// 폼의 액션 속성을 변경
		// $("#updateForm").attr('action','insertOk.jsp');
		// mode 값을 "insert"로 변경한다.
		$("#mode").val("insert")
		
		// 버튼의 제목을 "저장하기"로 변경
		$("#submitBtn").val("저장하기")
		// 취소 버튼을 숨긴다.
		$("#cancelBtn").css('display','none');
	}
</script>
<style type="text/css">
	table {width: 1000px; margin: auto;}
	th { border: 1px solid gray; padding: 5px; background-color: silver;}
	td { border: 1px solid gray; padding: 5px; }
	.title {font-size: 18pt; border: none;text-align: center;}
	.sub_title {border: none;text-align: right;}
</style>
</head>
<body>
	<%-- 넘어오는 현재페이지, 페이지사이즈, 블록 사이즈를 받아야 한다. --%>
	<jsp:useBean id="paramVO" class="kr.green.memo.vo.ParamVO"></jsp:useBean>
	<jsp:setProperty property="*" name="paramVO"/>
	<%
		// DB에서 1페이지 분량의 목록을 가져온다.
		PagingVO<MemoVO> pagingVO = 
		   MemoService.getInstance().selectList(paramVO.getCurrentPage(), paramVO.getPageSize(),paramVO.getBlockSize());
		// 글목록은 pagingVO에서 가져오자!!!!
		List<MemoVO> list = pagingVO.getList();
	%>
	<table>
		<tr>
			<td colspan="5" class="title">허접한 1줄 메모장</td>
		</tr>
		
		<tr>
			<%-- 정보 출력을 변경 --%>
			<td colspan="5" class="sub_title"><%=pagingVO.getPageInfo() %></td>
		</tr>
		<tr>
			<th width="5%">No</th>
			<th width="10%">작성자</th>
			<th>메모</th>
			<th width="15%">작성일</th>
			<th width="10%">IP</th>
		</tr>
		<%
			if(list==null || list.size()==0){
				out.println("<tr><td colspan='5' style='text-align: center;'>등록된 글이 없습니다.</td></tr>");
			}else{
				for(MemoVO vo : list){
					%>
					<tr align="center">
						<td>
							<span id="idx<%=vo.getIdx() %>"><%=vo.getIdx() %></span>
						</td>
						<td>
							<%
							// =vo.getName()
							// 태그 무시!!!
							String name = vo.getName();
							name = name.replace("<", "&lt;");
							name = name.replace(">", "&gt;");
							out.println(name);
							%>
							<xmp id="name<%=vo.getIdx() %>" style='display: none;'><%=vo.getName() %></xmp>
						</td>
						<td align="left">
							<% 
							//=vo.getContent() 
							// 태그 무시!!!
							String content = vo.getContent();
							content = content.replace("<", "&lt;");
							content = content.replace(">", "&gt;");
							out.println(content);
							%>
							<xmp id="content<%=vo.getIdx() %>"  style='display: none;'><%=vo.getContent() %></xmp>
							<%-- 수정 삭제 링크 --%>
							[<a href="javascript:editForm(<%=vo.getIdx() %>)" >Edit</a>] 
							[<a href="javascript:deleteForm(<%=vo.getIdx() %>)" >Delete</a>] 
						</td>
						<td><%=(vo.getRegDate()+"").split(" ")[1] %></td>
						<td><%=vo.getIp() %></td>
					</tr>
					<%
				}
			}
		%>
		<%-- 페이지 리스트를 출력하자 --%>
		<tr>
			<td colspan="5" style="border: none;text-align: center;"> <%=pagingVO.getPageList() %></td>
		</tr>
		<tr>
			<td colspan="5" style="border: none;">
				<%-- 글쓰기 폼을 달아보자!!! : action이 고정!!! hidden필드 mode가 추가!!!!--%>
				<hr />
				<form action="updateOk.jsp" method="post" id="updateForm">
					<%-- ------------------------------------------------------------------------------------- --%>			
					<%-- 저장/수정/삭제시 돌아올때는 현재 페이지에 머물러 있어야 한다. 그렇다면 넘겨줘야 한다. --%>
					<input type="hidden" name="p" value="<%=pagingVO.getCurrentPage() %>" />
					<input type="hidden" name="s" value="<%=pagingVO.getPageSize() %>" />
					<input type="hidden" name="b" value="<%=pagingVO.getBlockSize() %>" />
					<%-- ------------------------------------------------------------------------------------- --%>			

					<input type="hidden" id="idx" name="idx" value="0" />
					<input type="hidden" id="mode" name="mode" value="insert" />
					<input type="text" size="15" placeholder="이름입력" name="name" id="name" required="required">
					<input type="password" size="15" placeholder="암호입력" name="password" id="password" required="required">
					<input type="text" size="70" placeholder="내용입력" name="content" id="content" required="required">
					<input type="submit" id="submitBtn" value="저장하기">
					<input type="button" id="cancelBtn" value="취소하기" style="display: none;" onclick="resetForm()"/>
				</form>
				<hr />
			</td>
		</tr>
		
	</table>
</body>
</html>