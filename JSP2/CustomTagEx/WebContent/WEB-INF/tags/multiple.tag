<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- 넘어온 값을 count만큼 반복으로 출력하는 태그 --%>
<%-- 카운트 속성필수. 정수타입 --%>
<%@ attribute name="count" required="true" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach begin="1" end="${count }">
	<jsp:doBody/>
</c:forEach>