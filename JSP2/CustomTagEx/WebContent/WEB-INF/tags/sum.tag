<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 속성의 생성 --%>
<%@ attribute name="start" required="true" type="java.lang.Integer" %>
<%@ attribute name="end" required="true" type="java.lang.Integer" %>
<%-- 변수의 생성 : 변수의 이름은 sum이고 타입은 정수이며 태그의 안에서만 사용 가능하다. --%>
<%@ variable name-given="sum" variable-class="java.lang.Integer" scope="NESTED" %>
<%-- JSTL 사용 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="${start }" end="${end }" >
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>
<jsp:doBody/>
