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
	// 만화책 종류 : sid
	// https://sports.khan.co.kr/comics/comics_view.html?sid=845
	int sid = 4001;
	// 몇권 : volume
	Document doc1 = Jsoup.connect("https://sports.khan.co.kr/comics/comics_view.html?sid="+sid).get();
	Elements es1 = doc1.select("div.page_num a");
	out.println(es1.size() + "권<br><hr>");
	int lastVolume = es1.size();
	// out.println(span.get(0).text() + "<br><hr>");
	
	for(int i=1;i<=lastVolume;i++){ // 권
	
		String urlAddress = "https://sports.khan.co.kr/comics/comics_frame.html?" + String.format("sid=%d&volume=%d", sid, i);
		Document doc = Jsoup.connect(urlAddress).get();
		Elements elements = doc.select(".viewHeader div.title h4");
		// out.println(elements.size() + "개<br><hr>");
		out.println("<h1>" + elements.get(0).text() + "</h1><hr>");
		String imageName = "https://images.khan.co.kr/freecomics/"; // "0845/001/001.jpg"
		
		Elements span = doc.select("span.total"); // 마지막 이미지 번호
		// out.println(span.size() + "개<br><hr>");
		// out.println(span.get(0).text() + "<br><hr>");
		// out.println(span.get(0).text().substring(1) + "<br><hr>");
		int pageSize = Integer.parseInt(span.get(0).text().substring(1));
		for(int j=1;j<=pageSize;j++){ // 권당 이미지 갯수
			// out.println("이미지 주소 : " + imageName + String.format("%04d/%03d/%03d.jpg",sid, i, j) + "<br>");
			out.println("<img src='" + imageName + String.format("%04d/%03d/%03d.jpg",sid, i, j) + "'><br>");
		}
	}
	
%>

</body>
</html>