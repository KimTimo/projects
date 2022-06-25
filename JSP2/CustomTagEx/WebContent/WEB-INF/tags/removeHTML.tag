<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true"%>
<%@ attribute name="length" type="java.lang.Integer" %>
<%@ attribute name="tail" %>
<%@ attribute name="trim" %>
<jsp:doBody var="content" scope="page"/>
<%
	String content = (String)jspContext.getAttribute("content");
	if(trim!=null && trim.equals("true"))	content = content.trim(); // 좌우의 공백 제거
	content = content.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*)?>",""); // 모든 태그를 지우는 정규 표현식
	if(length!=null && length.intValue()>0 && content.length()>length.intValue()){ // 길이가 있고 길이보다 길다면
		content = content.substring(0, length.intValue()); // 길이만큼 잘라내고
		if(trim!=null) content += tail; // tail이 있다면 뒤에 붙여준다.
	}
	out.println(content); // 출력
%>

