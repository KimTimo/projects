<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<script type="text/javascript">
	function fileDown(ofile, sfile){
		location.href="download?of=" + encodeURI(ofile) + "&sf=" +  encodeURI(sfile)
	}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  현재시간 : ${today}. </P>
<P>  덧셈 : ${sum} </P>
<P>  곱셈 : ${mul} </P>
<hr />
<a href="javascript:fileDown('강아지.jpg','2.jpg')">
	<img src="${pageContext.request.contextPath }/upload/2.jpg" alt="시무룩한 강아지"  title="시무룩한 강아지" />
</a>
<br /><br />
<button onclick="fileDown('애국가.txt','song.txt')">애국가 다운로드</button>
<br /><br />
<a href='<c:url value="/"/>'>홈으로</a>
</body>
</html>
