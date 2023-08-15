<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
// 페이지를 받자!!!
int p = 1;
try{
	// 받아서 정수로 변환 
	p = Integer.parseInt(request.getParameter("p"));
}catch(Exception e){
	; // 에러가 발생하면 1페이지를 가진다.
}
if(p<1 || p>100) p = 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
<script>
	$(function() {
		sendData(<%=p%>); // 실행시 현재 페이지 요청해서 보이기
	});

	function sendData(pageNo) {
		const xhttp = new XMLHttpRequest(); // 1. Ajax 객체 생성
		//---------------------------------------------------------------------------
		xhttp.onreadystatechange = function() { // 2. 콜백 지정
			if (this.readyState == 4 && this.status == 200) {
				var txt=''
				$.each(JSON.parse(this.responseText), function(i, item) {
					txt += '<div class="item">';
					txt += item["h"] + "<br>" ;
					txt += "<span style='font-size:9pt;'>" + item["m1"] + "</span>" ;
					txt += '</div>';
				})
				document.getElementById("content").innerHTML = txt;
			}
		}
		//---------------------------------------------------------------------------
		xhttp.open("GET", "hanjaList.jsp?p=" + pageNo); // 3. 요청 준비
		xhttp.send(); // 4. 요청
	}
</script>
<style type="text/css">
#content {
	padding: 10px;
}

.item {
	border: 1px solid gray;
	padding: 10px;
	width: 100px;
	height: 85px;
	border-radius: 30px;
	text-align: center;
	margin: 5px;
	float: left;
	font-size: 15pt;
}
</style>
</head>
<body>
	<h1>천자문 보기 프로그램</h1>	
	<div style="text-align: right;"> 현재페이지 : <%=p %>/100Page</div>
	<hr />
	<div id="content">

	</div>
	<br  style="clear: both" />
	<hr style="clear: both" />
	<!-- 페이지 이동 -->
	<div>
		<nav>
		  <ul class="pagination pagination-sm justify-content-center">
		  	<%-- 이전 : 현재 페이지가 10보다 크다면 이전이 있다 --%>
		  	<% if(p>10){ %>
		    <li class="page-item">
		      <a class="page-link" href="?p=<%=(p-1)/10*10 %>" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <% } %>
		    <%-- 페이지 : 시작페이지 번호부터 끝페이지 번호까지 페이지 번호 출력 --%>
		   	<% for(int i=(p-1)/10*10+1;i<=(p-1)/10*10+10;i++){ %>
		   		<%-- 현재 페이지는 링크를 걸지 않고 활성화 시킨다.   --%>
		   		<% if(i==p){ %>
			    	<li class="page-item active" aria-current="page"><span class="page-link"><%=i %></span></li>
			    <% }else{ %>
			    	<li class="page-item"><a class="page-link" href="?p=<%=i %>"><%=i %></a></li>
			    <% } %>
		    <% } %>
		  	<%-- 다음 : 현재 페이지가 91보다 적다면 다음이 있다 --%>
		  	<% if(p<91){ %>
		    <li class="page-item">
		      <a class="page-link" href="?p=<%=(p-1)/10*10+11 %>" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		    <% } %>
		  </ul>
		</nav>	
	</div>
</body>
</html>