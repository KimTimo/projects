<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 새글쓰기</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<!-- CDN 한글화 -->
<script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		$('#content').summernote(
				{
					lang : 'ko-KR', // default: 'en-US'
					height : 300, // set editor height
					minHeight : null, // set minimum height of editor
					maxHeight : null, // set maximum height of editor
					fontNames : [ '맑은고딕', 'Arial', 'Arial Black',
							'Comic Sans MS', 'Courier New', ],
					fontNamesIgnoreCheck : [ '맑은고딕' ],
					focus : true,
					callbacks : {
						onImageUpload : function(files, editor, welEditable) {
							for (var i = files.length - 1; i >= 0; i--) {
								sendFile(files[i], this);
							}
						}
					}
				});
	});
	function sendFile(file, el) {
		var form_data = new FormData();
      	form_data.append('file', file);
      	$.ajax({
        	data: form_data,
        	type: "POST",
        	url: 'imageUpload.jsp',
        	cache: false,
        	contentType: false,
        	enctype: 'multipart/form-data',
        	processData: false,
        	success: function(img_name) {
          		$(el).summernote('editor.insertImage', img_name);
        	},
        	error : function(){
        		alert('에러!!!');
        	}
      	});
    }
</script>
<style type="text/css">
	* { font-size: 10pt; }
	table#main_content{width: 80%; margin: auto;}
	th {border: 1px solid gray; background-color: silver;padding: 5px; text-align: center;}
	td {border: 1px solid gray; padding: 5px;}
	td.title {border:none; padding: 5px; text-align: center; font-size: 18pt;}
	td.info {border:none; padding: 5px; text-align: right; }
	td.info2 {border: 1px solid gray; padding: 5px; text-align: center; }
</style>
</head>
<body>
	<%-- 페이지번호 받기 --%>
	<jsp:useBean id="cv" class="kr.green.file.vo.CommVO" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="cv"/>
	<%-- ${cv } --%>
	<form action="insertOk.jsp" method="post" enctype="multipart/form-data" >
		<table id="main_content">
			<tr>
				<td colspan="4" class="title" >자료실 새글쓰기</td>
			</tr>
			<tr>
				<th>이름</th>
				<td> 
					<input type="text" id="name" name="name" size="30" />
				</td>
				<th>비번</th>
				<td> 
					<input type="password" id="password" name="password" size="30" />
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3"> 
					<input type="text" id="subject" name=""subject"" size="140" />
				</td>
			</tr>
			<tr>
				<th valign="top">내용</th>
				<td colspan="3"> 
					<textarea name="content" id="content" cols="135" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<th valign="top">자료</th>
				<td colspan="3"> 
					<input type="button" value=" + " class="btn btn-outline-success btn-sm" style="margin-bottom: 5px;" />
					<input type="button" value=" - " class="btn btn-outline-success btn-sm" style="margin-bottom: 5px;"/> <br />
					<div id="filebox1"> <input type="file" name="upfile"/> </div>
				</td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>