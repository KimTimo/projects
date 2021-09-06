<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ attribute name="length" type="java.lang.Integer" %>
<%@ attribute name="tail" %>
<%@ attribute name="trim" %>
<%-- 변수 설정 --%>
<%@ attribute name="var" type="java.lang.String" rtexprvalue="false" required="true" %>
<%-- 태그의 var속성의 값을 변수로 사용하겠다. 여기서는 대신 result를 이용하겠다 --%>
<%@ variable name-from-attribute="var" alias="result" variable-class="java.lang.String" scope="AT_END"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:doBody var="content" scope="page"/>
<%
	String content = (String)jspContext.getAttribute("content");
	if(trim!=null && trim.equals("true"))	content = content.trim(); // 좌우의 공백 제거
	content = content.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*)?>",""); // 모든 태그를 지우는 정규 표현식
	if(length!=null && length.intValue()>0 && content.length()>length.intValue()){ // 길이가 있고 길이보다 길다면
		content = content.substring(0, length.intValue()); // 길이만큼 잘라내고
		if(trim!=null) content += tail; // tail이 있다면 뒤에 붙여준다.
	}
%>
<%-- 처리 결과를 result에저장하면 사용하는 쪽에서는 var속성의 값으로 접근이 가능하다. --%>
<c:set var="result" value="<%=content %>"/>

