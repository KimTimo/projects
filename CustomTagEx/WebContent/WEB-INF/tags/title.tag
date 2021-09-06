<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%-- fragment="true" : JSP 액션태그를 이용하여 속성값을 전달 하겠다. --%>
<%@ attribute name="title" required="true" fragment="true"%>
<%-- jsp:attribute 의 몸체 내용을 그대로 출력  --%>
<h1><jsp:invoke fragment="title"/></h1>
<%-- jsp:attribute 의 몸체 내용을 변수에 저장  --%>
<jsp:invoke fragment="title" var="t" scope="page"/>
<h2>${t}</h2>
<hr/>