<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ attribute name="name" required="true" %>
<%-- 필수 이외의 속성들을 맵으로 받겠다. 변수의이름은 map으로 사용하겠다. --%>
<%@ tag dynamic-attributes="map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name }">
	<c:forEach var="option" items="${map }">
		<option value="${option.key }">${option.value}</option>
	</c:forEach>
</select>	

