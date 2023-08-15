<%@page import="java.util.Calendar"%>
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
		$("#yy").change(function() {
			var yy = $("#yy").val();
			var mm = $("#mm").val();
			location.href="?yy="+yy+"&mm="+mm
		});
		$("#mm").change(function() {
			var yy = $("#yy").val();
			var mm = $("#mm").val();
			location.href="?yy="+yy+"&mm="+mm
		});
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
	<%
		// 주소 표시줄에 다음과 같이 입력해야 결과가 보인다.
		// http://localhost:8080/HTMLParserEx/index3.jsp?yy=1391&mm=2
		// http://localhost:8080/HTMLParserEx/index3.jsp?yy=2050&mm=12
		
		// 1. 연결할 주소
		String urlAddress = "https://astro.kasi.re.kr/life/pageView/5";
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		// 인수로 넘어온 값을 정수로 바꿔서 저장을 하자 
		try{
			year  = Integer.parseInt(request.getParameter("yy"));
			month = Integer.parseInt(request.getParameter("mm"));
		}catch(Exception e){
			// 에러가 발생하면 아무짓도 하지 않는다.
			;
		}
		// 유효한 년월이 아니면 현재 년월을 가지게 하자!! 
		if(year<1 || year>2050 || month<1 || month>12){
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH)+1;
		}
		// 입력범위 : 양력 1391년 2월 ~ 2050년 12월
		String temp = String.format("%04d%02d", year, month);
		if(temp.compareTo("139102")<0 || temp.compareTo("205012")>0){
			// 입력 범위를 넘겼다면 현재 년월을 가지게 하자!! 
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH)+1;
		}
		request.setAttribute("year", year);
		request.setAttribute("month", month);
	%>
		<select name="yy" id="yy">
			<c:forEach var="i" begin="${year-10 }" end="${year+10}">
				<c:if test="${year==i }">
					<option value="${i }" selected="selected">${i } 년</option>
				</c:if>
				<c:if test="${year!=i }">
					<option value="${i }">${i } 년</option>
				</c:if>
			</c:forEach>
		</select>
		
		<select name="mm" id="mm">
			<c:forEach var="i" begin="1" end="12">
				<c:if test="${month==i }">
					<option value="${i }" selected="selected">${i } 월</option>
				</c:if>
				<c:if test="${month!=i }">
					<option value="${i }">${i } 월</option>
				</c:if>
			</c:forEach>
		</select>
	<%	
		urlAddress += String.format("?search_year=%04d&search_month=%02d", year, month);
		
		// 2. URL에서 원하는 문서를 읽어온다.
		Document doc = Jsoup.connect(urlAddress).get();
		out.println(String.format("%04d년 %02d월 음양력 대조표", year, month));
		out.println("<hr>");
		// 4. 현재문서에서 table태그를 찾고 첫번째 테이블의 html내용을 읽어서 가져온다.
		out.println("<table border='1'>");
		out.println(doc.select("table thead").get(0).html());
		out.println(doc.select("table tbody").get(0).html());
		out.println("</table>");
	%>
</body>
</html>