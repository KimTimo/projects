<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 원래 타이틀을 []로 감싸라 -->
<title>[<sitemesh:write property='title' />]
</title>
<!-- Core theme CSS (includes Bootstrap)-->
<link href="resources/css/styles.css" rel="stylesheet" />
<link href="resources/css/map.css" rel="stylesheet" />

<!-- axicon 사용하기 -->
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/resources/axicon/axicon.min.css" />

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d8453d3d027fd23b918e1436eaea4d3"></script>

<!-- Jquery사용하기 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>

<!-- Bootstrap사용하기 -->
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->

<script src="resources/js/scripts.js"></script>



<!-- 헤더 태그안의 모든 내용을 여기에 넣어라 -->
<sitemesh:write property='head' />
</head>
<body id="page-top">


	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<div class="container px-4">
			<a class="navbar-brand" href="#page-top">상권찾자</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<!--  <li class="nav-item"><a class="nav-link" href="#about">About</a></li>-->
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/login">로그인</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/join">회원가입</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/findUserId">아이디찾기</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/findPassword">비밀번호찾기</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/list">게시판</a></li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath }/">홈으로</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Header-->
	<header class="bg-primary bg-gradient text-white">
            <div class="container px-4 text-center">
            <br><br><br>
                <h1 class="fw-bolder">찾아보자 상권정보!</h1>
                <a class="btn btn-lg btn-light" href="#about">START!</a>
            </div>
       </header>


	<!-- 메인컨텐츠가 보여질 영역 -->
	<section id="about">
		<div class="container px-4">
			<div class="row gx-4 justify-content-center">
				<div class="col-lg-8">
					<sitemesh:write property='body' />
					
				</div>
			</div>
		</div>
	</section>


	<!-- 서브영역 시작 -->
	<!-- Contact section-->
	<section id="contact">
		<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="미금역" id="keyword" size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
       	<ul id="placesList"></ul>
       	 	<div id="pagination"></div>
    	</div>
	</div>
	</section>
	

	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container px-4">
			<p class="m-0 text-center text-white">Copyright &copy; Your	Website 2021<br/>
			</p>
		</div>
	</footer>
	
	<!-- 카카오맵 -->
	<script type="text/javascript" src="resources/js/map.js"></script>
</body>
</html>