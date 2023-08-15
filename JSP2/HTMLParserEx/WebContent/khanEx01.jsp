<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.nodes.Element"%>
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
</head>
<body>
<%
	String baseUrl = "https://sports.khan.co.kr/";
	String urlAddress = "https://sports.khan.co.kr/comics/comics_author.html";
	Document doc = Jsoup.connect(urlAddress).get();
	
	for(int i=1;i<=4;i++){
		Elements author1 = doc.select("div#author" + i);
		for(Element e1 : author1){
			Elements ulList = e1.select("div.writer_list ul");
			for(Element e2 : ulList){
				Elements lis = e2.select("li");
				for(Element e3 : lis){
					out.println(e3.select("a").get(0).attr("href") + "<br>");
					out.println("<img src='https:" + e3.select("img").get(0).attr("src") + "'><br>");
					//out.println(e3.select("img").get(0).attr("src") + "<br><hr>");
				}
				//out.println("----------------------<br>");
			}
		}
		//out.println("=======================================================================<br>");
	}
%>

</body>
</html>