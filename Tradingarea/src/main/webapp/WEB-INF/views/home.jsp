<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d8453d3d027fd23b918e1436eaea4d3"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
	<P>  The time on the server is ${serverTime}. </P>
	<a href="test">테스트하기</a>
	<a href="login">로그인하기</a>
	
	
	<div id="map" style="width:750px;height:400px;"></div>
</body>
</html>
