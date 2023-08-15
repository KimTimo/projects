<%@page import="kr.green.category.vo.TestVO"%>
<%@page import="kr.green.category.service.TestService"%>
<%@page import="kr.green.mybatis.MybatisApp"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.ibatis.common.resources.Resources"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	// 서비스를 이용하여 원하는 결과를 얻어온다.
	Date today = TestService.getInstance().getToday();
	int result = TestService.getInstance().getCalc(1, 2, 3);
	TestVO testVO = TestService.getInstance().getTestVO(1, 2, 3, "한사람");
	HashMap<String, Object> hashMap = TestService.getInstance().getHashMap(2, 3, 4, "두사람");
	// 출력을 EL로 하기 위하여 특정 영역에 저장을 한다.
	request.setAttribute("today", today);
	request.setAttribute("result", result);
	request.setAttribute("testVO", testVO);
	request.setAttribute("hashMap", hashMap);
	%>
	
	<h2>서버시간 : ${today }</h2>
	<h2>서버시간 : <fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full"/> </h2>
	<br />
	<h2>계산 결과 : ${result }</h2>
	<br />
	<h2>VO로 받은 내용 : ${testVO }</h2>
	<h2>VO로 받은 내용 1: ${testVO.today }</h2>
	<h2>VO로 받은 내용 2: ${testVO.result }</h2>
	<h2>VO로 받은 내용 3: ${testVO.message }</h2>
	<br />
	<h2>HashMap로 받은 내용 : ${hashMap }</h2>
	<h2>HashMap로 받은 내용 1: ${hashMap.TODAY }</h2>
	<h2>HashMap로 받은 내용 2: ${hashMap.RESULT }</h2>
	<h2>HashMap로 받은 내용 3: ${hashMap.MESSAGE }</h2>
</body>
</html>