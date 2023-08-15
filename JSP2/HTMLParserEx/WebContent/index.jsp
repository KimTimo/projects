<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기에 제목</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/comm.js"></script>
<script>
	$(function(){
		
	});
</script>
<style type="text/css">
	table { border: 1px solid gray; width: 80%; margin: auto;}
	td, th { border: 1px solid gray; padding:5px; text-align: center;}
</style>
</head>
<body>
	<h1>HTML을 파싱해보자!!!</h1>
	<hr />
	<h3>음양력 대조표</h3>
	<hr />
	<%
		// 1. 연결할 주소
		String urlAddress = "https://astro.kasi.re.kr/life/pageView/5";
		// 2. URL에서 원하는 문서를 읽어온다.
		Document doc = Jsoup.connect(urlAddress).get();
		// 3. 읽어온 문서의 제목을 출력한다. head > title 태그의 값을 읽어온다.
		out.println(doc.title() + "<br>");
		out.println("<hr>");
		// 4. 현재문서에서 table태그를 찾고 첫번째 테이블의 html내용을 읽어서 가져온다.
		out.println("<table border='1'>"  + doc.select("table").get(0).html() + "</table>");
	%>
</body>
</html>