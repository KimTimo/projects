<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var memo = [];
<%

	if(session.getAttribute("memo")!=null){
		List<String> list = (List<String>)session.getAttribute("memo");
		for(String m : list){
			out.println("memo.push('" + m + "')");
		}
	}
%>
	
</script>
<script>
	$(function(){
		if(memo.length==0){
			$("#contentList").html("등록된 글이 없습니다.");
		}else{
			$("#contentList").html( memo.length +  "개");
			$.each(memo, function(i, elt) {
				$("#contentList").append("<br>" + elt);
			});
			$("#memo").val("");
		}
		$("#memo").focus(); // 커서를 memo로 보낸다.
		
		$("#saveBtn").click(function(){
			var value = $("#memo").val();
			if(value!=null && value.trim().length>0){
				// 내용이 있으면 Ajax를 이용하여 세션에 저장하고 화면을 갱신한다.
				$.ajax({
					url : 'memoOk.jsp',
					method : "post",
					data :{"data":value},
					dataType:"json",
					success : function(data){
						$("#contentList").html( data['list'].length +  "개");
						$.each(data['list'], function(i, elt) {
							$("#contentList").append("<br>" + elt);
						});
						$("#memo").val("");
						$("#memo").focus();
					}
				});
			}else{
				// 없으면 커서를 memo로 보낸다.
				$("#memo").val("");
				$("#memo").focus();
			}
		});
	});
</script>
</head>
<body>
	<input type="text" id="memo" size="30"/><button id="saveBtn">저장</button><br /><hr />
	<div id="contentList"></div>
</body>
</html>