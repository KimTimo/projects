<%@page import="kr.green.ibatis.IbatisApp"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
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
	SqlMapClient sqlMapClient = IbatisApp.getSqlMapClient();
	System.out.println("연결 성공 : " + sqlMapClient);
	// 트랜젝션 처리
	try {
		// 1 . 트랜젝션 시작
		sqlMapClient.startTransaction();
		
		String today = (String) sqlMapClient.queryForObject("test.now");
		out.println("DB 서버 시간 : " + today + "<br>");
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("num1", 12);
		map.put("num2", 6);
		map.put("num3", 10);
		
		int result = (int) sqlMapClient.queryForObject("test.calc", map);
		out.println("계산 결과 : " + result  + "<br>");
		
		// 2. 트랜젝션 적용
		sqlMapClient.commitTransaction();
	} catch (SQLException e) {
		// 전에는 여기에서 rollback을 해주었다. 
		e.printStackTrace();
	} finally {
		// 3. 트랜젝션 종료
		try {
			sqlMapClient.endTransaction(); // commitTransaction()이 실행되지 않았으면 자동으로 rollback을 수행한다.
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}		
	
	%>
</body>
</html>