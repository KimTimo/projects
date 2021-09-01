<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
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
	// out.println(es1.size() + "권<br><hr>");
	int lastVolume = es1.size();
	
	// sid이름으로 폴더가 없다면 폴더를 자동으로 만들어 준다.
	String book = application.getRealPath("/" + sid + "/");
	File file = new File(book);
	if(!file.exists()){
		file.mkdir();
		//System.out.println( file.getAbsolutePath() + " 폴더 생성");
	}
	
	for(int i=1;i<=lastVolume;i++){ // 권
		// sid/00? 모양으로 권별마다 폴더를 없으면 만들어준다.
		book = application.getRealPath("/" + sid + "/" + String.format("%03d", i) + "/");
		file = new File(book);
		if(!file.exists()){
			file.mkdir();
			// System.out.println( file.getAbsolutePath() + " 폴더 생성");
		}
		
		String urlAddress = "https://sports.khan.co.kr/comics/comics_frame.html?" + String.format("sid=%d&volume=%d", sid, i);
		Document doc = Jsoup.connect(urlAddress).get();
		Elements elements = doc.select(".viewHeader div.title h4");
		// out.println(elements.size() + "개<br><hr>");
		// out.println("<h1>" + elements.get(0).text() + "</h1><hr>");
		String imageName = "https://images.khan.co.kr/freecomics/"; // "0845/001/001.jpg"
		
		Elements span = doc.select("span.total"); // 마지막 이미지 번호

		int pageSize = Integer.parseInt(span.get(0).text().substring(1));
		for(int j=1;j<=pageSize;j++){ // 권당 이미지 갯수
			// out.println("이미지 주소 : " + imageName + String.format("%04d/%03d/%03d.jpg",sid, i, j) + "<br>");
			// out.println("<img src='" + imageName + String.format("%04d/%03d/%03d.jpg",sid, i, j) + "'><br>");
			// 이미지 파일을 저장해보자
			String path = application.getRealPath(String.format("/%d/%03d/%03d.jpg",sid, i, j));
			FileOutputStream fos = new FileOutputStream(path);
			String imageURL = imageName + String.format("%04d/%03d/%03d.jpg",sid, i, j);
			URL url = new URL(imageURL);
			byte[] data = new byte[1024];
			InputStream is = url.openStream();
			int length = 0;
			while((length=is.read(data))>0){
				fos.write(data, 0, length);
			}
			is.close();
			fos.close();
			out.println(imageURL + "로 저장 완료!!!<br>");
		}
		out.println(i + "권 저장 완료!!!<br>");
		
	}
%>

</body>
</html>